package io.kodlama.Devs.business.abstracts;

import java.util.List;

import io.kodlama.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	public void add(ProgrammingLanguage programmingLanguage) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public void update(int id, String name) throws Exception;
	
	public List<ProgrammingLanguage> getAll();
	
	public ProgrammingLanguage getById(int id) throws Exception;

}
