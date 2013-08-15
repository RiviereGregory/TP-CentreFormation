package fr.treeptik.centreformation.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.SocieteDAO;
import fr.treeptik.centreformation.model.Societe;

@Repository
public class SocieteDAOJPA extends GenericDAOJPA<Societe, Integer> implements SocieteDAO {

	public SocieteDAOJPA() {
		super(Societe.class);
	}

}
