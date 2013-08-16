package fr.treeptik.centreformation.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.SessionDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Session;

@Repository
public class SessionDAOJPA extends GenericDAOJPA<Session, Integer> implements SessionDAO {

	public SessionDAOJPA() {
		super(Session.class);
	}

	@Override
	public List<Session> findAllWithCommande() throws DAOException {
		try {
			return entityManager.createQuery(
					"SELECT DISTINCT ses FROM Session ses LEFT JOIN FETCH ses.commandes",
					Session.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

}
