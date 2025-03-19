package tech.gusavila92.websocketclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import tech.gusavila92.apache.commons.codec.binary.Base64;
import tech.gusavila92.apache.commons.codec.digest.DigestUtils;
import tech.gusavila92.apache.http.Header;
import tech.gusavila92.apache.http.HttpException;
import tech.gusavila92.apache.http.HttpHeaders;
import tech.gusavila92.apache.http.HttpResponse;
import tech.gusavila92.apache.http.StatusLine;
import tech.gusavila92.apache.http.impl.io.DefaultHttpResponseParser;
import tech.gusavila92.apache.http.impl.io.HttpTransportMetricsImpl;
import tech.gusavila92.apache.http.impl.io.SessionInputBufferImpl;
import tech.gusavila92.apache.http.protocol.HTTP;
import tech.gusavila92.websocketclient.common.Utils;
import tech.gusavila92.websocketclient.exceptions.IllegalSchemeException;
import tech.gusavila92.websocketclient.exceptions.InvalidServerHandshakeException;
import tech.gusavila92.websocketclient.exceptions.UnknownOpcodeException;
import tech.gusavila92.websocketclient.model.Payload;

/* loaded from: classes2.dex */
public abstract class WebSocketClient {
    private static final String GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final int OPCODE_BINARY = 2;
    private static final int OPCODE_CLOSE = 8;
    private static final int OPCODE_CONTINUATION = 0;
    private static final int OPCODE_PING = 9;
    private static final int OPCODE_PONG = 10;
    private static final int OPCODE_TEXT = 1;
    private volatile Thread reconnectionThread;
    private final URI uri;
    private SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    private final Object globalLock = new Object();
    private final SecureRandom secureRandom = new SecureRandom();
    private int connectTimeout = 0;
    private int readTimeout = 0;
    private boolean automaticReconnection = false;
    private long waitTimeBeforeReconnection = 0;
    private volatile boolean isRunning = false;
    private Map<String, String> headers = new HashMap();
    private volatile WebSocketConnection webSocketConnection = new WebSocketConnection();

    public abstract void onBinaryReceived(byte[] bArr);

    public abstract void onCloseReceived();

    public abstract void onException(Exception exc);

    public abstract void onOpen();

    public abstract void onPingReceived(byte[] bArr);

    public abstract void onPongReceived(byte[] bArr);

    public abstract void onTextReceived(String str);

    public WebSocketClient(URI uri) {
        this.uri = uri;
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.socketFactory = sSLSocketFactory;
    }

