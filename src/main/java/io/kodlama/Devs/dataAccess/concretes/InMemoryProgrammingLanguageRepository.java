package io.kodlama.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.kodlama.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import io.kodlama.Devs.entities.concretes.ProgrammingLanguage;


@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> listProgrammingLanguages;
	
	
	public InMemoryProgrammingLanguageRepository() {
		
		listProgrammingLanguages = new ArrayList<ProgrammingLanguage>();
		listProgrammingLanguages.add(new ProgrammingLanguage(1, "Java"));
		listProgrammingLanguages.add(new ProgrammingLanguage(2, "Javascript"));
		listProgrammingLanguages.add(new ProgrammingLanguage(3, "C"));
		listProgrammingLanguages.add(new ProgrammingLanguage(4, "C++"));
		listProgrammingLanguages.add(new ProgrammingLanguage(5, "Python"));

	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		listProgrammingLanguages.add(programmingLanguage);
	}

	
	@Override
	public void delete(int id) throws Exception {
		
		listProgrammingLanguages.remove(listProgrammingLanguages.indexOf(this.getById(id)));

	}

	@Override
	public void update(int id, String name) throws Exception {
	
		listProgrammingLanguages.get(
				listProgrammingLanguages.indexOf(this.getById(id))).setName(name);
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return listProgrammingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		int index=0;
		boolean isExist = false;
		// TODO Auto-generated method stub
		for (ProgrammingLanguage programmingLanguage : listProgrammingLanguages) {
			if(programmingLanguage.getId() == id){
			
				isExist = true;
				index = listProgrammingLanguages.indexOf(programmingLanguage);
			
			}
			
		}
		
		if(isExist == false) {
			throw new Exception("Boyle bir id yok");
		}
		
		
		
		
		return listProgrammingLanguages.get(index);
	}

}
