package br.com.brainweb.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brainweb.interview.model.PowerStats;

public interface PowerStatsRepository extends JpaRepository<PowerStats, String>{

}
