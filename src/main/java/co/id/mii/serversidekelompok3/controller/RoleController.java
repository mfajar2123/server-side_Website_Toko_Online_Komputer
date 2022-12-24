/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.controller;


import co.id.mii.serversidekelompok3.model.Role;

import co.id.mii.serversidekelompok3.service.RoleService;
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
@RequestMapping("/role")
@PreAuthorize("hasRole('PENGGUNA')")
public class RoleController {
    private RoleService roleService;
    
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PreAuthorize("hasAuthority('READ_PENJUAL')")
    @GetMapping
    public ResponseEntity<List<Role>> getAll(){
        return new ResponseEntity(roleService.getAll(),HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('READ_PENJUAL')")
    @GetMapping("/{id}") 
    public ResponseEntity<Role> getById(@PathVariable Long id){
        return new ResponseEntity(roleService.getById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('CREATE_PENJUAL')")
    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }
    
    @PreAuthorize("hasAuthority('UPDATE_PENJUAL')")
    @PutMapping("/{id}")
    public ResponseEntity<Role> Update(@PathVariable Long id,@RequestBody Role role){
        return new ResponseEntity(roleService.update(id,role), HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAuthority('DELETE_PENJUAL')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> Delete(@PathVariable Long id){
        return new ResponseEntity(roleService.delete(id), HttpStatus.OK);
    }
}