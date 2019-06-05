package com.apggames.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apggames.workshopmongo.domain.User;
import com.apggames.workshopmongo.dto.UserDTO;
import com.apggames.workshopmongo.services.UserService;

@RestController
@RequestMapping( value = "/users" )
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping( method = RequestMethod.GET )
	//@GetMapping
	public ResponseEntity< List< UserDTO > > findAll() {
		
		List< User > list = service.findAll();
		//instrução LAMBDA
		List< UserDTO > listDTO = list.stream().map( x -> new UserDTO( x )).collect( Collectors.toList() );
		return ResponseEntity.ok().body( listDTO );
	}
}
