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
    
    @Autowired
    private EmailService emailService;

    public Pesanan getById(Long id) {
        emailService.sendEmail("mfajar2123@upi.edu", "Pesanan Berhasil",
                "Dear customer, Pesanan mu diterima!");
        return pesananRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pesanan dengan id " + id + " tidak ditemukan!!"));
    }

     public List<Pesanan> getAll() {
        return pesananRepository.findAll();
    }

      public Pesanan create(Pesanan pesanan) {
       Pesanan existingPesanan = pesananRepository.findByNama(pesanan.getNama()).orElse(null);
        if (existingPesanan == null && pesanan.getId() == null) {
            return pesananRepository.save(pesanan);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "id atau nama pesanan sudah ada!");
        }
    }

    public Pesanan update(Long id, Pesanan pesanan) {
        getById(id);
        emailService.sendEmail("mfajar2123@upi.edu", "Pesanan Berhasil",
                "Dear customer, Pesanan mu diterima!");
        pesanan.setId(id);
        return pesananRepository.save(pesanan);
    }

     public Pesanan delete(Long id) {
        Pesanan pesanan = getById(id);
        emailService.sendEmailDisapprove("mfajar2123@upi.edu", "Pesanan Gagal",
                "Dear customer, Maaf pesanan mu tidak diterima!");
        pesananRepository.delete(pesanan);
        return pesanan;
    }
     
    public Pesanan getByEmail(Long id) {
        emailService.sendEmail("mfajar2123@upi.edu", "Pesanan Berhasil",
                "Dear customer, Pesanan mu diterima!");
        return pesananRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pesanan dengan id " + id + " tidak ditemukan!!"));
    }
    
}

