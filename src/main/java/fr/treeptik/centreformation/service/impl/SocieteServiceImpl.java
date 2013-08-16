package fr.treeptik.centreformation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.centreformation.dao.SocieteDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.exception.ServiceException;
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

	@Override
	public List<Societe> findAllWithCommande() throws ServiceException {
		List<Societe> list;
		try {
			list = societeDAO.findAllWithCommande();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

		return list;
	}

	@Override
	public List<Societe> findByCodeSeminaire(Integer codeSeminaire) throws ServiceException {
		List<Societe> list;
		try {
			list = societeDAO.findByCodeSeminaire(codeSeminaire);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

		return list;
	}

}
