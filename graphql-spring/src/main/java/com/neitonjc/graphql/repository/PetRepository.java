package com.neitonjc.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neitonjc.graphql.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>{
	

}
