package br.com.brainweb.interview.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.brainweb.interview.build.BuildsBase;
import br.com.brainweb.interview.dto.CreatePowerStatsDTO;
import br.com.brainweb.interview.dto.UpdatePowerStatsDTO;
import br.com.brainweb.interview.model.PowerStats;
import br.com.brainweb.interview.repository.PowerStatsRepository;

@ExtendWith(SpringExtension.class)
public class PowerStatsServiceIT extends BuildsBase {
	
	@InjectMocks
	PowerStatsService powerStatsService;
	
	@Mock
	PowerStatsRepository powerStatsRepository;	
	
	@Test
	public void mustSavePowerStatsSuccess() {
		
		CreatePowerStatsDTO createPowerStatsDTO = buildCreatePowerStatsDTO();
		
		PowerStats powerStats = buildPowerStats();
		
		when(powerStatsRepository.save(powerStats)).thenReturn(powerStats);
		
		PowerStats powerStatsRespone = powerStatsService.save(createPowerStatsDTO);
		Assertions.assertNotNull(powerStatsRespone);
		
	}

	@Test
	public void mustUpdatePowerStatsSuccess() {
		
		UpdatePowerStatsDTO updatePowerStatsDTO = buildUpdatePowerStatsDTO();
		
		PowerStats powerStats = buildPowerStats();
		
		when(powerStatsRepository.save(powerStats)).thenReturn(powerStats);
		
		PowerStats powerStatsRespone = powerStatsService.update(powerStats, updatePowerStatsDTO);
		Assertions.assertNotNull(powerStatsRespone);
		
	}	
}
