/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portafolioServer.config.JwtTokenUtil;
import com.portafolioServer.model.JwtRequest;
import com.portafolioServer.model.JwtResponse;
import com.portafolioServer.model.ResponseToken;
import com.portafolioServer.model.RolUsuario;
import com.portafolioServer.model.Usuario;
import com.portafolioServer.service.JwtUserDetailsService;
import com.portafolioServer.service.ServiceUsuario;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins="https://mi-portafolio-fbb13.web.app")
public class JwtAuthenticationController {

    
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
        
        @Autowired
	RestTemplate restTemplate;
        
        @Autowired
        ServiceUsuario s_u;

       // RolUsuario registrationUser = getRegistrationUser();
        
        @RequestMapping(value = "/registrar", method=RequestMethod.POST)
        public String registrar(@RequestBody Usuario registerUser) throws Exception{
           
            String newUser = "No hay nada";
            System.out.println(newUser);
          
                    
                 registerUser.setId(Long.MIN_VALUE + s_u.getUsuario().size());
                          s_u.savedUsuario(registerUser);
                
                newUser = "Nuevo usuario agregado";
                
				// convert the user authentication object to JSON
				// create headers specifying that it is JSON request
				
            
            return newUser;
        }
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getPassword());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
        
        //private RolUsuario getRegistrationUser() {
	//	RolUsuario user = new RolUsuario();
	//	user.setNombre("javainuse");
	//	user.setPassword("javainuse");
	//	user.setRole("ROLE_ADMIN");
	//	return user;
	//}
        
        private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
        
        private String getBody(final JwtRequest user) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(user);
	}
}
