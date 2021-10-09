package com.neitonjc.graphql.resolver;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.neitonjc.graphql.model.Pessoa;
import com.neitonjc.graphql.repository.PessoaRepository;

@Component
public class PessoaResolver implements GraphQLQueryResolver {
	
	@Autowired
	private PessoaRepository rep;
	
	public Collection<Pessoa> findAllPeople(){
		return rep.findAll();
	}
	
	public Pessoa findPeopleById(Integer cod) {
		return rep.findById(cod).get();
	}
} 
