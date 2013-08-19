package fr.treeptit.centreformation.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.centreformation.dao.FactureDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Facture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
public class FactureTest {

	@Autowired
	private FactureDAO factureDAO;

	@Test
	public void testFindAll() {
		try {
			List<Facture> list = factureDAO.findAll();
			System.out.println("********** Test FactureDAO ********");
			for (Facture facture : list) {
				System.out.println("numero :" + facture.getNumero());
				System.out.println("Date:" + facture.getDate());
				System.out.println("Montant:" + facture.getMontant());
				System.out.println("nombres places:" + facture.getNombresPlaces());

				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

}
