package fr.treeptik.centreformation.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.SeminaireDAO;
import fr.treeptik.centreformation.model.Seminaire;

@Repository
public class SeminaireDAOJPA extends GenericDAOJPA<Seminaire, Integer> implements SeminaireDAO {

	public SeminaireDAOJPA() {
		super(Seminaire.class);
	}

}
