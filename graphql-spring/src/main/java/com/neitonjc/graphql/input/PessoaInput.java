package com.neitonjc.graphql.input;



import com.neitonjc.graphql.model.Genero;

import graphql.schema.GraphQLInputType;

public class PessoaInput implements GraphQLInputType {
	
	public String nome;
	public String email;
	public Genero genero;
	
	
	public PessoaInput() {
		super();
	}


	public PessoaInput(String nome, String email, Genero genero) {
		super();
		this.nome = nome;
		this.email = email;
		this.genero = genero;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
