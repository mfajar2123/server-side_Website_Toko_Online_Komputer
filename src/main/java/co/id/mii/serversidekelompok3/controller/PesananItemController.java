/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.controller;


import co.id.mii.serversidekelompok3.model.PesananItem;
import co.id.mii.serversidekelompok3.service.PesananItemService;
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
@RequestMapping("/pesananItem")
public class PesananItemController {

    private PesananItemService pesananItemService;

    @Autowired
    public PesananItemController(PesananItemService pesananItemService) {
        this.pesananItemService = pesananItemService;
    }

    @GetMapping // http:/localhost:8088/pesananItem
    public ResponseEntity<List<PesananItem>> getAll() {
        return new ResponseEntity(pesananItemService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // http:/localhost:8088/pesananItem/1
    public ResponseEntity<PesananItem> getById(@PathVariable Long id) {
        return new ResponseEntity(pesananItemService.getById(id),HttpStatus.OK);
    }

    @PostMapping // http:/localhost:8088/pesananItem
    public ResponseEntity<PesananItem> create(@RequestBody PesananItem pesananItem) {
        return new ResponseEntity(pesananItemService.create(pesananItem),HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // http:/localhost:8088/pesananItem/1
    public ResponseEntity<PesananItem> update(@PathVariable Long id,@RequestBody PesananItem pesananItem) {
        return new ResponseEntity(pesananItemService.update(id, pesananItem),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // http:/localhost:8088/pesananItem/1
    public ResponseEntity<PesananItem> delete(@PathVariable Long id) {
        return new ResponseEntity(pesananItemService.delete(id),HttpStatus.OK);
    }
    
    

}