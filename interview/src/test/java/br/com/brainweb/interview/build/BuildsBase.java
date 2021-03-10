package br.com.brainweb.interview.build;

import br.com.brainweb.interview.dto.CreateHeroDTO;
import br.com.brainweb.interview.dto.CreatePowerStatsDTO;
import br.com.brainweb.interview.dto.HeroDTO;
import br.com.brainweb.interview.dto.PowerStatsDTO;
import br.com.brainweb.interview.dto.UpdateHeroDTO;
import br.com.brainweb.interview.dto.UpdatePowerStatsDTO;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;

public class BuildsBase {

	public PowerStats buildPowerStats() {
		return PowerStats.builder().agility(10).dexterity(20).intelligence(30).strength(40).build();
	}
	
	public Hero buildHero() {
		
		return Hero.builder()
				.name("Name")
				.race("Race")
				.enabled(true)
				.powerStats(buildPowerStats())
				.build();

	}		
	
	public CreatePowerStatsDTO buildCreatePowerStatsDTO() {
		return CreatePowerStatsDTO.builder().agility(10).dexterity(20).intelligence(30).strength(40).build();
	}
	
	public CreateHeroDTO buildCreateHeroDTO() {
		
		return CreateHeroDTO.builder()
				.name("Name")
				.race("Race")
				.enabled(true)
				.powerStats(buildCreatePowerStatsDTO())
				.build();

	}	
	
	public UpdatePowerStatsDTO buildUpdatePowerStatsDTO() {
		return UpdatePowerStatsDTO.builder().agility(10).dexterity(20).intelligence(30).strength(40).build();
	}
	
	public UpdateHeroDTO buildUpdateHeroDTO() {
		
		return UpdateHeroDTO.builder()
				.name("Name")
				.race("Race")
				.enabled(true)
				.powerStats(buildUpdatePowerStatsDTO())
				.build();

	}	
		
	public PowerStatsDTO buildPowerStatsDTO() {
		return PowerStatsDTO.builder().agility(10).dexterity(20).intelligence(30).strength(40).build();
	}
	
	public HeroDTO buildHeroDTO() {
		
		return HeroDTO.builder()
				.name("Name")
				.race("Race")
				.enabled(true)
				.powerStats(buildPowerStatsDTO())
				.build();

	}	
	
}
