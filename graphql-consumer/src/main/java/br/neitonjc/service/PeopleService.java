package br.neitonjc.service;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.neitonjc.dto.PeopleDTO;
import br.neitonjc.reqbody.GraphqlRequestBody;
import br.neitonjc.util.GraphqlSchemaReaderUtil;

@Service
public class PeopleService {
	
	private final String URL = "http://localhost:8081/graphql/";

	public PeopleDTO getPeopleDetails(final Integer cod) throws IOException {

		GraphqlRequestBody graphQLRequestBody = new GraphqlRequestBody();

		String query = GraphqlSchemaReaderUtil.getSchemaFromFileName("people");
		
		graphQLRequestBody.setQuery(query.replace("$cod", cod.toString()));
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("content-type", "application/graphql");
	    
	    String responseString = restTemplate.postForObject(URL, 
	    												   new HttpEntity<>(graphQLRequestBody.getQuery(), headers), 
	    												   String.class);
	    
	    PeopleDTO pe = new ObjectMapper()
	    	      .readerFor(PeopleDTO.class)
	    	      .readValue(responseString);
	    
	    return pe;
	}
}
