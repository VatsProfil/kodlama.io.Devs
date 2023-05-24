package io.kodlama.Devs.business.concretes;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import io.kodlama.Devs.business.abstracts.ProgrammingLanguageService;
import io.kodlama.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import io.kodlama.Devs.entities.concretes.ProgrammingLanguage;


@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	ProgrammingLanguageRepository programmingLanguageRepository;
	List<ProgrammingLanguage> list;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		list = programmingLanguageRepository.getAll();

	}
	


	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		// TODO Auto-generated method stub
		boolean isExist = false;
		for(ProgrammingLanguage programmingLanguage2 : list) {
			if(programmingLanguage.getName().equals(programmingLanguage2.getName()))
			{
			isExist = true;
			throw new Exception("Bu isim listede var");
			}
		}
		if (isExist == false && !programmingLanguage.getName().isEmpty()) {
			programmingLanguageRepository.add(programmingLanguage);
		}
		
		//programmingLanguageRepository.add(programmingLanguage);
	}

	@Override
	public void delete(int id) throws Exception {

		boolean isExist = false;
		for(ProgrammingLanguage programmingLanguage : list)
		{
			if(id == programmingLanguage.getId()) {
				isExist = true;
			}
		}
		if(isExist) {
		programmingLanguageRepository.delete(id);}
		else {
			throw new Exception("Bu id listede yok");
		}
	}

	@Override
	public void update(int id, String name) throws Exception {
		
		boolean isExist = false;
		for(ProgrammingLanguage programmingLanguage : list)
		{
			if(id == programmingLanguage.getId()) {
				isExist = true;
			}
		}
		if(isExist) {
			if(!name.isEmpty() && !name.isBlank()) {
				programmingLanguageRepository.update(id, name);
				}
			else {
				throw new Exception("bosluk isim olarak girilemez");
			}
			}
	
		else {
				throw new Exception("Bu id listede yok");
			}
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return programmingLanguageRepository.getById(id);
	}

}
