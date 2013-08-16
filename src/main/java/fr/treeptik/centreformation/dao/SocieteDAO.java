package fr.treeptik.centreformation.dao;

import java.util.List;

import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Societe;

public interface SocieteDAO extends GenericDAO<Societe, Integer> {

	List<Societe> findAllWithCommande() throws DAOException;

}
