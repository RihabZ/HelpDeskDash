package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rihab.interventions.entities.Demandeur;



public interface DemandeurRepository  extends JpaRepository<Demandeur, Long> {
	

	 
	 List<Demandeur> findByClientCodeClient(long codeClient);

	Demandeur findByUserUsername(String username);
	Demandeur findByCodeDemandeur(Long codeDemandeur);
	
	@Query("SELECT d.client.nomSociete, COUNT(d) FROM Demandeur d GROUP BY d.client")
    List<Object[]> countByClient();

}
