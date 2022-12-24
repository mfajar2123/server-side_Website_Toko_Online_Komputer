/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.service;


import co.id.mii.serversidekelompok3.model.Pengguna;
import co.id.mii.serversidekelompok3.model.dto.Request.LoginRequest;
import co.id.mii.serversidekelompok3.model.dto.response.LoginResponse;
import co.id.mii.serversidekelompok3.repository.PenggunaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LoginService {

    private AuthenticationManager authenticationManager;
    private AppUserDetailService appUserDetailService;
    private PenggunaRepository penggunaRepository;

    public LoginResponse login(LoginRequest loginRequest) {

        // Manually Basic Authentication
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()
        );
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContextHolder.getContext().setAuthentication(auth);

        UserDetails userDetail = appUserDetailService.loadUserByUsername(loginRequest.getUsername());
        Pengguna pengguna = penggunaRepository.findByUsername(loginRequest.getUsername()).get();

        List<String> authorities = userDetail.getAuthorities()
                .stream().map(authority -> authority.getAuthority())
                .collect(Collectors.toList());

        return new LoginResponse(pengguna.getUsername(), pengguna.getEmail(), authorities);

    }

}