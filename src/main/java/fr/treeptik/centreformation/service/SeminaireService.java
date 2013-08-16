package fr.treeptik.centreformation.service;

import java.util.List;

import fr.treeptik.centreformation.dao.SeminaireDAO;
import fr.treeptik.centreformation.exception.ServiceException;
import fr.treeptik.centreformation.model.Seminaire;

public interface SeminaireService extends GenericService<Seminaire, Integer, SeminaireDAO> {

	List<Seminaire> findAllWithSession() throws ServiceException;

}
