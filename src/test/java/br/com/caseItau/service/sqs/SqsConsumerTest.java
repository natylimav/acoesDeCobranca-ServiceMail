package br.com.caseItau.service.sqs;

import br.com.caseItau.application.EmailService;
import br.com.caseItau.domain.model.EmailClient;
import br.com.caseItau.service.sqs.listener.SqsConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class SqsConsumerTest {

    @Mock
    private EmailService emailService;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private SqsConsumer sqsConsumer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListen() throws Exception {
        // Arrange
        String message = "{\"to\":\"destinatario@example.com\",\"subject\":\"Assunto do Email\",\"body\":\"Conteúdo do Email\"}";
        EmailClient emailClient = new EmailClient();
        when(objectMapper.readValue(message, EmailClient.class)).thenReturn(emailClient);

        // Act
        sqsConsumer.listen(message);

        // Assert
        verify(objectMapper, times(1)).readValue(message, EmailClient.class);
        verify(emailService, times(1)).sendEmailCliente(emailClient);
    }
}
