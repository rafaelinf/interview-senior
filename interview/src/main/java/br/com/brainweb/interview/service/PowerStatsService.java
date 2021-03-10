package br.com.brainweb.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brainweb.interview.dto.CreatePowerStatsDTO;
import br.com.brainweb.interview.dto.UpdatePowerStatsDTO;
import br.com.brainweb.interview.model.PowerStats;
import br.com.brainweb.interview.repository.PowerStatsRepository;

@Service
public class PowerStatsService {

	@Autowired
	private PowerStatsRepository powerStatsRepository;
	
	public PowerStats save(CreatePowerStatsDTO createPowerStatsDTO) {
		PowerStats powerStats = new PowerStats();
		powerStats.setAgility(createPowerStatsDTO.getAgility());
		powerStats.setDexterity(createPowerStatsDTO.getDexterity());
		powerStats.setIntelligence(createPowerStatsDTO.getIntelligence());
		powerStats.setStrength(createPowerStatsDTO.getStrength());
		return powerStatsRepository.save(powerStats);	
	}
	
	public PowerStats update(PowerStats powerStats, UpdatePowerStatsDTO updatePowerStatsDTO) {
		powerStats.setAgility(updatePowerStatsDTO.getAgility());
		powerStats.setDexterity(updatePowerStatsDTO.getDexterity());
		powerStats.setIntelligence(updatePowerStatsDTO.getIntelligence());
		powerStats.setStrength(updatePowerStatsDTO.getStrength());
		return powerStatsRepository.save(powerStats);	
	}	
		
}
