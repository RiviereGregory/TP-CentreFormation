package fr.treeptit.centreformation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import fr.treeptik.centreformation.service.CommandeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class CommandeServiceTest {

	@Autowired
	private CommandeService service;

	@Test
	public void testFindAll() {
		try {
			List<Commande> list = service.findAll();
			System.out.println("********** Test Commandeservice ********");
			for (Commande commande : list) {
				System.out.println("numero commande:" + commande.getNumero());
				System.out.println("date:" + commande.getDate());
				System.out.println("nombres places:" + commande.getNombresPlaces());
				System.out.println("facture:" + commande.getFacture());

				System.out.println("Code societe : " + commande.getSociete().getCode());
				System.out.println("Nom Societe : " + commande.getSociete().getNom());

				System.out.println("Numero session : " + commande.getSession().getNumero());
				System.out.println("Date session : " + commande.getSession().getDate());

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
			System.out.println("******* test commande save ********");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			Commande commande = new Commande(null, dateFormat.parse("21/05/2013"), 3, null, null,
					null);

			commande = service.save(commande);

			System.out.println("numero commande:" + commande.getNumero());
			System.out.println("date:" + commande.getDate());
			System.out.println("nombres places:" + commande.getNombresPlaces());

			System.out.println("");

		} catch (ServiceException | ParseException e) {
			Assert.fail(e.getMessage());
		}

	}
}
