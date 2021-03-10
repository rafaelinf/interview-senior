package br.com.brainweb.interview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brainweb.interview.dto.CreateHeroDTO;
import br.com.brainweb.interview.dto.HeroDTO;
import br.com.brainweb.interview.dto.UpdateHeroDTO;
import br.com.brainweb.interview.exception.HeroExistsException;
import br.com.brainweb.interview.exception.NotFoundException;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;
import br.com.brainweb.interview.repository.HeroRepository;

@Service
public class HeroService {

	@Autowired
	private HeroRepository heroRepository;
	
	@Autowired
	private PowerStatsService powerStatsService;
	
	public Hero save(CreateHeroDTO createHeroDTO) {
		
		if(heroRepository.existsHeroByName(createHeroDTO.getName())) {
			throw new HeroExistsException();
		}
		
		PowerStats powerStats = powerStatsService.save(createHeroDTO.getPowerStats());
		
		Hero hero = Hero.builder()
				.name(createHeroDTO.getName())
				.race(createHeroDTO.getRace())
				.enabled(createHeroDTO.getEnabled())
				.powerStats(powerStats)
				.build();
			
		return heroRepository.save(hero);
		
	}
	
	public Hero update(String id, UpdateHeroDTO updateHeroDTO) {
		
		Hero hero = this.findHeroById(id);
		
		powerStatsService.update(hero.getPowerStats(), updateHeroDTO.getPowerStats());
		
		hero.setName(updateHeroDTO.getName());
		hero.setRace(updateHeroDTO.getRace());
		hero.setEnabled(updateHeroDTO.getEnabled());
		return heroRepository.save(hero);
		
	}
	
	public void delete(String id) {
		
		Hero hero = this.findHeroById(id);
		heroRepository.delete(hero);
		
	}
	
	public Hero findHeroById(String id) {
		
		Optional<Hero> hero = heroRepository.findById(id);
		if(!hero.isPresent()) {
			throw new NotFoundException();
		}
		
		return hero.get();
	}	
	
	public Hero findHeroByName(String name) {
		
		Optional<Hero> hero = heroRepository.findByName(name);
		if(!hero.isPresent()) {
			throw new NotFoundException();
		}
		
		return hero.get();
	}		
	
	public List<HeroDTO> findHeroes(){

		List<HeroDTO> ls = new ArrayList<>();

//		List<Optional> listAll = this.heroRepository.findAll();
//		for (Hero h : listAll) {
//			ls.add(HeroDTO.builder().id(h.getId()).build());
//		}
		
		return ls;
	}
	
}
