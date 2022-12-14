/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.id.mii.serversidekelompok3.model.Produk;
import co.id.mii.serversidekelompok3.repository.ProdukRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    public Produk getById(Long id) {
        return produkRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produk dengan id " + id + " tidak ditemukan!!"));
    }

     public List<Produk> getAll() {
        return produkRepository.findAll();
    }

      public Produk create(Produk produk) {
       Produk existingProduk = produkRepository.findByNama(produk.getNama()).orElse(null);
        if (existingProduk == null && produk.getId() == null) {
            return produkRepository.save(produk);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama produk sudah ada!");
        }
    }

    public Produk update(Long id, Produk produk) {
        getById(id);
        produk.setId(id);
        return produkRepository.save(produk);
    }

     public Produk delete(Long id) {
       Produk produk = getById(id);
        produkRepository.delete(produk);
        return produk;
    }
    
}

