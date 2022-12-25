/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;

import co.id.mii.serversidekelompok3.model.Pengguna;
import co.id.mii.serversidekelompok3.model.Role;
import co.id.mii.serversidekelompok3.model.dto.Request.PenggunaRequest;
import co.id.mii.serversidekelompok3.repository.PenggunaRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author MSI-JO
 */
@Service
@AllArgsConstructor
public class PenggunaService {

    private PenggunaRepository penggunaRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    public List<Pengguna> getAll() {
        return penggunaRepository.findAll();
    }
    public Pengguna getById(Long id) {
        return penggunaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pengguna not found"));
    }
//     ModelMapper (JUMAT)
    public Pengguna create(PenggunaRequest penggunaRequest) {
        Pengguna pengguna = new Pengguna();
        pengguna.setNama(penggunaRequest.getNama());
        pengguna.setEmail(penggunaRequest.getEmail());
        pengguna.setNo_hp(penggunaRequest.getNo_hp());
        pengguna.setAlamat(penggunaRequest.getAlamat());
        pengguna.setUsername(penggunaRequest.getUsername());
        pengguna.setPassword(passwordEncoder.encode(penggunaRequest.getPassword()));

        

        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(2L));
        pengguna.setRoles(roles);
        
      
        return penggunaRepository.save(pengguna);
    }
    public Pengguna update(Long id, Pengguna pengguna) {
        Pengguna oldData = getById(id);
        pengguna.setId(id);
        pengguna.setUsername(oldData.getUsername());
        pengguna.setPassword(oldData.getPassword());
        pengguna.setRoles(oldData.getRoles());
        pengguna.setIsAccountLocked(oldData.getIsAccountLocked());
        pengguna.setIsEnabled(oldData.getIsEnabled());
        
        return penggunaRepository.save(pengguna);
    }
    
    public Pengguna delete(Long id){
        Pengguna pengguna = getById(id);
        penggunaRepository.delete(pengguna);
        return pengguna;
    }
}