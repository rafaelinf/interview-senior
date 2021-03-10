package br.com.brainweb.interview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "hero")
public class Hero {
	
	@Id 
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")	
	@Column(name = "id", nullable = false)
	private String id;
	
	@Column(name = "name", nullable = false, length = 255, unique = true)
    private String name;
    
	@Column(name = "race", nullable = false, length = 255)
	private String race;
    
	@Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private Boolean enabled;
    
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private Date updatedAt;    
    
	@ManyToOne
	@JoinColumn(name = "power_stats_id", nullable = false)
	private PowerStats powerStats;
		
}
