package br.com.brainweb.interview.dto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Valid
public class CreatePowerStatsDTO {

	@NotNull(message = "Strength is mandatory")
	@Min(value = 0, message = "Strength must contain at least 0.")
	private Integer strength;
	
	@NotNull(message = "Agility is mandatory")
	@Min(value = 0, message = "Agility must contain at least 0.")
	private Integer agility;
	
	@NotNull(message = "Dexterity is mandatory")
	@Min(value = 0, message = "Dexterity must contain at least 0.")
	private Integer dexterity;
	
	@NotNull(message = "Intelligence is mandatory")
	@Min(value = 0, message = "Intelligence must contain at least 0.")
	private Integer intelligence;
	
}
