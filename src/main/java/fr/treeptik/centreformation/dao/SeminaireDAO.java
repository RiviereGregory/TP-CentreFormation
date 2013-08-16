package fr.treeptik.centreformation.dao;

import java.util.List;

import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Seminaire;

public interface SeminaireDAO extends GenericDAO<Seminaire, Integer> {

	List<Seminaire> findAllWithSession() throws DAOException;

}
