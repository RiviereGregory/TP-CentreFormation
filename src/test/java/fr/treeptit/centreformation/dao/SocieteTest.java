package fr.treeptit.centreformation.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.centreformation.dao.SocieteDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Societe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class SocieteTest {
	@Autowired
	private SocieteDAO societeDAO;

	@Test
	public void testFindAll() {
		try {
			List<Societe> list = societeDAO.findAll();
			System.out.println("********** Test SocieteDAO ********");
			for (Societe societe : list) {
				System.out.println("Numero :" + societe.getCode());
				System.out.println("Nom:" + societe.getNom());

				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

}
