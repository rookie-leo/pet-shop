package com.pet.app.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.pet.app.model.Dono;
import com.pet.app.model.Pet;

public class PetRequest {
	@NotBlank
	private String nome;
	
	@NotNull
	private Dono dono;
	
	@NotBlank
	private String tipo;
	
	public PetRequest(@NotBlank String nome, @NotNull Dono dono, @NotBlank String tipo) {
		super();
		this.nome = nome;
		this.dono = dono;
		this.tipo = tipo;
	}

	public Pet toModel() {
		return new Pet(nome,dono,tipo);
	}
}
