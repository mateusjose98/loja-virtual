package com.mateusjose98.lojavirtual.service;

import com.mateusjose98.lojavirtual.service.enums.EmailType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmailService {


    @Async
    public void enviar(String email, Map<String, String> info, EmailType emailType) {
        log.info("Enviando email {} para {}. ", emailType, email);
    }
}
