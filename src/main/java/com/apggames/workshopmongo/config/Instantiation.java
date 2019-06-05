package com.apggames.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.apggames.workshopmongo.domain.User;
import com.apggames.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	//'autowired' para injetar dentro desta classe 'Instantiation' alguma coisa; neste caso o 'UserRepository'
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//limpa no MongoDB os valores da coleção User 
		userRepository.deleteAll();
		
		//colocando 'null' no ID, porque o MongoDB vai adicionar o ID para cada new user
		//instanciando(criando) os objetos no banco de dados
		User maria = new User( null, "Maria Brown", "maria@gmail.com" );
		User alex = new User( null, "AlLex GReen", "alex@gmail.com" );
		User bob = new User( null, "Bob Grey", "bob@gmail.com" );
		
		userRepository.saveAll( Arrays.asList( maria, alex, bob ));
	}
}
