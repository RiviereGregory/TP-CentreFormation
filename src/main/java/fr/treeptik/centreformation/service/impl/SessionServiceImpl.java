package fr.treeptik.centreformation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.SessionDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.exception.ServiceException;
import fr.treeptik.centreformation.model.Session;
import fr.treeptik.centreformation.service.SessionService;

@Service
public class SessionServiceImpl extends GenericServiceImpl<Session, Integer, SessionDAO> implements
		SessionService {

	@Autowired
	private SessionDAO sessionDAO;

	@Override
	protected SessionDAO getDao() {
		return sessionDAO;
	}

	@Override
	public List<Session> findAllWithCommande() throws ServiceException {
		List<Session> list;
		try {
			list = sessionDAO.findAllWithCommande();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

}
