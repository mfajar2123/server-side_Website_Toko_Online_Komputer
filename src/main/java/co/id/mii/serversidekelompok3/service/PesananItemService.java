/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.id.mii.serversidekelompok3.model.PesananItem;
import co.id.mii.serversidekelompok3.repository.PesananItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PesananItemService {

    @Autowired
    private PesananItemRepository pesananItemRepository;

    public PesananItem getById(Long id) {
        return pesananItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PesananItem dengan id " + id + " tidak ditemukan!!"));
    }

     public List<PesananItem> getAll() {
        return pesananItemRepository.findAll();
    }

      public PesananItem create(PesananItem pesananItem) {
          
        if (pesananItem.getId() != null) {           
        throw new ResponseStatusException(HttpStatus.CONFLICT, "id pesananItem sudah ada!");
        }
         return pesananItemRepository.save(pesananItem);
      }


    public PesananItem update(Long id, PesananItem pesananItem) {
        getById(id);
        pesananItem.setId(id);
        return pesananItemRepository.save(pesananItem);
    }

     public PesananItem delete(Long id) {
       PesananItem pesananItem = getById(id);
        pesananItemRepository.delete(pesananItem);
        return pesananItem;
    }
    
}

