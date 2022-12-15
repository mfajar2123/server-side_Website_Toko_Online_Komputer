/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.repository;
import co.id.mii.serversidekelompok3.model.Pesanan;
import co.id.mii.serversidekelompok3.model.Produk;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fajar
 */

@Repository
public interface PesananRepository extends JpaRepository<Pesanan, Long>{
   Optional<Pesanan> findByNomor(String pesanan);
}