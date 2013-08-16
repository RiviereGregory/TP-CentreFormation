package fr.treeptik.centreformation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.FactureDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.exception.ServiceException;
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

	@Override
	public List<Facture> findByDateSession(Date date) throws ServiceException {
		List<Facture> list;
		try {
			list = factureDAO.findByDateSession(date);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

		return list;
	}

}
