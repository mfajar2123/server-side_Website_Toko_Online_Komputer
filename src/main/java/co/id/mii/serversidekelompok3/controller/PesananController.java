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
@RequestMapping("/pesanan")
public class PesananController {

    private PesananService pesananService;

    @Autowired
    public PesananController(PesananService pesananService) {
        this.pesananService = pesananService;
    }

    @GetMapping // http:/localhost:8088/pesanan
    public ResponseEntity<List<Pesanan>> getAll() {
        return new ResponseEntity(pesananService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // http:/localhost:8088/pesanan/1
    public ResponseEntity<Pesanan> getById(@PathVariable Long id) {
        return new ResponseEntity(pesananService.getById(id),HttpStatus.OK);
    }

    @PostMapping // http:/localhost:8088/pesanan
    public ResponseEntity<Pesanan> create(@RequestBody Pesanan pesanan) {
        return new ResponseEntity(pesananService.create(pesanan),HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // http:/localhost:8088/pesanan/1
    public ResponseEntity<Pesanan> update(@PathVariable Long id,@RequestBody Pesanan pesanan) {
        return new ResponseEntity(pesananService.update(id, pesanan),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // http:/localhost:8088/pesanan/1
    public ResponseEntity<Pesanan> delete(@PathVariable Long id) {
        return new ResponseEntity(pesananService.delete(id),HttpStatus.OK);
    }
    
    

}