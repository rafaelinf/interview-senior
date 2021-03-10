package br.com.brainweb.interview.core.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "power_stats")
public class PowerStats {
	
	@Id
	@GenericGenerator(name = "UUID", strategy = "uuid2")
	@GeneratedValue(generator = "UUID")
	@Column(name = "id", nullable = false)
	@Type(type="pg-uuid")
	private UUID id;
	
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
	private Date created_at;
	
	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private Date updated_at;

}
