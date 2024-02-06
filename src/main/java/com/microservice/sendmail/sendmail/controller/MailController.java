package com.microservice.sendmail.sendmail.controller;

import com.microservice.sendmail.sendmail.template.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MailController {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/sendmail")
    public ResponseEntity<String> enviaEmail(@RequestBody @Valid Mail mail) {
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("rookpawnletter@outlook.com");
            message.setTo("whitelook22@outlook.com");
            message.setSubject("Assunto do E-mail");
            message.setText("Oi meu nome é "+mail.getNome() + " entrei no seu site , gostaria de conversar com vc" +
                    "meus dados são "+mail.getEmail() + mail.getCelular() +"e o assunto é o seguinte"+mail.getMensagem());
            javaMailSender.send(message);
            String msg = "E-mail enviado com sucesso!";

            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "Erro ao enviar o e-mail: ";
            return ResponseEntity.status(500).body(msg + e.getMessage());
        }
    }
}
