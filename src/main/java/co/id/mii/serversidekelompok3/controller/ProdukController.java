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
@RestController // JSON
@RequestMapping("/produk")
public class ProdukController {

    private ProdukService produkService;

    @Autowired
    public ProdukController(ProdukService produkService) {
        this.produkService = produkService;
    }

    @GetMapping // http:/localhost:8088/produk
    public ResponseEntity<List<Produk>> getAll() {
        return new ResponseEntity(produkService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // http:/localhost:8088/produk/1
    public ResponseEntity<Produk> getById(@PathVariable Long id) {
        return new ResponseEntity(produkService.getById(id),HttpStatus.OK);
    }

    @PostMapping // http:/localhost:8088/produk
    public ResponseEntity<Produk> create(@RequestBody Produk produk) {
        return new ResponseEntity(produkService.create(produk),HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // http:/localhost:8088/produk/1
    public ResponseEntity<Produk> update(@PathVariable Long id,@RequestBody Produk produk) {
        return new ResponseEntity(produkService.update(id, produk),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // http:/localhost:8088/produk/1
    public ResponseEntity<Produk> delete(@PathVariable Long id) {
        return new ResponseEntity(produkService.delete(id),HttpStatus.OK);
    }
    
    

}