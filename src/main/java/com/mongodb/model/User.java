package com.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

// Muda um pouco a forma como a entidade é mapeada, é bem mais simples pelo fato de não ter um schema rígido. É necessário definir um index, de qualquer maneira, mas não há muitas complicações com Joins. As relações são feitas com DBRef.
// A anotação muda de Entity para Document.

@Data
@Document
public class User {

	@Id
	private String id;
	private String nome;
	private Integer idade;
	private String profissao;
	// O DBRef vai criar, a nível da coleção do Mongo, um capmo de referência a um "id" e uma "coleção".
	// Pode ser tanto a mesma coleção da entidade, como é este caso, como também pode ser uma outra coleção no database.
	@DBRef
	private User esposa;	
}
