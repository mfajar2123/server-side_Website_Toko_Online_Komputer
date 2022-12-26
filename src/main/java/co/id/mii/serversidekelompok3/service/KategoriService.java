/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.id.mii.serversidekelompok3.model.Kategori;
import co.id.mii.serversidekelompok3.repository.KategoriRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class KategoriService {

    @Autowired
    private KategoriRepository kategoriRepository;

    public Kategori getById(Long id) {
        return kategoriRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Kategori dengan id " + id + " tidak ditemukan!!"));
    }

    public List<Kategori> getAll() {
        return kategoriRepository.findAll();
    }

    public Kategori create(Kategori kategori) {
        Kategori existingKategori = kategoriRepository.findByNama(kategori.getNama()).orElse(null);
        if (existingKategori == null && kategori.getId() == null) {
            return kategoriRepository.save(kategori);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama kategori sudah ada!");
        }
    }

    public Kategori update(Long id, Kategori kategori) {
        getById(id);
        kategori.setId(id);
        return kategoriRepository.save(kategori);
    }

    public Kategori delete(Long id) {
        Kategori kategori = getById(id);
        kategoriRepository.delete(kategori);
        return kategori;
    }
}