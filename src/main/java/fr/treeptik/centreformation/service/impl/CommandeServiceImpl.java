package fr.treeptik.centreformation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.CommandeDAO;
import fr.treeptik.centreformation.model.Commande;
import fr.treeptik.centreformation.service.CommandeService;

@Service
public class CommandeServiceImpl extends GenericServiceImpl<Commande, Integer, CommandeDAO>
		implements CommandeService {

	@Autowired
	private CommandeDAO commandeDAO;

	@Override
	protected CommandeDAO getDao() {
		return commandeDAO;
	}

}
