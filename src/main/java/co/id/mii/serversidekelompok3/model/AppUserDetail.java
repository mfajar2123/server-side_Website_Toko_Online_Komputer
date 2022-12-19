/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Fajarr
 */
public class AppUserDetail implements UserDetails {
    private Pengguna pengguna;
    public AppUserDetail(Pengguna pengguna) {
        this.pengguna = pengguna;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // UPPERCASE, ROLE_
//        return pengguna.getRoles()
//                .stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getName().toUpperCase()))
//                .collect(Collectors.toList());

        List<GrantedAuthority> authorities = new ArrayList<>();
        pengguna.getRoles().forEach(penggunaRole -> {
            String role =  "ROLE_" + penggunaRole.getNama().toUpperCase();
            authorities.add(new SimpleGrantedAuthority(role));

            penggunaRole.getPrivileges().forEach(rolePrivilege -> {
                String privilege = rolePrivilege.getName().toUpperCase();
                authorities.add(new SimpleGrantedAuthority(privilege));
            });
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return pengguna.getPassword();
    }
    @Override
    public String getUsername() {
        return pengguna.getUsername();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return !pengguna.getIsAktif(); // Verifikasi Akun
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}