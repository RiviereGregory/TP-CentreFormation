package fr.treeptit.centreformation.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.centreformation.exception.ServiceException;
import fr.treeptik.centreformation.model.Societe;
import fr.treeptik.centreformation.service.SocieteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class SocieteServiceTest {

	@Autowired
	private SocieteService service;

	@Test
	public void testFindAll() {
		try {
			List<Societe> list = service.findAll();
			System.out.println("********** Test SocieteService ********");
			for (Societe societe : list) {
				System.out.println("Numero :" + societe.getCode());
				System.out.println("Nom:" + societe.getNom());

				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@Transactional
	public void testSave() {
		try {
			System.out.println("******* test save ********");
			Societe societe = new Societe(null, "TestSociete", null);

			societe = service.save(societe);
			System.out.println("Numero :" + societe.getCode());
			System.out.println("Nom:" + societe.getNom());

			System.out.println("");

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

}
