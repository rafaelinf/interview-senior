package br.com.brainweb.interview.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brainweb.interview.converter.Converter;
import br.com.brainweb.interview.dto.CreateHeroDTO;
import br.com.brainweb.interview.dto.HeroDTO;
import br.com.brainweb.interview.dto.UpdateHeroDTO;
import br.com.brainweb.interview.model.Hero;
import br.com.brainweb.interview.service.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "API Hero")
@Slf4j
@RestController
@RequestMapping("hero")
@Validated
public class HeroController {

	@Autowired
	private HeroService heroService; 
	
	@Operation(summary = "Create Hero.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully created.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CreateHeroDTO.class)) }),
			@ApiResponse(responseCode = "403", description = "Invalid data.", content = @Content)})
	@PostMapping
	public ResponseEntity<HeroDTO> save(@Valid @RequestBody CreateHeroDTO createHeroDTO) {

		log.info("Calling the service to register hero.");
		
		Hero hero = heroService.save(createHeroDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(Converter.conveterToDTO(hero));
	}	
	
	@Operation(summary = "Update Hero.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully update.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UpdateHeroDTO.class)) }),
			@ApiResponse(responseCode = "404", description = "Not Found.", content = @Content)})
	@PutMapping("/{id}")
	public ResponseEntity<HeroDTO> update(
			@PathVariable("id") String id,
			@Valid @RequestBody UpdateHeroDTO updateHeroDTO) {

		log.info("Calling the service to update hero.");
		
		Hero hero = heroService.update(id, updateHeroDTO);
		return ResponseEntity.status(HttpStatus.OK).body(Converter.conveterToDTO(hero));
	}	
	
	@Operation(summary = "Delete Hero.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully delete.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UpdateHeroDTO.class)) }),
			@ApiResponse(responseCode = "404", description = "Not Found.", content = @Content)})
	@DeleteMapping("/{id}")
	public ResponseEntity<HeroDTO> save(@PathVariable("id") String id) {

		log.info("Calling the service to delete hero.");
		
		heroService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}			
	
	@Operation(summary = "Find Hero By ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = HeroDTO.class)) })})	
	@GetMapping("/{id}")
	public ResponseEntity<HeroDTO> findHeroById(@PathVariable("id") String id) {

		log.info("Calling the service to fetch hero by ID.");

		Hero hero = heroService.findHeroById(id);
		return ResponseEntity.status(HttpStatus.OK).body(Converter.conveterToDTO(hero));
	}	
	
	@Operation(summary = "Find Hero By Name.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = HeroDTO.class)) })})	
	@GetMapping
	public ResponseEntity<HeroDTO> findHeroByName(@PathParam("name") String name) {

		log.info("Calling the service to fetch hero by Name.");

		Hero hero = heroService.findHeroByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(Converter.conveterToDTO(hero));
	}		

}
