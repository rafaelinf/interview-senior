package br.com.brainweb.interview.dto;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PowerStatsDTO {

	private String id;
	
	private Integer strength;
	
	private Integer agility;
	
	private Integer dexterity;
	
	private Integer intelligence;
	
	@Column(name = "created_at", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	
	@Column(name = "updated_at", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;
}
