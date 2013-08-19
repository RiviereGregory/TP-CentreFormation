package fr.treeptit.centreformation.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.centreformation.dao.SessionDAO;
import fr.treeptik.centreformation.exception.DAOException;
import fr.treeptik.centreformation.model.Session;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
public class SessionTest {
	@Autowired
	private SessionDAO sessionDAO;

	@Test
	public void testFindAll() {
		try {
			List<Session> list = sessionDAO.findAll();
			System.out.println("********** Test SessionDAO ********");
			for (Session session : list) {
				System.out.println("Numero :" + session.getNumero());
				System.out.println("Date:" + session.getDate());
				System.out.println("Heure debut :" + session.getHeureDebut());
				System.out.println("Heure fin :" + session.getHeureFin());

				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

}
