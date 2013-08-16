package fr.treeptik.centreformation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.SessionDAO;
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

}
