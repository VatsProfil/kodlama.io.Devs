package io.kodlama.Devs.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.Devs.business.abstracts.ProgrammingLanguageService;
import io.kodlama.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	
	ProgrammingLanguageService programmingLanguageService;
	
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
	}
	
	@PutMapping("/update")
	public void update(int id, String name) throws Exception {
		programmingLanguageService.update(id, name);
	}
	
	@DeleteMapping("/delete")
	public void delete(int id) throws Exception {
		programmingLanguageService.delete(id);
	}
	
	@GetMapping("/getById")
	public ProgrammingLanguage getById(int id) throws Exception {
		return programmingLanguageService.getById(id);
		
	}

}
