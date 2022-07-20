package com.pet.app.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pet.app.controller.request.AtualizaNomeDonoRequest;
import com.pet.app.controller.request.DonoRequest;
import com.pet.app.model.Dono;
import com.pet.app.service.DonoService;

@RestController//controls who's going to receive the requisitions and who suppose to answer them
@RequestMapping("/petshop/dono")//it demands the URL to have what have in the "" above everything
public class DonoController {
	
	private DonoService service;
	
	@Autowired//injeção de independência(não sei escrever isso em inglês kkkk ainda)
	public DonoController(DonoService service) {
		this.service=service;
	}
	
	@PostMapping("/cadastrar")//creates a new contact and make sure you type what have in the "", and after the @RequestMapping 
	public ResponseEntity<Void>cadastrar(@Valid @RequestBody DonoRequest request){ //@RequestBody = Annotation indicating a method parameter should be bound to the body of the HTTP request
																				//@Valid = Make sure all things put here are valid ones							
		Dono dono = request.toModel();
		
		service.salvar(dono);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/petshop/dono/{id}").buildAndExpand(dono.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@GetMapping//annotated methods in the @Controller annotated classes handle the HTTP GET requests matched with given URI expression and requests onto specific handler methods
	public List<?> findAll(){
	   return service.findAll();
	}
	
	@PutMapping("/patch/{id}")
	public ResponseEntity<Dono> updateDonoParcialmente(@PathVariable Long id, @RequestBody AtualizaNomeDonoRequest request) {
		
		service.updateDonoParcialmente(id, request.getNome());
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")//annotation maps HTTP DELETE requests onto specific handler methods
	public ResponseEntity <?> delete(@PathVariable Long id) {
	   return service.delete(id);
	}
}
//the controller that must use the GetMapping and the PostMapping
//his the bridge of the web- online part - to the not web- not online part -  