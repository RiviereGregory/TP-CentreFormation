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
import fr.treeptik.centreformation.model.Commande;
import fr.treeptik.centreformation.model.Societe;
import fr.treeptik.centreformation.service.SocieteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class SocieteServiceTest {

	@Autowired
	private SocieteService service;

	@Test
	public void testFindByCodeSeminaire() {
		try {
			List<Societe> list = service.findByCodeSeminaire(1);
			System.out.println("********** Test SocieteService CodeSeminaire ********");
			for (Societe societe : list) {
				System.out.println("Numero :" + societe.getCode());
				System.out.println("Nom:" + societe.getNom());

				System.out.println("Commandes :");
				for (Commande commande : societe.getCommandes()) {
					System.out.println("numero commande:" + commande.getNumero());
					System.out.println("date:" + commande.getDate());
					System.out.println("nombres places:" + commande.getNombresPlaces());
					System.out.println("generer:" + commande.getGenerer());

					System.out.println("Numero session : "
							+ commande.getDemandeSatifaite().getNumero());
					System.out
							.println("Date session : " + commande.getDemandeSatifaite().getDate());

					System.out.println("");
				}

				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testFindAllWithCommande() {
		try {
			List<Societe> list = service.findAllWithCommande();
			System.out.println("********** Test SocieteService With Commande ********");
			for (Societe societe : list) {
				System.out.println("Numero :" + societe.getCode());
				System.out.println("Nom:" + societe.getNom());

				System.out.println("Commandes :");
				for (Commande commande : societe.getCommandes()) {
					System.out.println("numero commande:" + commande.getNumero());
					System.out.println("date:" + commande.getDate());
					System.out.println("nombres places:" + commande.getNombresPlaces());
					System.out.println("generer:" + commande.getGenerer());

					System.out.println("Numero session : "
							+ commande.getDemandeSatifaite().getNumero());
					System.out
							.println("Date session : " + commande.getDemandeSatifaite().getDate());

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
