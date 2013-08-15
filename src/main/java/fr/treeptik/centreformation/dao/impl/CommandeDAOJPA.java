package fr.treeptik.centreformation.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.CommandeDAO;
import fr.treeptik.centreformation.model.Commande;

@Repository
public class CommandeDAOJPA extends GenericDAOJPA<Commande, Integer> implements CommandeDAO {

	public CommandeDAOJPA() {
		super(Commande.class);
	}

}
