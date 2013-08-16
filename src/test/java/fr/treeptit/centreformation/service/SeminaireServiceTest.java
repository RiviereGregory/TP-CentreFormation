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
import fr.treeptik.centreformation.model.Seminaire;
import fr.treeptik.centreformation.model.Session;
import fr.treeptik.centreformation.service.SeminaireService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class SeminaireServiceTest {

	@Autowired
	private SeminaireService service;

	@Test
	public void testFindAllWithSession() {
		try {
			List<Seminaire> list = service.findAllWithSession();
			System.out.println("********** Test SeminaireService With Session********");
			for (Seminaire seminaire : list) {
				System.out.println("Numero :" + seminaire.getCode());
				System.out.println("Duree:" + seminaire.getDuree());
				System.out.println("Niveau :" + seminaire.getNiveau());
				System.out.println("Nombres de places :" + seminaire.getNombresPlaces());
				System.out.println("Prix :" + seminaire.getPrix());
				System.out.println("Session :");
				for (Session session : seminaire.getSessions()) {
					System.out.println("Numero :" + session.getNumero());
					System.out.println("Date:" + session.getDate());
					System.out.println("Heure debut :" + session.getHeureDebut());
					System.out.println("Heure fin :" + session.getHeureFin());

					System.out.println("");
				}

				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindAll() {
		try {
			List<Seminaire> list = service.findAll();
			System.out.println("********** Test SeminaireService ********");
			for (Seminaire seminaire : list) {
				System.out.println("Numero :" + seminaire.getCode());
				System.out.println("Duree:" + seminaire.getDuree());
				System.out.println("Niveau :" + seminaire.getNiveau());
				System.out.println("Nombres de places :" + seminaire.getNombresPlaces());
				System.out.println("Prix :" + seminaire.getPrix());

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
			System.out.println("******* test seminaire save ********");

			Seminaire seminaire = new Seminaire(null, 500, 10, 4, 15, null);

			seminaire = service.save(seminaire);

			System.out.println("Numero :" + seminaire.getCode());
			System.out.println("Duree:" + seminaire.getDuree());
			System.out.println("Niveau :" + seminaire.getNiveau());
			System.out.println("Nombres de places :" + seminaire.getNombresPlaces());
			System.out.println("Prix :" + seminaire.getPrix());

			System.out.println("");

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

}
