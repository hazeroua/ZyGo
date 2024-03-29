package com.zygo.mvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zygo.mvc.Repository.LatsExerciceRepository;
import com.zygo.mvc.Repository.LatsSerieRepository;
import com.zygo.mvc.Repository.ShouldersExerciceRepository;
import com.zygo.mvc.Repository.ShouldersSerieRepository;
import com.zygo.mvc.Repository.UserRepository;
import com.zygo.mvc.entities.Exercice;
import com.zygo.mvc.entities.LatsExercice;
import com.zygo.mvc.entities.LatsSerie;
import com.zygo.mvc.entities.Serie;
import com.zygo.mvc.entities.ShouldersExercice;
import com.zygo.mvc.entities.ShouldersSerie;
import com.zygo.mvc.entities.User;

@Service
public class ShouldersService {
	@Autowired
	private ShouldersExerciceRepository repository;
	@Autowired
	private UserRepository Urepository;
	@Autowired
	private ShouldersSerieRepository Srepository;
	
	public ShouldersExercice findByIdEL(Long id) {
		return repository.findByIdES(id);
	}
	public ShouldersSerie findByIdSL(Long id) {
		return Srepository.findByIdSS(id);
	}
	public List<ShouldersExercice> getAllExoByUsername(String username){
		return Urepository.findByUsername(username).getExercicesS();
	}
	public void saveExercice(ShouldersExercice e,String username) {
		Urepository.findByUsername(username).SetExerciceSForaUser(e);
		e.setUser(Urepository.findByUsername(username));
		repository.save(e);
	}
	public List<ShouldersSerie> getAllSerie(){
		return Srepository.findAll();
	}
	public ShouldersSerie getSerieById(Long id) {
		return Srepository.findById(id).orElse(null);
	}
	public ShouldersSerie saveSerie(ShouldersSerie s) {
		return Srepository.save(s);
	}
	public List<ShouldersSerie> getAllSerieByEx(ShouldersExercice e){
		return e.getSeriesS();
	}
	public void ShouldersAddSerieForAnExercice(ShouldersSerie s, Long id) {
		repository.findByIdES(id).getSeriesS().add(s);
		 s.setExercieS(repository.findByIdES(id));
		 Srepository.save(s);
	}

	public ShouldersSerie deleteSerie(Long id) {
		ShouldersSerie s = Srepository.findByIdSS(id);
		ShouldersExercice e = s.getExercieS();
		 e.getSeriesS().remove(s);
		 Srepository.delete(s);
		 
		 return s;
	}
	public ShouldersExercice deleteExercice(Long id) {
		ShouldersExercice e = repository.findByIdES(id);
		User u = e.getUser();
		for(ShouldersSerie s : this.getAllSerieByEx(e)) {
			Long idn=s.getIdSS();
			this.deleteSerie(idn);
		}
		u.getExercicesS().remove(e);
		repository.delete(e);
		

		return e;
	}
}
