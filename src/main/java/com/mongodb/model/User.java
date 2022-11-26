package com.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {

	@Id
	private String id;
	private String nome;
	private Integer idade;
	private String profissao;
	@DBRef
	private User esposa;	
}