    public void addHeader(String str, String str2) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                throw new IllegalStateException("Cannot add header while WebSocketClient is running");
            }
            this.headers.put(str, str2);
        }
    }

    public void setConnectTimeout(int i) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                throw new IllegalStateException("Cannot set connect timeout while WebSocketClient is running");
            }
            if (i < 0) {
                throw new IllegalStateException("Connect timeout must be greater or equal than zero");
            }
            this.connectTimeout = i;
        }
    }

    public void setReadTimeout(int i) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                throw new IllegalStateException("Cannot set read timeout while WebSocketClient is running");
            }
            if (i < 0) {
                throw new IllegalStateException("Read timeout must be greater or equal than zero");
            }
            this.readTimeout = i;
        }
    }

    public void enableAutomaticReconnection(long j) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                throw new IllegalStateException("Cannot enable automatic reconnection while WebSocketClient is running");
            }
            if (j < 0) {
                throw new IllegalStateException("Wait time between reconnections must be greater or equal than zero");
            }
            this.automaticReconnection = true;
            this.waitTimeBeforeReconnection = j;
        }
    }

    public void disableAutomaticReconnection() {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                throw new IllegalStateException("Cannot disable automatic reconnection while WebSocketClient is running");
            }
            this.automaticReconnection = false;
        }
    }

    public void connect() {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                throw new IllegalStateException("WebSocketClient is not reusable");
            }
            this.isRunning = true;
            createAndStartConnectionThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndStartConnectionThread() {
        new Thread(new Runnable() { // from class: tech.gusavila92.websocketclient.WebSocketClient.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebSocketClient.this.webSocketConnection.createAndConnectTCPSocket()) {
                        WebSocketClient.this.webSocketConnection.startConnection();
                    }
                } catch (Exception e) {
                    synchronized (WebSocketClient.this.globalLock) {
                        if (WebSocketClient.this.isRunning) {
                            WebSocketClient.this.webSocketConnection.closeInternal();
                            WebSocketClient.this.onException(e);
                            if ((e instanceof IOException) && WebSocketClient.this.automaticReconnection) {
                                WebSocketClient.this.createAndStartReconnectionThread();
                            }
                        }
                    }
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndStartReconnectionThread() {
        this.reconnectionThread = new Thread(new Runnable() { // from class: tech.gusavila92.websocketclient.WebSocketClient.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(WebSocketClient.this.waitTimeBeforeReconnection);
                    synchronized (WebSocketClient.this.globalLock) {
                        if (WebSocketClient.this.isRunning) {
                            WebSocketClient.this.webSocketConnection = new WebSocketConnection();
                            WebSocketClient.this.createAndStartConnectionThread();
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
        });
        this.reconnectionThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnOpen() {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                onOpen();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnTextReceived(String str) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                onTextReceived(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnBinaryReceived(byte[] bArr) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                onBinaryReceived(bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnPingReceived(byte[] bArr) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                onPingReceived(bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnPongReceived(byte[] bArr) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                onPongReceived(bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnException(Exception exc) {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                onException(exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnCloseReceived() {
        synchronized (this.globalLock) {
            if (this.isRunning) {
                onCloseReceived();
            }
        }
    }

    public void send(String str) {
        final Payload payload = new Payload(1, str.getBytes(Charset.forName("UTF-8")));
        new Thread(new Runnable() { // from class: tech.gusavila92.websocketclient.WebSocketClient.3
            @Override // java.lang.Runnable
            public void run() {
                WebSocketClient.this.webSocketConnection.sendInternal(payload);
            }
        }).start();
    }

    public void send(byte[] bArr) {
        final Payload payload = new Payload(2, bArr);
        new Thread(new Runnable() { // from class: tech.gusavila92.websocketclient.WebSocketClient.4
            @Override // java.lang.Runnable
            public void run() {
                WebSocketClient.this.webSocketConnection.sendInternal(payload);
            }
        }).start();
    }

    public void sendPing(byte[] bArr) {
        final Payload payload = new Payload(9, bArr);
        new Thread(new Runnable() { // from class: tech.gusavila92.websocketclient.WebSocketClient.5
            @Override // java.lang.Runnable
            public void run() {
                WebSocketClient.this.webSocketConnection.sendInternal(payload);
            }
        }).start();
    }

    public void sendPong(byte[] bArr) {
        final Payload payload = new Payload(10, bArr);
        new Thread(new Runnable() { // from class: tech.gusavila92.websocketclient.WebSocketClient.6
            @Override // java.lang.Runnable
            public void run() {
                WebSocketClient.this.webSocketConnection.sendInternal(payload);
            }
        }).start();
    }

    public void close() {
        new Thread(new Runnable() { // from class: tech.gusavila92.websocketclient.WebSocketClient.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (WebSocketClient.this.globalLock) {
                    WebSocketClient.this.isRunning = false;
                    if (WebSocketClient.this.reconnectionThread != null) {
                        WebSocketClient.this.reconnectionThread.interrupt();
                    }
                    WebSocketClient.this.webSocketConnection.closeInternal();
                }
            }
        }).start();
    }

    private class WebSocketConnection {
        private BufferedInputStream bis;
        private BufferedOutputStream bos;
        private final Object internalLock;
        private volatile boolean isClosed;
        private final LinkedList<Payload> outBuffer;
        private volatile boolean pendingMessages;
        private Socket socket;
        private final Thread writerThread;

        private WebSocketConnection() {
            this.pendingMessages = false;
            this.isClosed = false;
            this.outBuffer = new LinkedList<>();
            this.internalLock = new Object();
            this.writerThread = new Thread(new Runnable() { // from class: tech.gusavila92.websocketclient.WebSocketClient.WebSocketConnection.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (WebSocketConnection.this.internalLock) {
                        while (true) {
                            if (!WebSocketConnection.this.pendingMessages) {
                                try {
                                    WebSocketConnection.this.internalLock.wait();
                                } catch (InterruptedException unused) {
                                }
                            }
                            WebSocketConnection.this.pendingMessages = false;
                            if (!WebSocketConnection.this.socket.isClosed()) {
                                while (WebSocketConnection.this.outBuffer.size() > 0) {
                                    Payload payload = (Payload) WebSocketConnection.this.outBuffer.removeFirst();
                                    try {
                                        WebSocketConnection.this.send(payload.getOpcode(), payload.getData());
                                    } catch (IOException unused2) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean createAndConnectTCPSocket() throws IOException {
            synchronized (this.internalLock) {
                if (this.isClosed) {
                    return false;
                }
                String scheme = WebSocketClient.this.uri.getScheme();
                int port = WebSocketClient.this.uri.getPort();
                if (scheme != null) {
                    if (scheme.equals("ws")) {
                        Socket createSocket = SocketFactory.getDefault().createSocket();
                        this.socket = createSocket;
                        createSocket.setSoTimeout(WebSocketClient.this.readTimeout);
                        if (port != -1) {
                            this.socket.connect(new InetSocketAddress(WebSocketClient.this.uri.getHost(), port), WebSocketClient.this.connectTimeout);
                        } else {
                            this.socket.connect(new InetSocketAddress(WebSocketClient.this.uri.getHost(), 80), WebSocketClient.this.connectTimeout);
                        }
                    } else if (scheme.equals("wss")) {
                        Socket createSocket2 = WebSocketClient.this.socketFactory.createSocket();
                        this.socket = createSocket2;
                        createSocket2.setSoTimeout(WebSocketClient.this.readTimeout);
                        if (port != -1) {
                            this.socket.connect(new InetSocketAddress(WebSocketClient.this.uri.getHost(), port), WebSocketClient.this.connectTimeout);
                        } else {
                            this.socket.connect(new InetSocketAddress(WebSocketClient.this.uri.getHost(), 443), WebSocketClient.this.connectTimeout);
                        }
                    } else {
                        throw new IllegalSchemeException("The scheme component of the URI should be ws or wss");
                    }
                    return true;
                }
                throw new IllegalSchemeException("The scheme component of the URI cannot be null");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startConnection() throws IOException {
            this.bos = new BufferedOutputStream(this.socket.getOutputStream(), 65536);
            byte[] bArr = new byte[16];
            new Random().nextBytes(bArr);
            String encodeBase64String = Base64.encodeBase64String(bArr);
            this.bos.write(createHandshake(encodeBase64String));
            this.bos.flush();
            verifyServerHandshake(this.socket.getInputStream(), encodeBase64String);
            this.writerThread.start();
            WebSocketClient.this.notifyOnOpen();
            this.bis = new BufferedInputStream(this.socket.getInputStream(), 65536);
            read();
        }

        private byte[] createHandshake(String str) {
            StringBuilder sb = new StringBuilder();
            String rawPath = WebSocketClient.this.uri.getRawPath();
            String rawQuery = WebSocketClient.this.uri.getRawQuery();
            if (rawQuery != null) {
                rawPath = rawPath + "?" + rawQuery;
            }
            sb.append("GET " + rawPath + " HTTP/1.1");
            sb.append("\r\n");
            sb.append("Host: " + (WebSocketClient.this.uri.getPort() == -1 ? WebSocketClient.this.uri.getHost() : WebSocketClient.this.uri.getHost() + ":" + WebSocketClient.this.uri.getPort()));
            sb.append("\r\nUpgrade: websocket\r\nConnection: Upgrade\r\n");
            sb.append("Sec-WebSocket-Key: " + str);
            sb.append("\r\nSec-WebSocket-Version: 13\r\n");
            for (Map.Entry entry : WebSocketClient.this.headers.entrySet()) {
                sb.append(((String) entry.getKey()) + ": " + ((String) entry.getValue()));
                sb.append("\r\n");
            }
            sb.append("\r\n");
            return sb.toString().getBytes(Charset.forName(HTTP.ASCII));
        }

        private void verifyServerHandshake(InputStream inputStream, String str) throws IOException {
            try {
                SessionInputBufferImpl sessionInputBufferImpl = new SessionInputBufferImpl(new HttpTransportMetricsImpl(), 8192);
                sessionInputBufferImpl.bind(inputStream);
                HttpResponse httpResponse = (HttpResponse) new DefaultHttpResponseParser(sessionInputBufferImpl).parse();
                StatusLine statusLine = httpResponse.getStatusLine();
                if (statusLine == null) {
                    throw new InvalidServerHandshakeException("There is no status line");
                }
                int statusCode = statusLine.getStatusCode();
                if (statusCode != 101) {
                    throw new InvalidServerHandshakeException("Invalid status code. Expected 101, received: " + statusCode);
                }
                Header[] headers = httpResponse.getHeaders(HttpHeaders.UPGRADE);
                if (headers.length == 0) {
                    throw new InvalidServerHandshakeException("There is no header named Upgrade");
                }
                String value = headers[0].getValue();
                if (value == null) {
                    throw new InvalidServerHandshakeException("There is no value for header Upgrade");
                }
                String lowerCase = value.toLowerCase();
                if (!lowerCase.equals("websocket")) {
                    throw new InvalidServerHandshakeException("Invalid value for header Upgrade. Expected: websocket, received: " + lowerCase);
                }
                Header[] headers2 = httpResponse.getHeaders("Connection");
                if (headers2.length == 0) {
                    throw new InvalidServerHandshakeException("There is no header named Connection");
                }
                String value2 = headers2[0].getValue();
                if (value2 == null) {
                    throw new InvalidServerHandshakeException("There is no value for header Connection");
                }
                String lowerCase2 = value2.toLowerCase();
                if (!lowerCase2.equals("upgrade")) {
                    throw new InvalidServerHandshakeException("Invalid value for header Connection. Expected: upgrade, received: " + lowerCase2);
                }
                Header[] headers3 = httpResponse.getHeaders("Sec-WebSocket-Accept");
                if (headers3.length == 0) {
                    throw new InvalidServerHandshakeException("There is no header named Sec-WebSocket-Accept");
                }
                String value3 = headers3[0].getValue();
                if (value3 == null) {
                    throw new InvalidServerHandshakeException("There is no value for header Sec-WebSocket-Accept");
                }
                String encodeBase64String = Base64.encodeBase64String(DigestUtils.sha1(str + WebSocketClient.GUID));
                if (!value3.equals(encodeBase64String)) {
                    throw new InvalidServerHandshakeException("Invalid value for header Sec-WebSocket-Accept. Expected: " + encodeBase64String + ", received: " + value3);
                }
            } catch (HttpException e) {
                throw new InvalidServerHandshakeException(e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void send(int i, byte[] bArr) throws IOException {
            byte[] bArr2;
            int i2;
            int length = bArr == null ? 0 : bArr.length;
            if (length < 126) {
                bArr2 = new byte[length + 6];
                bArr2[0] = (byte) (i | (-128));
                bArr2[1] = (byte) (length | (-128));
                i2 = 2;
            } else if (length < 65536) {
                bArr2 = new byte[length + 8];
                bArr2[0] = (byte) (i | (-128));
                bArr2[1] = -2;
                byte[] bArr3 = Utils.to2ByteArray(length);
                bArr2[2] = bArr3[0];
                bArr2[3] = bArr3[1];
                i2 = 4;
            } else {
                bArr2 = new byte[length + 14];
                bArr2[0] = (byte) (i | (-128));
                bArr2[1] = -1;
                byte[] bArr4 = Utils.to8ByteArray(length);
                bArr2[2] = bArr4[0];
                bArr2[3] = bArr4[1];
                bArr2[4] = bArr4[2];
                bArr2[5] = bArr4[3];
                bArr2[6] = bArr4[4];
                bArr2[7] = bArr4[5];
                bArr2[8] = bArr4[6];
                bArr2[9] = bArr4[7];
                i2 = 10;
            }
            byte[] bArr5 = new byte[4];
            WebSocketClient.this.secureRandom.nextBytes(bArr5);
            bArr2[i2] = bArr5[0];
            bArr2[i2 + 1] = bArr5[1];
            bArr2[i2 + 2] = bArr5[2];
            bArr2[i2 + 3] = bArr5[3];
            int i3 = i2 + 4;
            for (int i4 = 0; i4 < length; i4++) {
                bArr2[i3] = (byte) (bArr[i4] ^ bArr5[i4 % 4]);
                i3++;
            }
            this.bos.write(bArr2);
            this.bos.flush();
        }

        private void read() throws IOException {
            while (true) {
                int read = this.bis.read();
                if (read != -1) {
                    int i = (read << 28) >>> 28;
                    int read2 = (this.bis.read() << 25) >>> 25;
                    if (read2 == 126) {
                        byte[] bArr = new byte[2];
                        for (int i2 = 0; i2 < 2; i2++) {
                            bArr[i2] = (byte) this.bis.read();
                        }
                        read2 = Utils.fromByteArray(new byte[]{0, 0, bArr[0], bArr[1]});
                    } else if (read2 == 127) {
                        byte[] bArr2 = new byte[8];
                        for (int i3 = 0; i3 < 8; i3++) {
                            bArr2[i3] = (byte) this.bis.read();
                        }
                        read2 = Utils.fromByteArray(new byte[]{bArr2[4], bArr2[5], bArr2[6], bArr2[7]});
                    }
                    byte[] bArr3 = new byte[read2];
                    for (int i4 = 0; i4 < read2; i4++) {
                        bArr3[i4] = (byte) this.bis.read();
                    }
                    if (i != 0) {
                        if (i == 1) {
                            WebSocketClient.this.notifyOnTextReceived(new String(bArr3, Charset.forName("UTF-8")));
                        } else if (i == 2) {
                            WebSocketClient.this.notifyOnBinaryReceived(bArr3);
                        } else {
                            switch (i) {
                                case 8:
                                    closeInternal();
                                    WebSocketClient.this.notifyOnCloseReceived();
                                    return;
                                case 9:
                                    WebSocketClient.this.notifyOnPingReceived(bArr3);
                                    WebSocketClient.this.sendPong(bArr3);
                                    break;
                                case 10:
                                    WebSocketClient.this.notifyOnPongReceived(bArr3);
                                    break;
                                default:
                                    closeInternal();
                                    WebSocketClient.this.notifyOnException(new UnknownOpcodeException("Unknown opcode: 0x" + Integer.toHexString(i)));
                                    return;
                            }
                        }
                    }
                } else {
                    throw new IOException("Unexpected end of stream");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendInternal(Payload payload) {
            synchronized (this.internalLock) {
                this.outBuffer.addLast(payload);
                this.pendingMessages = true;
                this.internalLock.notify();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeInternal() {
            try {
                synchronized (this.internalLock) {
                    if (!this.isClosed) {
                        this.isClosed = true;
                        Socket socket = this.socket;
                        if (socket != null) {
                            socket.close();
                            this.pendingMessages = true;
                            this.internalLock.notify();
                        }
                    }
                }
            } catch (IOException unused) {
            }
        }
    }
}
