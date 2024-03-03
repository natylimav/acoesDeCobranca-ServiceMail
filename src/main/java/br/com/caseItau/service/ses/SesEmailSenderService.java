package br.com.caseItau.service.ses;

import br.com.caseItau.adapters.SenderServiceGateway;
import br.com.caseItau.core.notifications.exceptions.EmailServiceException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SesEmailSenderService implements SenderServiceGateway {

    private final AmazonSimpleEmailService sesClientEmail;

    @Autowired
    public SesEmailSenderService(AmazonSimpleEmailService sesClient) {
        this.sesClientEmail = sesClient;
    }

    @Override
    public void sendMail(String to, String body, String subject) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("natylimavlima@gmail.com")//email itau
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );
        try {
            sesClientEmail.sendEmail(request);
            log.info("Email enviado: "+ request.toString());

        } catch (AmazonServiceException ex) {
            log.error(ex.getMessage(), ex);
            throw new EmailServiceException("Email sending failed", ex);
        }
    }
}
