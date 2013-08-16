package fr.treeptik.centreformation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.SocieteDAO;
import fr.treeptik.centreformation.model.Societe;
import fr.treeptik.centreformation.service.SocieteService;

@Service
public class SocieteServiceImpl extends GenericServiceImpl<Societe, Integer, SocieteDAO> implements
		SocieteService {

	@Autowired
	private SocieteDAO societeDAO;

	@Override
	protected SocieteDAO getDao() {
		return societeDAO;
	}

}
