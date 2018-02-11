package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;

import model.Agent;


public interface Insert {
	Agent save(Agent user) throws FileNotFoundException, DocumentException, IOException;

	List<Agent> findByID(Long id);

	List<Agent> findByEmail(String email);
}
