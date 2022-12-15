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
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping // http:/localhost:8088/role
    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity(roleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // http:/localhost:8088/role/1
    public ResponseEntity<Role> getById(@PathVariable Long id) {
        return new ResponseEntity(roleService.getById(id),HttpStatus.OK);
    }

    @PostMapping // http:/localhost:8088/role
    public ResponseEntity<Role> create(@RequestBody Role role) {
        return new ResponseEntity(roleService.create(role),HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // http:/localhost:8088/role/1
    public ResponseEntity<Role> update(@PathVariable Long id,@RequestBody Role role) {
        return new ResponseEntity(roleService.update(id, role),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // http:/localhost:8088/role/1
    public ResponseEntity<Role> delete(@PathVariable Long id) {
        return new ResponseEntity(roleService.delete(id),HttpStatus.OK);
    }
    
    

}