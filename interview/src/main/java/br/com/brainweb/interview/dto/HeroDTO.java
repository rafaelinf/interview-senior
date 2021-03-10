package br.com.brainweb.interview.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HeroDTO {

	private String id;
	
    private String name;
    
	private String race;
    
    private Boolean enabled;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")    
	private Date updatedAt;    
    
	private PowerStatsDTO powerStats;	
}
