package fr.treeptik.centreformation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.FactureDAO;
import fr.treeptik.centreformation.model.Facture;
import fr.treeptik.centreformation.service.FactureService;

@Service
public class FactureServiceImpl extends GenericServiceImpl<Facture, Integer, FactureDAO> implements
		FactureService {

	@Autowired
	private FactureDAO factureDAO;

	@Override
	protected FactureDAO getDao() {
		return factureDAO;
	}

}
