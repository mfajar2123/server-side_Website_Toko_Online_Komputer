///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.id.mii.serversidekelompok3.model;
//import java.math.BigDecimal;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
///**
// *
// * @author fajar
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "tb_keranjang")
//public class Keranjang {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;   
//    
////    @JoinColumn
////    @ManyToOne
//    private Produk produk;
////    
////    @JoinColumn
////    @ManyToOne
//    private Pengguna pengguna;
//    
//    @Column(nullable = false)   
//    private int kuantitas;
//    
//    @Column(nullable = false)   
//    private BigDecimal harga;
//    
//    @Column(nullable = false)   
//    private BigDecimal jumlah;
//    
//      
//    
//}