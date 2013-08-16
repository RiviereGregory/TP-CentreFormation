package fr.treeptik.centreformation.service;

import java.util.Date;
import java.util.List;

import fr.treeptik.centreformation.dao.FactureDAO;
import fr.treeptik.centreformation.exception.ServiceException;
import fr.treeptik.centreformation.model.Facture;

public interface FactureService extends GenericService<Facture, Integer, FactureDAO> {

	List<Facture> findByDateSession(Date date) throws ServiceException;

}
