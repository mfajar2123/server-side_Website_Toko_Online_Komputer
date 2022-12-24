/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.controller;

import co.id.mii.serversidekelompok3.model.Pengguna;
import co.id.mii.serversidekelompok3.model.dto.Request.PenggunaRequest;
import co.id.mii.serversidekelompok3.service.PenggunaService;
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
@RequestMapping("/pengguna")
@PreAuthorize("hasRole('PENGGUNA')")
public class PenggunaController {
    private PenggunaService penggunaService;

    @Autowired
    public PenggunaController(PenggunaService penggunaService) {
        this.penggunaService = penggunaService;
    }

    @PreAuthorize("hasAnyAuthority('READ_PENGGUNA','READ_PENJUAL')")
    @GetMapping
    public ResponseEntity<List<Pengguna>> getAll() {
        return new ResponseEntity(penggunaService.getAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('READ_PENJUAL')")
    @GetMapping("/{id}")
    public ResponseEntity<Pengguna> getById(@PathVariable Long id) {
        return new ResponseEntity(penggunaService.getById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('CREATE_PENJUAL')")
    @PostMapping
    public Pengguna create(@RequestBody PenggunaRequest penggunaRequest) {
        return penggunaService.create(penggunaRequest);
    }

    @PreAuthorize("hasAuthority('UPDATE_PENJUAL')")
    @PutMapping("/{id}")
    public ResponseEntity<Pengguna> Update(@PathVariable Long id, @RequestBody Pengguna pengguna) {
        return new ResponseEntity(penggunaService.update(id, pengguna), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('DELETE_PENJUAL')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Pengguna> Delete(@PathVariable Long id) {
        return new ResponseEntity(penggunaService.delete(id), HttpStatus.OK);
    }
}