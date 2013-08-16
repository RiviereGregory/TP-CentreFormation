package fr.treeptik.centreformation.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.dao.SocieteDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Societe;

@Repository
public class SocieteDAOJPA extends GenericDAOJPA<Societe, Integer> implements SocieteDAO {

	public SocieteDAOJPA() {
		super(Societe.class);
	}

	@Override
	public List<Societe> findAllWithCommande() throws DAOException {
		try {
			return entityManager.createQuery(
					"SELECT DISTINCT soc FROM Societe soc LEFT JOIN FETCH soc.commandes",
					Societe.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Societe> findByCodeSeminaire(Integer codeSeminaire) throws DAOException {
		List<Societe> list;
		try {
			TypedQuery<Societe> query = entityManager.createQuery(
					"SELECT soc FROM Societe soc LEFT JOIN FETCH soc.commandes com JOIN "
							+ " com.demandeSatifaite JOIN com.demandeSatifaite.concerner WHERE "
							+ " com.demandeSatifaite.concerner.code= :code", Societe.class);
			query.setParameter("code", codeSeminaire);

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

}
