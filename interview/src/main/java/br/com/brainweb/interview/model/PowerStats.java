package br.com.brainweb.interview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "power_stats")
public class PowerStats {
	
	@Id 
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")	
	@Column(name = "id", nullable = false)
	private String id;
	
	@Column(name = "strength", nullable = false)
	private Integer strength;
	
	@Column(name = "agility", nullable = false)
	private Integer agility;
	
	@Column(name = "dexterity", nullable = false)
	private Integer dexterity;
	
	@Column(name = "intelligence", nullable = false)
	private Integer intelligence;
	
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private Date updatedAt;

}
