package com.example.mailservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    @ResponseBody
    @CrossOrigin
    @GetMapping("/enviarCorreo")
    public String enviarCorreo(@RequestBody MailDTO mailDTO) throws MessagingException {

        String body = mailDTO.getBody();
        String subject = mailDTO.getSubject();

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("equipos.pucp.iot@gmail.com");
        helper.setTo(mailDTO.getTo());
        helper.setSubject(subject);
        helper.setText(body);

        mailSender.send(message);
        System.out.println("Mensjae enviado exitosamente");

        return "Se envió el correo con éxito";
    }
}
