/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.controller;


import co.id.mii.serversidekelompok3.model.dto.Request.EmailSenderDto;
import co.id.mii.serversidekelompok3.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fajarr
 */
@RestController
@RequestMapping("/email")
@PreAuthorize("hasRole('PENGGUNA')")
public class EmailController {

    private EmailSenderService emailSenderService;
     @Autowired
    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
    @PreAuthorize("hasAuthority('CREATE_PENJUAL')")
    @PostMapping
    public EmailSenderDto simpleMail(@RequestBody EmailSenderDto emailSenderDto) {
        return emailSenderService.sendSimpleEmail(emailSenderDto);
    }
    
    @PreAuthorize("hasAuthority('CREATE_PENJUAL')")
    @PostMapping("/attach")
    public EmailSenderDto mimeMessageMail(@RequestBody EmailSenderDto emailSenderDto) {
        return emailSenderService.mimeMessageEmail(emailSenderDto);
    }
}