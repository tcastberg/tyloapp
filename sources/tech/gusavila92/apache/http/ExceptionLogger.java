package tech.gusavila92.apache.http;

/* loaded from: classes2.dex */
public interface ExceptionLogger {
    public static final ExceptionLogger NO_OP = new ExceptionLogger() { // from class: tech.gusavila92.apache.http.ExceptionLogger.1
        @Override // tech.gusavila92.apache.http.ExceptionLogger
        public void log(Exception exc) {
        }
    };
    public static final ExceptionLogger STD_ERR = new ExceptionLogger() { // from class: tech.gusavila92.apache.http.ExceptionLogger.2
        @Override // tech.gusavila92.apache.http.ExceptionLogger
        public void log(Exception exc) {
            exc.printStackTrace();
        }
    };

    void log(Exception exc);
}
