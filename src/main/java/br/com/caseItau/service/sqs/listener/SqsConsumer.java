package br.com.caseItau.service.sqs.listener;

import br.com.caseItau.application.EmailService;
import br.com.caseItau.domain.model.EmailClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsConsumer {

    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    @Autowired
    public SqsConsumer(EmailService emailService, ObjectMapper objectMapper) {

        this.emailService = emailService;
        this.objectMapper = objectMapper;
    }

    @SqsListener("emailQueueNotification")
    public void listen(String message) {

        try {
            EmailClient cliente = objectMapper.readValue(message, EmailClient.class);
            emailService.sendEmailCliente(cliente);
            System.out.println("Message received: " + message);
            log.info("Message received: "+ message);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
