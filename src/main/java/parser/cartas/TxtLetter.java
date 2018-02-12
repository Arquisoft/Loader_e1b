package parser.cartas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import model.Agent;

public class TxtLetter extends Letter{

	public void createLetter(Agent user) throws IOException{
		FileWriter letter = new FileWriter("cartas/txt/" + user.getIdAgent() + ".txt");
		Writer pw = new PrintWriter(letter);
		pw.write("Usuario: " + user.getUsername() + "\n" + "Password: "
				+ user.getPassword());
		pw.close();
	}
}
