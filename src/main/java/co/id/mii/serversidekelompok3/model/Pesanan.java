/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.model;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author fajar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pesanan")
public class Pesanan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)   
    private String nomor;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date tanggal;
    
    @Column   
    private String alamat;
    
    @Column(nullable = false)   
    private int jumlah;
    
    @Column(nullable = false)   
    private BigDecimal total;
    
    @Enumerated(EnumType.STRING)  
    private StatusPesanan statusPesanan;
    
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    
    
    
    
    
}