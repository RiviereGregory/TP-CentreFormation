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
import fr.treeptik.centreformation.model.Facture;
import fr.treeptik.centreformation.service.FactureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
public class FactureServiceTest {

	@Autowired
	private FactureService service;

	@Test
	public void testFindBySessionDate() {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			List<Facture> list = service.findByDateSession(dateFormat.parse("31/07/2013"));
			System.out.println("********** Test FactureService by session date********");
			for (Facture facture : list) {
				System.out.println("numero :" + facture.getNumero());
				System.out.println("Date:" + facture.getDate());
				System.out.println("Montant:" + facture.getMontant());
				System.out.println("nombres places:" + facture.getNombresPlaces());

				System.out.println("");
			}

		} catch (ServiceException | ParseException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindAll() {
		try {
			List<Facture> list = service.findAll();
			System.out.println("********** Test FactureService ********");
			for (Facture facture : list) {
				System.out.println("numero :" + facture.getNumero());
				System.out.println("Date:" + facture.getDate());
				System.out.println("Montant:" + facture.getMontant());
				System.out.println("nombres places:" + facture.getNombresPlaces());

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
			System.out.println("******* test facture save ********");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			Facture facture = new Facture(null, dateFormat.parse("16/08/2013"), 600, 3);

			facture = service.save(facture);

			System.out.println("numero :" + facture.getNumero());
			System.out.println("Date:" + facture.getDate());
			System.out.println("Montant:" + facture.getMontant());
			System.out.println("nombres places:" + facture.getNombresPlaces());
			System.out.println("");

		} catch (ServiceException | ParseException e) {
			Assert.fail(e.getMessage());
		}

	}
}
