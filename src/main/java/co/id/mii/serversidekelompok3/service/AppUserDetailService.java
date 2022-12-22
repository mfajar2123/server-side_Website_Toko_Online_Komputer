///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.id.mii.serversidekelompok3.service;
//
//
//import co.id.mii.serversidekelompok3.model.AppUserDetail;
//import co.id.mii.serversidekelompok3.model.Pengguna;
//import co.id.mii.serversidekelompok3.repository.PenggunaRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Fajarr
// */
//@Service
//@AllArgsConstructor
//public class AppUserDetailService implements UserDetailsService{
//
//    private PenggunaRepository penggunaRepository;
//
//    public UserDetails loadPenggunaByUsername(String username) throws UsernameNotFoundException {
//        Pengguna pengguna = penggunaRepository.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException("Username atau Password salah"));
//        return new AppUserDetail(pengguna);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}