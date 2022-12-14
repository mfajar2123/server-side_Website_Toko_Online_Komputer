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
@RequestMapping("/kategori")
public class KategoriController {

    private KategoriService kategoriService;

    @Autowired
    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @GetMapping // http:/localhost:8088/kategori
    public ResponseEntity<List<Kategori>> getAll() {
        return new ResponseEntity(kategoriService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // http:/localhost:8088/kategori/1
    public ResponseEntity<Kategori> getById(@PathVariable Long id) {
        return new ResponseEntity(kategoriService.getById(id),HttpStatus.OK);
    }

    @PostMapping // http:/localhost:8088/kategori
    public ResponseEntity<Kategori> create(@RequestBody Kategori kategori) {
        return new ResponseEntity(kategoriService.create(kategori),HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // http:/localhost:8088/kategori/1
    public ResponseEntity<Kategori> update(@PathVariable Long id,@RequestBody Kategori kategori) {
        return new ResponseEntity(kategoriService.update(id, kategori),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // http:/localhost:8088/kategori/1
    public ResponseEntity<Kategori> delete(@PathVariable Long id) {
        return new ResponseEntity(kategoriService.delete(id),HttpStatus.OK);
    }
    
    

}