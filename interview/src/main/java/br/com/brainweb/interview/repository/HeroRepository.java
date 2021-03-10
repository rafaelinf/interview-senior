package br.com.brainweb.interview.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.brainweb.interview.model.Hero;

public interface HeroRepository extends CrudRepository<Hero, String> {

	boolean existsHeroByName(String name);

	Long countByName(String name);
	
	Optional<Hero> findById(String id);
	
	Optional<Hero> findByName(String name);

}
