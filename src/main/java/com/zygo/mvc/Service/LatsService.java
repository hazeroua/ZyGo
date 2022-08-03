package com.zygo.mvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zygo.mvc.Repository.LatsExerciceRepository;
import com.zygo.mvc.Repository.LatsSerieRepository;
import com.zygo.mvc.Repository.UserRepository;
import com.zygo.mvc.entities.LatsExercice;
import com.zygo.mvc.entities.LatsSerie;

@Service
public class LatsService {
	@Autowired
	private LatsExerciceRepository repository;
	@Autowired
	private UserRepository Urepository;
	@Autowired
	private LatsSerieRepository Srepository;
	
	public LatsExercice findByIdEL(Long id) {
		return repository.findByIdEL(id);
	}
	public LatsSerie findByIdSL(Long id) {
		return Srepository.findByIdSL(id);
	}
	public List<LatsExercice> getAllExoByUsername(String username){
		return Urepository.findByUsername(username).getExercicesL();
	}
	public void saveExercice(LatsExercice e,String username) {
		Urepository.findByUsername(username).SetExerciceLForaUser(e);
		e.setUser(Urepository.findByUsername(username));
		repository.save(e);
	}
	public List<LatsSerie> getAllSerie(){
		return Srepository.findAll();
	}
	public LatsSerie getSerieById(Long id) {
		return Srepository.findById(id).orElse(null);
	}
	public LatsSerie saveSerie(LatsSerie s) {
		return Srepository.save(s);
	}
	public List<LatsSerie> getAllSerieByEx(LatsExercice e){
		return e.getSeriesL();
	}
	public void LatsAddSerieForAnExercice(LatsSerie s, Long id) {
		repository.findByIdEL(id).getSeriesL().add(s);
		 s.setExercie(repository.findByIdEL(id));
		 Srepository.save(s);
	}
	public void deleteSerie(LatsSerie s) {
		Srepository.delete(s);
	}
	
}
