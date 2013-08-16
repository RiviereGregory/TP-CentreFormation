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
import fr.treeptik.centreformation.model.Session;
import fr.treeptik.centreformation.service.SessionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class SessionServiceTest {

	@Autowired
	private SessionService service;

	@Test
	public void testFindAll() {
		try {
			List<Session> list = service.findAll();
			System.out.println("********** Test SessionService ********");
			for (Session session : list) {
				System.out.println("Numero :" + session.getNumero());
				System.out.println("Date:" + session.getDate());
				System.out.println("Heure debut :" + session.getHeureDebut());
				System.out.println("Heure fin :" + session.getHeureFin());

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
			System.out.println("******* test session save ********");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			Session session = new Session(null, dateFormat.parse("15/08/2013"), "08:00:00",
					"17:30:00", null, null);

			session = service.save(session);

			System.out.println("Numero :" + session.getNumero());
			System.out.println("Date:" + session.getDate());
			System.out.println("Heure debut :" + session.getHeureDebut());
			System.out.println("Heure fin :" + session.getHeureFin());

			System.out.println("");

		} catch (ServiceException | ParseException e) {
			Assert.fail(e.getMessage());
		}
	}

}
