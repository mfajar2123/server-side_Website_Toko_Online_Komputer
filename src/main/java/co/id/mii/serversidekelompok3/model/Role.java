///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.id.mii.serversidekelompok3.model;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
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
//@Table(name = "tb_role")
//public class Role {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    @Column(nullable = false)   
//    private String name;
//    
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @ManyToMany(mappedBy = "roles")
//    private List<Pengguna> pengguna;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "tb_role_privilege",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
//    private List<Privilege> privileges;
//
//}