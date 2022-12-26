/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ilham
 */
@Service
@AllArgsConstructor
public class EmailService {
    private JavaMailSender mailSender;
    
    public void sendEmail(String to, String subject, String body){
       SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("TokoKomputer@gmail.com");
        System.out.println("Simple Mail Send .........");
        mailSender.send(message); 
    }
    
    public void sendEmailDisapprove(String to, String subject, String body){
       SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("TokoKomputer@gmail.com");
        System.out.println("Simple Mail Send .........");
        mailSender.send(message); 
    }
}
