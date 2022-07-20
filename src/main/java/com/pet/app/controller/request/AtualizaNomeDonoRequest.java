package com.pet.app.controller.request;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.pet.app.model.Dono;

public class AtualizaNomeDonoRequest {

	@NotBlank 
	private String nome;

	public AtualizaNomeDonoRequest() {
		super();
	}

	public AtualizaNomeDonoRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
