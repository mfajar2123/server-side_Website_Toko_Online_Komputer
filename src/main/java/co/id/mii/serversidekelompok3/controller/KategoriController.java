/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.controller;


import co.id.mii.serversidekelompok3.model.Kategori;

import co.id.mii.serversidekelompok3.service.KategoriService;
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
@RequestMapping("/kategori")
@PreAuthorize("hasRole('PENGGUNA')")
public class KategoriController {
    private KategoriService kategoriService;
    
    @Autowired
    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }
    @PreAuthorize("hasAnyAuthority('READ_PENGGUNA','READ_PENJUAL')")
    @GetMapping
    public ResponseEntity<List<Kategori>> getAll(){
        return new ResponseEntity(kategoriService.getAll(),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyAuthority('READ_PENGGUNA','READ_PENJUAL')")
    @GetMapping("/{id}") 
    public ResponseEntity<Kategori> getById(@PathVariable Long id){
        return new ResponseEntity(kategoriService.getById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('CREATE_PENJUAL')")
    @PostMapping
    public Kategori create(@RequestBody Kategori kategori) {
        return kategoriService.create(kategori);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_PENJUAL')")
    @PutMapping("/{id}")
    public ResponseEntity<Kategori> Update(@PathVariable Long id,@RequestBody Kategori kategori){
        return new ResponseEntity(kategoriService.update(id,kategori), HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('DELETE_PENJUAL')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Kategori> Delete(@PathVariable Long id){
        return new ResponseEntity(kategoriService.delete(id), HttpStatus.OK);
    }
}