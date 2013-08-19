package fr.treeptit.centreformation.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.centreformation.dao.SeminaireDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Seminaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
public class SeminaireTest {

	@Autowired
	private SeminaireDAO seminaireDAO;

	@Test
	public void testFindAll() {
		try {
			List<Seminaire> list = seminaireDAO.findAll();
			System.out.println("********** Test SeminaireDAO ********");
			for (Seminaire seminaire : list) {
				System.out.println("Numero :" + seminaire.getCode());
				System.out.println("Duree:" + seminaire.getDuree());
				System.out.println("Niveau :" + seminaire.getNiveau());
				System.out.println("Nombres de places :" + seminaire.getNombresPlaces());
				System.out.println("Prix :" + seminaire.getPrix());

				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

}
