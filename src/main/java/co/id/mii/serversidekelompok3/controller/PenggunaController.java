/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.controller;


import co.id.mii.serversidekelompok3.model.Pengguna;
import co.id.mii.serversidekelompok3.service.PenggunaService;
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
@RequestMapping("/pengguna")
public class PenggunaController {

    private PenggunaService penggunaService;

    @Autowired
    public PenggunaController(PenggunaService penggunaService) {
        this.penggunaService = penggunaService;
    }

    @GetMapping // http:/localhost:8088/pengguna
    public ResponseEntity<List<Pengguna>> getAll() {
        return new ResponseEntity(penggunaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // http:/localhost:8088/pengguna/1
    public ResponseEntity<Pengguna> getById(@PathVariable Long id) {
        return new ResponseEntity(penggunaService.getById(id),HttpStatus.OK);
    }

    @PostMapping // http:/localhost:8088/pengguna
    public ResponseEntity<Pengguna> create(@RequestBody Pengguna pengguna) {
        return new ResponseEntity(penggunaService.create(pengguna),HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // http:/localhost:8088/pengguna/1
    public ResponseEntity<Pengguna> update(@PathVariable Long id,@RequestBody Pengguna pengguna) {
        return new ResponseEntity(penggunaService.update(id, pengguna),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // http:/localhost:8088/pengguna/1
    public ResponseEntity<Pengguna> delete(@PathVariable Long id) {
        return new ResponseEntity(penggunaService.delete(id),HttpStatus.OK);
    }
    
    

}