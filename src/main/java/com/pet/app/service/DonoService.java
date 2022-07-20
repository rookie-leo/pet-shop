package com.pet.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.pet.app.model.Dono;
import com.pet.app.repositories.DonoRepository;

@Service//is used with classes that provide some business functionalities. Spring context will autodetect these classes when annotation-based configuration and classpath scanning is used.
public class DonoService{
	
	private final DonoRepository repository;
	
	public DonoService(DonoRepository repository ){
		this.repository=repository;
	}

	public void salvar(Dono dono) {
		repository.save(dono);
		
	}
	
	public List<Dono> findAll(){
		return repository.findAll();
	}

	public ResponseEntity <?> delete(@PathVariable Long id) {//this note tie the reserved space of the URI to a method parameter inside the manipulator method. This is  useful when develop RESTful services which has useful data like parts of your URL.
	   return repository.findById(id)
	           .map(record -> {repository.deleteById(id); 
	           return ResponseEntity.ok().build()
	        	;}).orElse(ResponseEntity.notFound().build());
	}
	
	@Transactional
	public Dono updateDonoParcialmente(Long id, String nome) {
		try {
			Dono dono = repository.findById(id).get();
			dono.setNome(nome);
			dono = repository.save(dono);
			return dono;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
}
