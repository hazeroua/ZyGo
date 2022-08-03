package com.zygo.mvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zygo.mvc.Repository.LegsExerciceRepository;
import com.zygo.mvc.Repository.LegsSerieRepository;
import com.zygo.mvc.Repository.UserRepository;
import com.zygo.mvc.entities.LegsExercice;
import com.zygo.mvc.entities.LegsSerie;

@Service
public class LegsService {
	@Autowired
	private LegsExerciceRepository repository;
	@Autowired
	private UserRepository Urepository;
	@Autowired
	private LegsSerieRepository Srepository;
	
	public LegsExercice findByIdEL(Long id) {
		return repository.findByIdELe(id);
	}
	public LegsSerie findByIdSL(Long id) {
		return Srepository.findByIdSLe(id);
	}
	public List<LegsExercice> getAllExoByUsername(String username){
		return Urepository.findByUsername(username).getExercicesLe();
	}
	public void saveExercice(LegsExercice e,String username) {
		Urepository.findByUsername(username).SetExerciceLeForaUser(e);
		e.setUser(Urepository.findByUsername(username));
		repository.save(e);
	}
	public List<LegsSerie> getAllSerie(){
		return Srepository.findAll();
	}
	public LegsSerie getSerieById(Long id) {
		return Srepository.findById(id).orElse(null);
	}
	public LegsSerie saveSerie(LegsSerie s) {
		return Srepository.save(s);
	}
	public List<LegsSerie> getAllSerieByEx(LegsExercice e){
		return e.getSeriesLe();
	}
	public void LegsAddSerieForAnExercice(LegsSerie s, Long id) {
		repository.findByIdELe(id).getSeriesLe().add(s);
		 s.setExercieLe(repository.findByIdELe(id));
		 Srepository.save(s);
	}
	public void deleteSerie(LegsSerie s) {
		Srepository.delete(s);
	}
}
