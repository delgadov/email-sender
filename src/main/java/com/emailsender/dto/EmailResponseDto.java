package com.emailsender.dto;

import java.time.LocalDateTime;

public record EmailResponseDto(String ownerRef,
                               String emailFrom,
                               String emailTo,
                               String subject,
                               String body,
                               LocalDateTime sendEmailDate) {
}
