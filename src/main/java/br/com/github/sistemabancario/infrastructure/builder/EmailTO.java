package br.com.github.sistemabancario.infrastructure.builder;

import java.util.List;

import br.com.github.sistemabancario.domain.shared.Anexo;
import lombok.Getter;

@Getter
public class EmailTO {
    
    private String subject;
    
    private String body;
    
    private List<String> receivers;
    
    private List<Anexo> attachments;

    public EmailTO(String subject, String body, List<String> receivers, List<Anexo> attachments) {
        super();
        this.subject = subject;
        this.body = body;
        this.receivers = receivers;
        this.attachments = attachments;
    }
    
    

}
