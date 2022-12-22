/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.model.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Fajarr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSenderDto {
    private String sendTo;
    private String subject;
    private String body;
    private String attachment;
}