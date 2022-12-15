/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.id.mii.serversidekelompok3.model.Role;
import co.id.mii.serversidekelompok3.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role dengan id " + id + " tidak ditemukan!!"));
    }

     public List<Role> getAll() {
        return roleRepository.findAll();
    }

      public Role create(Role role) {
       Role existingRole = roleRepository.findByNama(role.getNama()).orElse(null);
        if (existingRole == null && role.getId() == null) {
            return roleRepository.save(role);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama role sudah ada!");
        }
    }

    public Role update(Long id, Role role) {
        getById(id);
        role.setId(id);
        return roleRepository.save(role);
    }

     public Role delete(Long id) {
       Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }
    
}

