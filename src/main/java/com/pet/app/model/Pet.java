package com.pet.app.model;

public class Pet {
	private String nome;
	private Dono dono;
	private String tipo;

	public Pet(String nome, Dono dono, String tipo) {
		this.nome = nome;
		this.dono = dono;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dono: ");
		builder.append(dono.toString());
		builder.append("Nome do pet: ");
		builder.append(nome);
		builder.append("Tipo: ");
		builder.append(tipo);
		return builder.toString();
	}
	
	

}
