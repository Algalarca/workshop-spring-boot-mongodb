package com.apggames.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apggames.workshopmongo.domain.User;
import com.apggames.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List< User > findAll() {
		return repo.findAll();
	}

}
