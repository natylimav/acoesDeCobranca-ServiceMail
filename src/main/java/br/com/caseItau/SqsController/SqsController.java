package br.com.caseItau.SqsController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SqsController {

    @GetMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        String SQS = "https://localhost.localstack.cloud:4566/000000000000/emailQueueNotification";
        //sqsMessageService.sendMessage(SQS, message);
        return ResponseEntity.ok().build();
    }

}
