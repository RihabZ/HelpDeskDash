package com.rihab.interventions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Demandeur;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Ticket;
import com.rihab.interventions.repos.DemandeurRepository;
import com.rihab.interventions.repos.TicketRepository;


@Service
public class DemandeurServiceImpl implements DemandeurService {
	
	@Autowired
	DemandeurRepository demandeurRepository;
	@Autowired
	TicketRepository ticketRepository;

@Override
public Demandeur saveDemandeur(Demandeur demandeur)
{
return demandeurRepository.save(demandeur);

}

@Override
public Demandeur updateDemandeur(Demandeur demandeur) {
return demandeurRepository.save(demandeur);
}


@Override
public void deleteDemandeur(Demandeur demandeur) {
	demandeurRepository.delete(demandeur);
}


@Override
public void deleteDemandeurByCode(long code) {
	Optional<Demandeur> optionalDemandeur = Optional.of(demandeurRepository.findByCodeDemandeur(code));
    if (optionalDemandeur.isPresent()) {
        Demandeur demandeur = optionalDemandeur.get();
        
        // Détacher les tickets avant de supprimer le demandeur
        List<Ticket> tickets = demandeur.getTickets();
        for (Ticket ticket : tickets) {
            ticket.setDemandeur(null);
            ticketRepository.save(ticket);  // Sauvegarder les tickets détachés
        }
        
        demandeurRepository.delete(demandeur);
    }
}

@Override
public Demandeur getDemandeur(long code) {
return demandeurRepository.findById(code).get();
}


@Override
public List<Demandeur> getAllDemandeurs() {
return demandeurRepository.findAll();
}



@Override
public List<Demandeur> findByClientCodeClient(long codeClient)
{
	return demandeurRepository.findByClientCodeClient( codeClient);
			
}


@Override
public Demandeur getDemandeurByUsername(String username) {
    return demandeurRepository.findByUserUsername(username);
}

@Override
public List<Object[]> countDemandeursByClient() {
    return demandeurRepository.countByClient();
}


}
