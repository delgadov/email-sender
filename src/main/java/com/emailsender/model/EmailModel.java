package com.emailsender.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;
    private LocalDateTime sendEmailDate;
    private StatusEmail statusEmail;
}
