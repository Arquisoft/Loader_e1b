package dbupdate;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Test;

import com.lowagie.text.DocumentException;

import executer.ActionSingleton;
import model.Agent;
import persistence.UserFinder;
import persistence.util.Jpa;

public class DbTest {

	@Test
	public void usuarioYaExistenteDni() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		Agent user1 = new Agent("Paco Francisco", "C\\Uría", "87654321P","francisco@gmail.com", 1);
		Agent user2 = new Agent("Paco Francisco",  "C\\Uría", "87654321P", "franci@gmail.com",  1);

		aS.getAF().saveData(user1);
		aS.getAF().saveData(user2);

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<Agent> test = UserFinder.findByID("87654321P");
		assertEquals(test.get(0).getEmail(), "francisco@gmail.com");

		trx.commit();
		mapper.close();
	}

	@Test
	public void usuarioYaExistenteEmail() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		Agent user1 = new Agent("Paco Francisco", "C\\Uría", "87654321P","francisco@gmail.com",  1);
		Agent user3 = new Agent("Paco Francisco", "C\\Uría", "87654321P", "francisco@gmail.com", 1);

		aS.getAF().saveData(user1);
		aS.getAF().saveData(user3);

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<Agent> test = UserFinder.findByEmail("francisco@gmail.com");
		assertEquals(test.get(0).getIdAgent(), "87654321P");

		trx.commit();
		mapper.close();

	}

	@After
	public void deleting() {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		List<Agent> aBorrar = UserFinder.findByID("87654321P");
		Jpa.getManager().remove(aBorrar.get(0));
		trx.commit();
		mapper.close();
	}

}
