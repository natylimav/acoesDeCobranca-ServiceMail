<h3 align="center">
Projeto - Ação de Cobrança
  Envio de notificações por e-mail
Microserviço envia notificação via E-mail.
</h3>

## :rocket: Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Cloud AWS
* AWS
* SQS (Simple Queue Service)
* Amazon Simple Email Service - SES
* Localstack

 Microserviço responsável por fazer pulling em uma fila SQS, 
 quando houver mensagem, deve enviar e-mail ao cliente com dados recebidos na mensagem.

 
Referências utilizadas: https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-visibility-timeout.html https://docs.awspring.io/spring-cloud-aws/docs/3.1.0/reference/html/index.html#starter-dependencies
https://aws.amazon.com/pt/ses/



