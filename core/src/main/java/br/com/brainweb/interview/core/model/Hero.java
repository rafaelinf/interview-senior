package br.com.brainweb.interview.core.model;

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
import org.hibernate.annotations.Type;
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
	@GenericGenerator(name = "UUID", strategy = "uuid2")
	@GeneratedValue(generator = "UUID")
	@Column(name = "id", nullable = false)
	@Type(type="pg-uuid")	
	private String id;
	
	@Column(name = "name", nullable = false)
    private String name;
    
	@Column(name = "race", nullable = false)
	private String race;
    
	@Column(name = "created_at", nullable = false, columnDefinition = "boolean default true")
    private Boolean enabled;
    
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Date created_at;
	
	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private Date updated_at;    
    
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private PowerStats powerStats;
		
}
