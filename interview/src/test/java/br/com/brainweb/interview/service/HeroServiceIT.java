package br.com.brainweb.interview.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.brainweb.interview.build.BuildsBase;
import br.com.brainweb.interview.dto.CreateHeroDTO;
import br.com.brainweb.interview.dto.UpdateHeroDTO;
import br.com.brainweb.interview.exception.HeroExistsException;
import br.com.brainweb.interview.exception.NotFoundException;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;
import br.com.brainweb.interview.repository.HeroRepository;

@ExtendWith(SpringExtension.class)
public class HeroServiceIT extends BuildsBase {

	@InjectMocks
	HeroService heroService;
	
	@Mock
	PowerStatsService powerStatsService;
	
	@Mock
	HeroRepository heroRepository;
	
	@Test
	public void mustSaveHeroSuccess() {
		
		CreateHeroDTO createHeroDTO = buildCreateHeroDTO();
		
		PowerStats powerStats = buildPowerStats();
		Hero hero = buildHero();
		
		when(heroRepository.existsHeroByName(createHeroDTO.getName())).thenReturn(false);
		when(powerStatsService.save(createHeroDTO.getPowerStats())).thenReturn(powerStats);
		when(heroRepository.save(hero)).thenReturn(hero);

		Hero heroResponse = heroService.save(createHeroDTO);
		Assertions.assertNotNull(heroResponse);
		Assertions.assertEquals(heroResponse.getName(), createHeroDTO.getName());
		
	}
	
	@Test
	public void heroExistsReturnException() {
		
		CreateHeroDTO createHeroDTO = buildCreateHeroDTO();
			
		when(heroRepository.existsHeroByName(createHeroDTO.getName())).thenReturn(true);

		HeroExistsException exception = Assertions.assertThrows(HeroExistsException.class, () -> heroService.save(createHeroDTO));
		Assertions.assertNotNull(exception);
		
	}	

	@Test
	public void mustUpdateHeroSuccess() {
		
		String id = "id";
		UpdateHeroDTO updateHeroDTO = buildUpdateHeroDTO();
		
		Optional<Hero> heroOptinal = Optional.of(buildHero());
		Hero hero = buildHero();
		
		when(heroRepository.findById(id)).thenReturn(heroOptinal);
		when(heroRepository.save(hero)).thenReturn(hero);

		Hero heroResponse = heroService.update(id, updateHeroDTO);
		Assertions.assertNotNull(heroResponse);
		
	}	
	
	@Test
	public void mustUpdateReturnExceptionNotFound() {
		
		String id = "id";
		UpdateHeroDTO updateHeroDTO = buildUpdateHeroDTO();
		
		Optional<Hero> heroOptinal = Optional.empty();
		
		when(heroRepository.findById(id)).thenReturn(heroOptinal);

		NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> heroService.update(id, updateHeroDTO));
		Assertions.assertNotNull(exception);
		
	}		
		
	@Test
	public void mustDeleteHeroSuccess() {
		
		String id = "id";		
		Optional<Hero> heroOptinal = Optional.of(buildHero());
	
		when(heroRepository.findById(id)).thenReturn(heroOptinal);

		boolean response = heroService.delete(id);
		Assertions.assertTrue(response);
		
	}		
	
	@Test
	public void mustDeleteReturnExceptionNotFound() {
		
		String id = "id";
		
		Optional<Hero> heroOptinal = Optional.empty();
		
		when(heroRepository.findById(id)).thenReturn(heroOptinal);

		NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> heroService.delete(id));
		Assertions.assertNotNull(exception);
		
	}		
	
	@Test
	public void mustFindHeroByNameSuccess() {
		
		String name = "name";		
		Optional<Hero> heroOptinal = Optional.of(buildHero());
	
		when(heroRepository.findByName(name)).thenReturn(heroOptinal);

		Hero heroResponse = heroService.findHeroByName(name);
		Assertions.assertNotNull(heroResponse);
		
	}		
	
	@Test
	public void mustReturnExceptionNotFoundName() {
		
		String name = "name";		
		Optional<Hero> heroOptinal = Optional.empty();
	
		when(heroRepository.findByName(name)).thenReturn(heroOptinal);

		NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> heroService.findHeroByName(name));
		Assertions.assertNotNull(exception);
				
	}
	
}
