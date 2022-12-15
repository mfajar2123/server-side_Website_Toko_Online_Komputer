/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.id.mii.serversidekelompok3.model.Pengguna;
import co.id.mii.serversidekelompok3.repository.PenggunaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PenggunaService {

    @Autowired
    private PenggunaRepository penggunaRepository;

    public Pengguna getById(Long id) {
        return penggunaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pengguna dengan id " + id + " tidak ditemukan!!"));
    }

     public List<Pengguna> getAll() {
        return penggunaRepository.findAll();
    }

      public Pengguna create(Pengguna pengguna) {
       Pengguna existingPengguna = penggunaRepository.findByNama(pengguna.getNama()).orElse(null);
        if (existingPengguna == null && pengguna.getId() == null) {
            return penggunaRepository.save(pengguna);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama pengguna sudah ada!");
        }
    }

    public Pengguna update(Long id, Pengguna pengguna) {
        getById(id);
        pengguna.setId(id);
        return penggunaRepository.save(pengguna);
    }

     public Pengguna delete(Long id) {
       Pengguna pengguna = getById(id);
        penggunaRepository.delete(pengguna);
        return pengguna;
    }
    
}

