package com.emailsender.controller;

import com.emailsender.dto.EmailRequestDto;
import com.emailsender.dto.EmailResponseDto;
import com.emailsender.mapper.EmailMapper;
import com.emailsender.model.EmailModel;
import com.emailsender.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/v1/ms")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<EmailResponseDto> sendEmail(@RequestBody @Valid EmailRequestDto emailRequestDto) {
        EmailModel emailModel = EmailMapper.INSTANCE.requestToModel(emailRequestDto);
        EmailModel sendEmailModel = emailService.sendEmail(emailModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(EmailMapper.INSTANCE.modelToResponse(sendEmailModel));
    }
}
