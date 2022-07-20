package com.pet.app.controller.request;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.pet.app.model.Dono;

public class DonoRequest {

	@NotBlank //@NotNull does not work, imagine String as a journal, a journal CAN be blank, but NOT inexistent/null
	private String nome;

	@CPF//it demands a number in the CPF pattern
	private String CPF;
	
	public DonoRequest(@NotBlank String nome, @CPF String CPF) {
		super();
		this.nome = nome;
		this.CPF = CPF;
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public void setCPF(String CPF) {
		this.CPF=CPF;
	}

	public Dono toModel() {
		return new Dono(nome, CPF);
	}
	
}
//for what I understood, here you make the checkout of the things that get in and make sure that only the right ones pass trough
