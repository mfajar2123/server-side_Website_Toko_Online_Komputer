/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.model.dto.Request;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author MSI-JO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenggunaRequest {

    private String username;
  
    private String password;
      
    private String nama;
    
    private String email;
     
    private String alamat;
      
    private String no_hp;


}