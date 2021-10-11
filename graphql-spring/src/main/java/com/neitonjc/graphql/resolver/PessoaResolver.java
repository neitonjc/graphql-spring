package com.neitonjc.graphql.resolver;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.neitonjc.graphql.input.PessoaInput;
import com.neitonjc.graphql.model.Pessoa;
import com.neitonjc.graphql.repository.PessoaRepository;

@Component
public class PessoaResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	@Autowired
	private PessoaRepository rep;
	
	public Collection<Pessoa> findAllPeople(){
		return rep.findAll();
	}
	
	public Pessoa findPeopleById(Integer cod) {
		return rep.findById(cod).get();
	}
	
	public Pessoa savePeople(PessoaInput p) {
		return rep.save(new Pessoa(p.nome, p.email, p.genero));
	}
	
	public Pessoa updatePeople(Integer peopleId, String email) {
		Pessoa p = rep.findById(peopleId).get();
		p.setEmail(email);
		
		return rep.save(p);
	}
} 
