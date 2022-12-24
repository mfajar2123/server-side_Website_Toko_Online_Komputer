/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serversidekelompok3.config;


import co.id.mii.serversidekelompok3.service.AppUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 *
 * @author Fajarr
 */
@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private AppUserDetailService appUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
               .userDetailsService(appUserDetailService) // Implementasikan JPA Spring Security
               .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                
                .csrf().disable()
                .authorizeRequests()
//               .antMatchers("/login/**").permitAll()
                  
//                .antMatchers("/produk/**").hasAnyRole("PENGGUNA", "PENJUAL")
//                .antMatchers("/pengguna/**").hasRole("PENJUAL")
                . antMatchers(HttpMethod.POST,"/login/**").permitAll()
                . antMatchers(HttpMethod.POST,"/pengguna").permitAll()
//                . antMatchers(HttpMethod.POST,"/produk").permitAll()
                
//                .antMatchers("/produk/**").hasAnyRole("PENGGUNA", "PENJUAL")
//                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}