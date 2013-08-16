package fr.treeptik.centreformation.service;

import java.util.List;

import fr.treeptik.centreformation.dao.SessionDAO;
import fr.treeptik.centreformation.exception.ServiceException;
import fr.treeptik.centreformation.model.Session;

public interface SessionService extends GenericService<Session, Integer, SessionDAO> {

	List<Session> findAllWithCommande() throws ServiceException;

}
