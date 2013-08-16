package fr.treeptik.centreformation.dao;

import java.util.Date;
import java.util.List;

import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Facture;

public interface FactureDAO extends GenericDAO<Facture, Integer> {

	List<Facture> findByDateSession(Date date) throws DAOException;

}
