package br.com.brainweb.interview.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateHeroDTO {
	
	@Length(max = 255, message = "The maximum length is 255 characters.")
	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Length(max = 255, message = "The maximum length is 255 characters.")
	@NotNull(message = "Race is mandatory")
	@NotBlank(message = "Race is mandatory")
	private String race;
	
	@NotNull(message = "Enabled is mandatory")
    private Boolean enabled;
	
	@Valid
	@NotNull(message = "Power Stats is mandatory")
	private CreatePowerStatsDTO powerStats;
		
}
