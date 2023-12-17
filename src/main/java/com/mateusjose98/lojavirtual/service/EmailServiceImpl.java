package com.mateusjose98.lojavirtual.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void enviar(EmailInfo emailInfo) {
       try {
           if(!emailInfo.complexo) {
               SimpleMailMessage message = new SimpleMailMessage();
               message.setFrom("suporte@emapresa.com");
               message.setTo(emailInfo.para);
               message.setSubject(emailInfo.assunto);
               message.setText(emailInfo.texto());
               mailSender.send(message);
           }

       } catch (Exception e) {
           log.error(e.getMessage());
       }
    }

    public record EmailInfo(String assunto,
                            String para,
                            String comCopia,
                            String texto,
                            boolean complexo) {}
}
