package modeltest;

import static org.junit.Assert.*;

import java.util.Date;

import model.Agent;

import org.junit.Test;

public class UserTest {

	@Test
	public void testEquals() {
		Date date = new Date(System.currentTimeMillis());
		Agent user1 = new Agent("Dani Duque", "C\\Buenavida", "7777777R", "email@gmail.com", 1);
		Agent user2 = new Agent("Dani Duque", "C\\Buenavida", "7777777R", "email@gmail.com",  1);
		Agent user3 = new Agent("Dani Duque", "C\\Buenavida", "7787777R", "email@gmail.com",  1);
		Agent user4 = new Agent("Dani Duque", "C\\Buenavida", null, "email@gmail.com",  1);

		assertEquals(true, user1.equals(user2));
		assertEquals(true, user3.equals(user3));
		assertEquals(false, user2.equals(user3));
		assertNotNull(user1);
		assertEquals(false, user1.equals(new Integer(8)));
		assertEquals(false, user4.equals(user3));
	}

	@Test
	public void testHashCode() {
		Agent user1 = new Agent("Dani Duque", "C\\Buenavida", "7777777R", "email@gmail.com",  1);
		Agent user2 = new Agent("Dani Duque", "C\\Buenavida", "7777777R", "email@gmail.com",  1);
		Agent user3 = new Agent("Dani Duque", "C\\Buenavida", "7787777R", "email@gmail.com",  1);
		Agent user4 = new Agent("Dani Duque", "C\\Buenavida", null, "email@gmail.com", 1);
		Agent user5 = new Agent("Dani Duque", "C\\Buenavida", null, "email@gmail.com",  1);

		assertEquals(user1.hashCode(), user2.hashCode());
		assertEquals(user4.hashCode(), user5.hashCode());
		assertNotEquals(user2.hashCode(), user3.hashCode());

		System.out.println(user1.toString());
	}

	@Test
	public void testAll() {
		Date date = new Date(System.currentTimeMillis());
		Agent user1 = new Agent("Dani Duque", "C\\Buenavida", "7777777R", "email@gmail.com",  1);

		String password = user1.getPassword();
		String userName = user1.getUsername();
		String toString = "Agent [id =null, nombre=Dani, apellidos=Duque, email=email@gmail.com, fechaNacimiento=" + date
				+ ", direccionPostal=C\\Buenavida, nacionalidad=Español, DNI=7777777R]";
	

		assertEquals("Dani Duque", user1.getNombre());
		assertEquals("email@gmail.com", user1.getEmail());
		assertEquals("C\\Buenavida", user1.getLocalizacion());
		assertEquals("7777777R", user1.getIdAgent());
		assertEquals(password, user1.getPassword());
		assertEquals(userName, user1.getUsername());
//		assertEquals(toString, user1.toString());
	}

}
