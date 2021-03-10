package br.com.brainweb.interview.converter;

import br.com.brainweb.interview.dto.HeroDTO;
import br.com.brainweb.interview.dto.PowerStatsDTO;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;

public class Converter {

	public static HeroDTO conveterToDTO(Hero hero) {
		
		return HeroDTO.builder()
				.id(hero.getId().toString())
				.name(hero.getName())
				.race(hero.getRace())
				.enabled(hero.getEnabled())
				.createdAt(hero.getCreatedAt())
				.updatedAt(hero.getUpdatedAt())
				.powerStats(conveterToDTO(hero.getPowerStats()))
				.build();
		
	}
	
	public static PowerStatsDTO conveterToDTO(PowerStats powerStats) {

		return PowerStatsDTO.builder()
				.id(powerStats.getId().toString())
				.strength(powerStats.getStrength())
				.agility(powerStats.getAgility())
				.dexterity(powerStats.getDexterity())
				.intelligence(powerStats.getIntelligence())
				.createdAt(powerStats.getCreatedAt())
				.updatedAt(powerStats.getUpdatedAt())				
				.build();
		
	}
}
