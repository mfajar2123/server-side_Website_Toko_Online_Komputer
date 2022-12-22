/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;


import co.id.mii.serversidekelompok3.model.dto.Request.EmailSenderDto;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fajarr
 */
@Service
@AllArgsConstructor
public class EmailSenderService {

    private JavaMailSender mailSender;

    public EmailSenderDto sendSimpleEmail(EmailSenderDto emailSenderDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailSenderDto.getSendTo());
        message.setSubject(emailSenderDto.getSubject());
        message.setText(emailSenderDto.getBody());
        System.out.println("Simple Mail Send .........");
        mailSender.send(message);
        return emailSenderDto;
    }

    public EmailSenderDto mimeMessageEmail(EmailSenderDto emailSenderDto) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailSenderDto.getSendTo());
            helper.setSubject(emailSenderDto.getSubject());
            helper.setText(emailSenderDto.getBody());
            
            FileSystemResource fileSystemResource = new FileSystemResource(new File(emailSenderDto.getAttachment()));
            helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
            System.out.println("MimeMessage Email Send .........");
            mailSender.send(message);
            
        } catch (MessagingException e) {
            throw new IllegalStateException("Failed to send email");
        }
        return emailSenderDto;
    }

}