package com.emailsender.mapper;

import com.emailsender.dto.EmailRequestDto;
import com.emailsender.dto.EmailResponseDto;
import com.emailsender.model.EmailModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.mail.SimpleMailMessage;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper(imports = {LocalDateTime.class, ZoneId.class})
public interface EmailMapper {
    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    @Mapping(target = "sendEmailDate", source = "sendEmailDate")
    @Mapping(target = "body", source = "body")
    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "ownerRef", source = "ownerRef")
    @Mapping(target = "emailTo", source = "emailTo")
    @Mapping(target = "emailFrom", source = "emailFrom")
    EmailResponseDto modelToResponse(EmailModel emailModel);

    @Mapping(target = "statusEmail", ignore = true)
    @Mapping(target = "emailId", ignore = true)
    @Mapping(target = "sendEmailDate", expression = "java(LocalDateTime.now(ZoneId.of(\"UTC\")))")
    @Mapping(target = "ownerRef", source = "ownerRef")
    @Mapping(target = "emailFrom", source = "emailFrom")
    @Mapping(target = "emailTo", source = "emailTo")
    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "body", source = "body")
    EmailModel requestToModel(EmailRequestDto emailRequestDto);

    @Mapping(target = "from", source = "emailFrom")
    @Mapping(target = "to", expression = "java(emailModel.getEmailTo())")
    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "text", source = "body")
    SimpleMailMessage modelToSimpleMailMessage(EmailModel emailModel);
}
