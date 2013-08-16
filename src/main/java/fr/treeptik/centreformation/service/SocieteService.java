package fr.treeptik.centreformation.service;

import java.util.List;

import fr.treeptik.centreformation.dao.SocieteDAO;
import fr.treeptik.centreformation.exception.ServiceException;
import fr.treeptik.centreformation.model.Societe;

public interface SocieteService extends GenericService<Societe, Integer, SocieteDAO> {

	List<Societe> findAllWithCommande() throws ServiceException;

	List<Societe> findByCodeSeminaire(Integer codeSeminaire) throws ServiceException;

}
