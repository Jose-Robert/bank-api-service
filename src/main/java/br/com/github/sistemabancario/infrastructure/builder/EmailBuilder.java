package br.com.github.sistemabancario.infrastructure.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.github.sistemabancario.domain.shared.Anexo;

public class EmailBuilder {

    private String subject;

    private String body;

    private List<String> receivers = new ArrayList<>();
    
    private List<Anexo> attachments = new ArrayList<>();

    public EmailBuilder withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder withBody(String body) {
        this.body = body;
        return this;
    }
    
    public EmailBuilder withAttachments(List<Anexo> attachments) {
        this.attachments = attachments;
        return this;
    }

    public EmailBuilder addReceiver(String receiver) {
        this.receivers.add(receiver);
        return this;
    }
    
    public EmailBuilder addReceivers(List<String> receivers) {
        this.receivers.addAll(receivers);
        return this;
    }
    
    public EmailBuilder addAttachment(Anexo attachment) {
        this.attachments.add(attachment);
        return this;
    }

    public EmailTO buildSimple() {
        return new EmailTO(subject, body, receivers, attachments);
    }

}
