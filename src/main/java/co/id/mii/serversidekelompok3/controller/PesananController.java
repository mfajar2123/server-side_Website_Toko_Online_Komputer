/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.controller;


import co.id.mii.serversidekelompok3.model.Pesanan;

import co.id.mii.serversidekelompok3.service.PesananService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fajarr
 */
@RestController
@RequestMapping("/pesanan")
@PreAuthorize("hasRole('PENGGUNA')")
public class PesananController {
    private PesananService pesananService;
    
    @Autowired
    public PesananController(PesananService pesananService) {
        this.pesananService = pesananService;
    }
    @PreAuthorize("hasAnyAuthority('READ_PENGGUNA','READ_PENJUAL')")
    @GetMapping
    public ResponseEntity<List<Pesanan>> getAll(){
        return new ResponseEntity(pesananService.getAll(),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('READ_PENJUAL')")
    @GetMapping("/{id}") 
    public ResponseEntity<Pesanan> getById(@PathVariable Long id){
        return new ResponseEntity(pesananService.getById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CREATE_PENGGUNA','CREATE_PENJUAL')")
    @PostMapping
    public Pesanan create(@RequestBody Pesanan pesanan) {
        return pesananService.create(pesanan);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_PENGGUNA')")
    @PutMapping("/{id}")
    public ResponseEntity<Pesanan> Update(@PathVariable Long id,@RequestBody Pesanan pesanan){
        return new ResponseEntity(pesananService.update(id,pesanan), HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('DELETE_PENJUAL')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Pesanan> Delete(@PathVariable Long id){
        return new ResponseEntity(pesananService.delete(id), HttpStatus.OK);
    }
}