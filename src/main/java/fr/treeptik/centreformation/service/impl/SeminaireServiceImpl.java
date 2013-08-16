package fr.treeptik.centreformation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.SeminaireDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.exception.ServiceException;
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

	@Override
	public List<Seminaire> findAllWithSession() throws ServiceException {
		List<Seminaire> list;
		try {
			list = seminaireDAO.findAllWithSession();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

}
