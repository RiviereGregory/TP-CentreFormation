package fr.treeptik.centreformation.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.FactureDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Facture;

@Repository
public class FactureDAOJPA extends GenericDAOJPA<Facture, Integer> implements FactureDAO {

	public FactureDAOJPA() {
		super(Facture.class);
	}

	@Override
	public List<Facture> findByDateSession(Date date) throws DAOException {
		List<Facture> list;
		try {
			TypedQuery<Facture> query = entityManager.createQuery(
					"SELECT fac FROM Facture fac JOIN fac.commande com JOIN "
							+ " com.demandeSatifaite WHERE com.demandeSatifaite.date = :date",
					Facture.class);
			query.setParameter("date", date);

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

}
