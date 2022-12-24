/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.id.mii.serversidekelompok3.model.Pesanan;
import co.id.mii.serversidekelompok3.repository.PesananRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PesananService {

    @Autowired
    private PesananRepository pesananRepository;

    public Pesanan getById(Long id) {
        return pesananRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pesanan dengan id " + id + " tidak ditemukan!!"));
    }

     public List<Pesanan> getAll() {
        return pesananRepository.findAll();
    }

      public Pesanan create(Pesanan pesanan) {
        return pesananRepository.save(pesanan);
    }

    public Pesanan update(Long id, Pesanan pesanan) {
        getById(id);
        pesanan.setId(id);
        return pesananRepository.save(pesanan);
    }

     public Pesanan delete(Long id) {
       Pesanan pesanan = getById(id);
        pesananRepository.delete(pesanan);
        return pesanan;
    }
    
}

