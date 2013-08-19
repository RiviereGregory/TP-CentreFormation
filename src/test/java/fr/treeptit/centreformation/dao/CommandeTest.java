package fr.treeptit.centreformation.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.centreformation.dao.CommandeDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Commande;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
public class CommandeTest {

	@Autowired
	private CommandeDAO commandeDAO;

	@Test
	public void testFindAll() {
		try {
			List<Commande> list = commandeDAO.findAll();
			System.out.println("********** Test CommandeDAO ********");
			for (Commande commande : list) {
				System.out.println("numero commande:" + commande.getNumero());
				System.out.println("date:" + commande.getDate());
				System.out.println("nombres places:" + commande.getNombresPlaces());
				System.out.println("facture:" + commande.getFacture());

				// Attention au variable détaché (LAZY true)
				// System.out.println(commande.getPasserCommande());
				// System.out.println(commande.getDemandeSatifaite());
				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}
}
