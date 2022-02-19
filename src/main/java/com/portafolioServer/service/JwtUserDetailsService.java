/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.service;

import com.portafolioServer.model.Usuario;
import com.portafolioServer.repository.Repository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    
     @Autowired
    private IService interUsuario;
 
	@Override
	public UserDetails loadUserByUsername(String password) throws UsernameNotFoundException {
         if(interUsuario.findByPassword(password)!= null){
 		
			return new User(password, "$2a$10$lG/EuFY5E/BnxpkgMdjFDesfRZ653TyR5wL.4cAL06wZGlnMNVulW",
					new ArrayList<>());
		
	}else{
             throw new UsernameNotFoundException("User not found with password: ");

         }
       }
}
