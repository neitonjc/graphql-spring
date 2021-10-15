package br.neitonjc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.neitonjc.dto.PeopleDTO;
import br.neitonjc.service.PeopleService;

@RestController
@RequestMapping({"/people"})
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping
	public ResponseEntity<PeopleDTO> getPeople(@RequestParam Integer peopleId) throws IOException{
		return new ResponseEntity<PeopleDTO>(peopleService.getPeopleDetails(peopleId), HttpStatus.OK);
	}
	
}
