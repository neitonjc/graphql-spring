package com.neitonjc.graphql.resolver;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.neitonjc.graphql.model.Pet;
import com.neitonjc.graphql.repository.PetRepository;

@Component
public class PetResolver implements GraphQLQueryResolver {
	
	@Autowired
	private PetRepository rep;
	
	public Collection<Pet> findAllPets(){
		return rep.findAll();
	}
	
	public Pet findPetById(Integer cod) {
		return rep.findById(cod).get();
	}
} 
