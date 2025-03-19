package com.microsoft.windowsazure.messaging;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes2.dex */
public abstract class TemplateRegistration extends Registration {
    private String mBodyTemplate;

    TemplateRegistration(String str) {
        super(str);
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected void appendCustomPayload(Document document, Element element) {
        appendBodyTemplateNode(document, element);
        appendNodeWithValue(document, element, "TemplateName", getName());
    }

    private void appendBodyTemplateNode(Document document, Element element) {
        if (Utils.isNullOrWhiteSpace(getBodyTemplate())) {
            return;
        }
        Element createElement = document.createElement("BodyTemplate");
        element.appendChild(createElement);
        createElement.appendChild(document.createCDATASection(getBodyTemplate()));
    }

    @Override // com.microsoft.windowsazure.messaging.Registration
    protected void loadCustomXmlData(Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("BodyTemplate");
        if (elementsByTagName.getLength() > 0) {
            int i = 0;
            NodeList childNodes = elementsByTagName.item(0).getChildNodes();
            while (true) {
                if (i >= childNodes.getLength()) {
                    break;
                }
                if (childNodes.item(i) instanceof CharacterData) {
                    this.mBodyTemplate = ((CharacterData) childNodes.item(i)).getData();
                    break;
                }
                i++;
            }
        }
        setName(getNodeValue(element, "TemplateName"));
    }

    public String getBodyTemplate() {
        return this.mBodyTemplate;
    }

    void setBodyTemplate(String str) {
        this.mBodyTemplate = str;
    }

    public String getTemplateName() {
        return getName();
    }
}
