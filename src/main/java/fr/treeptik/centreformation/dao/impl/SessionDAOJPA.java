package fr.treeptik.centreformation.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.SessionDAO;
import fr.treeptik.centreformation.model.Session;

@Repository
public class SessionDAOJPA extends GenericDAOJPA<Session, Integer> implements SessionDAO {

	public SessionDAOJPA() {
		super(Session.class);
	}

}
