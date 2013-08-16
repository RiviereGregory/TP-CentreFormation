package fr.treeptik.centreformation.dao;

import java.util.List;

import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Session;

public interface SessionDAO extends GenericDAO<Session, Integer> {

	List<Session> findAllWithCommande() throws DAOException;

}
