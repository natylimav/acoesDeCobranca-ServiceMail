package br.com.caseItau.core.notifications;

import br.com.caseItau.domain.model.EmailClient;

//interface que vai ser o contrato que define o comportamento de envio de email
public interface SendEmailUseCase {
    void sendEmailCliente(EmailClient cliente);
}
