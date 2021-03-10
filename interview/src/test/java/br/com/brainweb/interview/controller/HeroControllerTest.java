package br.com.brainweb.interview.controller;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brainweb.interview.build.BuildsBase;
import br.com.brainweb.interview.dto.CreateHeroDTO;
import br.com.brainweb.interview.dto.HeroDTO;
import br.com.brainweb.interview.dto.UpdateHeroDTO;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.model.PowerStats;
import br.com.brainweb.interview.repository.HeroRepository;
import br.com.brainweb.interview.service.HeroService;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HeroControllerTest extends BuildsBase {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@InjectMocks
	private HeroService heroService;
	
	@Mock
	private HeroRepository heroRepository;
	
	
	@Test
    public void mustSaveHeroReturnStatusCreated() throws JsonProcessingException, Exception{
    	
    	CreateHeroDTO createHeroDTO = buildCreateHeroDTO();

    	mockMvc.perform(post("/hero")
    		    .contentType("application/json")
    		    .content(objectMapper.writeValueAsString(createHeroDTO)))
    	.andExpect(status().isCreated());

    }
	
}
