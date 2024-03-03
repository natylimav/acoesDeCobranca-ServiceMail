package br.com.caseItau.application;

import br.com.caseItau.adapters.SenderServiceGateway;
import br.com.caseItau.core.notifications.SendEmailUseCase;
import br.com.caseItau.domain.model.EmailClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService implements SendEmailUseCase {

    private final SenderServiceGateway senderServiceGateway;
    private String email;
    private String emailBody;
    private String emailSubject;


    public EmailService(SenderServiceGateway senderServiceGateway, String email, String emailBody, String emailSubject) {
        this.senderServiceGateway = senderServiceGateway;
        this.email = email;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
    }

    @Autowired
    public EmailService(SenderServiceGateway senderServiceGateway) {
        this.senderServiceGateway = senderServiceGateway;
    }

    @Override
    public void sendEmailCliente(EmailClient cliente) {

        this.email = cliente.getTo();
        this.emailBody = cliente.getBody();
        this.emailSubject = cliente.getSubject();

        try {
            senderServiceGateway.sendMail(this.email,this.emailBody,this.emailSubject);
            log.info(" Email enviado com sucesso: Para "+  this.email + "mensagem: " + emailBody + "Assunto: " + this.emailSubject );
        } catch (Exception e) {
            log.error("SendEmailservice fail: " + e.getMessage(), e);

        }
    }
}
