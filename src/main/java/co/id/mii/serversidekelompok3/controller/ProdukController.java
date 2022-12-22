/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.controller;


import co.id.mii.serversidekelompok3.model.Produk;

import co.id.mii.serversidekelompok3.service.ProdukService;
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
@RequestMapping("/produk")
@PreAuthorize("hasRole('PENGGUNA')")
public class ProdukController {
    private ProdukService produkService;
    
    @Autowired
    public ProdukController(ProdukService produkService) {
        this.produkService = produkService;
    }
    @PreAuthorize("hasAnyAuthority('READ_PENGGUNA','READ_PENJUAL')")
    @GetMapping
    public ResponseEntity<List<Produk>> getAll(){
        return new ResponseEntity(produkService.getAll(),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyAuthority('READ_PENGGUNA','READ_PENJUAL')")
    @GetMapping("/{id}") 
    public ResponseEntity<Produk> getById(@PathVariable Long id){
        return new ResponseEntity(produkService.getById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CREATE_PENGGUNA','CREATE_PENJUAL')")
    @PostMapping
    public Produk create(@RequestBody Produk produk) {
        return produkService.create(produk);
    }
 @PreAuthorize("hasAnyAuthority('UPDATE_PENGGUNA','UPDATE_PENJUAL')")
    @PutMapping("/{id}")
    public ResponseEntity<Produk> Update(@PathVariable Long id,@RequestBody Produk produk){
        return new ResponseEntity(produkService.update(id,produk), HttpStatus.CREATED);
    }
 @PreAuthorize("hasAuthority('DELETE_PENGGUNA')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Produk> Delete(@PathVariable Long id){
        return new ResponseEntity(produkService.delete(id), HttpStatus.OK);
    }
}