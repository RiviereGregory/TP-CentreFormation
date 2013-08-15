package fr.treeptik.centreformation.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.FactureDAO;
import fr.treeptik.centreformation.model.Facture;

@Repository
public class FactureDAOJPA extends GenericDAOJPA<Facture, Integer> implements FactureDAO {

	public FactureDAOJPA() {
		super(Facture.class);
	}

}
