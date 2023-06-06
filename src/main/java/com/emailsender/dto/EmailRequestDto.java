package com.emailsender.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmailRequestDto {
    @NotNull
    private String ownerRef;
    @NotNull
    @Email
    private String emailFrom;
    @NotNull
    @Email
    private String emailTo;
    @NotNull
    private String subject;
    @NotNull
    private String body;
}
