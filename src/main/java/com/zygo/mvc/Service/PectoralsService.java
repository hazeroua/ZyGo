package com.zygo.mvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zygo.mvc.Repository.ExerciceRepository;
import com.zygo.mvc.Repository.ProgrammeRepository;
import com.zygo.mvc.Repository.SerieRepository;
import com.zygo.mvc.Repository.UserRepository;
import com.zygo.mvc.entities.Exercice;
import com.zygo.mvc.entities.Programme;
import com.zygo.mvc.entities.Serie;
import com.zygo.mvc.entities.User;
@Service
public class PectoralsService {
	@Autowired
	private ExerciceRepository repository;
	@Autowired
	private UserRepository Urepository;
	@Autowired
	private SerieRepository Srepository;
	@Autowired
	private ProgrammeRepository Prepository;
	
	public Exercice findByIdE(Long id) {
		return repository.findByIdE(id);
	}
	public Serie findByIdS(Long id) {
		return Srepository.findByIdS(id);
	}
	public List<Exercice> getAllExoByUsername(String username){
		return Urepository.findByUsername(username).getExercices();
	}
	public void saveExercice(Exercice e,String username) {
		Urepository.findByUsername(username).SetExerciceForaUser(e);
		e.setUser(Urepository.findByUsername(username));
		repository.save(e);
	}
	public List<Serie> getAllSerie(){
		return Srepository.findAll();
	}
	public Serie getSerieById(Long id) {
		return Srepository.findById(id).orElse(null);
	}
	public Serie saveSerie(Serie s) {
		return Srepository.save(s);
	}
	public List<Serie> getAllSerieByEx(Exercice e){
		return e.getSeries();
	}
	public void addSerieForAnExercice(Serie s, Long id) {
		repository.findByIdE(id).getSeries().add(s);
		 s.setExercie(repository.findByIdE(id));
		 Srepository.save(s);
	}
	public Serie deleteSerie(Long id) {
		Serie s = Srepository.findByIdS(id);
		Exercice e = s.getExercie();
		 e.getSeries().remove(s);
		 Srepository.delete(s);
		 
		 return s;
	}
	public Exercice deleteExercice(Long id) {
		Exercice e = repository.findByIdE(id);
		User u = e.getUser();
		u.getExercices().remove(e);
		repository.delete(e);

		return e;
	}
	public List<Programme> findAllProgrammes() {
		return Prepository.findAll();
	}
	public void saveProgramme(Programme p , String username) {
		Urepository.findByUsername(username).setProgrammeForaUser(p);
		p.setUser(Urepository.findByUsername(username));
		Prepository.save(p);
	}
	public void addExForAProg(Long idE, Long idP) {
		Exercice e = repository.findByIdE(idE);
		Programme p = Prepository.findByIdPr(idP);
		p.setAnExerciceForAProgramme(e);
		e.setProgrammeForAnExercice(p);
	}

	public List<Exercice> getAllExoOfAProgramme(Long id){
		return Prepository.findByIdPr(id).getExercices();
	}
	public User getUserFromTheIdOfProgramme(Long id) {
		return Prepository.findByIdPr(id).getUser();
	}
	public Programme findProgrammeById(Long id) {
		return Prepository.findByIdPr(id);
	}
	
}



























