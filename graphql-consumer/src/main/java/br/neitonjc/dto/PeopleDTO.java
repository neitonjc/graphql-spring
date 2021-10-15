package br.neitonjc.dto;

import java.util.Map;

import javax.management.AttributeNotFoundException;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeopleDTO {
	
	public Integer cod;
	public String nome;
    public String email;
    public String genero;
    
    @SuppressWarnings("unchecked")
	@JsonProperty("data")
    private void unpackNested(Map<String,Object> data) throws AttributeNotFoundException {
        Map<String,String> people = (Map<String,String>)data.get("findPeopleById");
        
        if (people == null)
        	throw new AttributeNotFoundException();
        	
        Object o = people.get("cod");
        
        if (o instanceof Integer)
        	this.cod = (Integer) o;
        
        this.nome = people.get("nome");
        this.email = people.get("email");
        this.genero = people.get("genero");
    }
    
    
	
}
