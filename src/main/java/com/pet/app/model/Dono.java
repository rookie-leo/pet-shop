package com.pet.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // declare the class as a entity and, by doing this, create a connection with the same name table in the database. This make all the data of the object stay there
public class Dono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false) // make sure that the value stays in a unique column
	private String CPF;
	
	@Deprecated
	public Dono() {
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return ID;
	}

	public Dono(String nome, String CPF) {
		this.nome = nome;
		this.CPF = CPF;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nome do dono: ");
		builder.append(nome);
		builder.append("CPF: ");
		builder.append(CPF);
		return builder.toString();
	}

}
//model to how this MF suppose to looks like I suppose