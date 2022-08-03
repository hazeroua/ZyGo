package com.zygo.mvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zygo.mvc.Repository.ArmsExerciceRepository;
import com.zygo.mvc.Repository.ArmsSerieRepository;
import com.zygo.mvc.Repository.UserRepository;
import com.zygo.mvc.entities.ArmsExercice;
import com.zygo.mvc.entities.ArmsSerie;

@Service
public class ArmsService {
	@Autowired
	private ArmsExerciceRepository repository;
	@Autowired
	private UserRepository Urepository;
	@Autowired
	private ArmsSerieRepository Srepository;
	
	public ArmsExercice findByIdEL(Long id) {
		return repository.findByIdEA(id);
	}
	public ArmsSerie findByIdSL(Long id) {
		return Srepository.findByIdSA(id);
	}
	public List<ArmsExercice> getAllExoByUsername(String username){
		return Urepository.findByUsername(username).getExercicesA();
	}
	public void saveExercice(ArmsExercice e,String username) {
		Urepository.findByUsername(username).SetExerciceAForaUser(e);
		e.setUser(Urepository.findByUsername(username));
		repository.save(e);
	}
	public List<ArmsSerie> getAllSerie(){
		return Srepository.findAll();
	}
	public ArmsSerie getSerieById(Long id) {
		return Srepository.findById(id).orElse(null);
	}
	public ArmsSerie saveSerie(ArmsSerie s) {
		return Srepository.save(s);
	}
	public List<ArmsSerie> getAllSerieByEx(ArmsExercice e){
		return e.getSeriesA();
	}
	public void ArmsAddSerieForAnExercice(ArmsSerie s, Long id) {
		repository.findByIdEA(id).getSeriesA().add(s);
		 s.setExercieA(repository.findByIdEA(id));
		 Srepository.save(s);
	}
	public void deleteSerie(ArmsSerie s) {
		Srepository.delete(s);
	}
}
