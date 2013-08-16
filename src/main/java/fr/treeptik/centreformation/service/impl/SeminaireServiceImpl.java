package fr.treeptik.centreformation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.SeminaireDAO;
import fr.treeptik.centreformation.model.Seminaire;
import fr.treeptik.centreformation.service.SeminaireService;

@Service
public class SeminaireServiceImpl extends GenericServiceImpl<Seminaire, Integer, SeminaireDAO>
		implements SeminaireService {

	@Autowired
	private SeminaireDAO seminaireDAO;

	@Override
	protected SeminaireDAO getDao() {
		return seminaireDAO;
	}

}
