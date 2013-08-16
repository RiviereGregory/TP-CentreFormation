package fr.treeptik.centreformation.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.SeminaireDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Seminaire;

@Repository
public class SeminaireDAOJPA extends GenericDAOJPA<Seminaire, Integer> implements SeminaireDAO {

	public SeminaireDAOJPA() {
		super(Seminaire.class);
	}

	@Override
	public List<Seminaire> findAllWithSession() throws DAOException {
		try {
			return entityManager.createQuery(
					"SELECT DISTINCT sem FROM Seminaire sem LEFT JOIN FETCH sem.sessions",
					Seminaire.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

}
