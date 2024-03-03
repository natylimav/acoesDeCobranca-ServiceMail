package br.com.caseItau.adapters;

//contrato da aplicaçao com o servico de email Ses
public interface SenderServiceGateway {
    void sendMail(String to, String body, String subject);

}
