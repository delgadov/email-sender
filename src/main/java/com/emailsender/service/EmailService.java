package com.emailsender.service;

import com.emailsender.mapper.EmailMapper;
import com.emailsender.model.EmailModel;
import com.emailsender.model.StatusEmail;
import com.emailsender.repository.EmailRepository;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final MailSender mailSender;

    public EmailService(EmailRepository emailRepository, MailSender mailSender) {
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
    }

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendEmailDate(LocalDateTime.now(ZoneId.of("UTC")));

        try {
            SimpleMailMessage simpleMailMessage = EmailMapper.INSTANCE.modelToSimpleMailMessage(emailModel);
            mailSender.send(simpleMailMessage);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailSendException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        return emailRepository.save(emailModel);
    }
}
