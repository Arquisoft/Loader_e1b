package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
public class Agent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String localizacion;
	private String idAgent;
	private String email;
	private String username;
	private String password;
//	private String kind;
	private int kindCode;
	
	public Agent(String nombre, String localizacion, String id, String email, int kindCode) {
		super();
		this.nombre = nombre;
		this.setLocalizacion(localizacion);
		this.setIdAgent(id);
		this.email = email;
		this.kindCode = kindCode;
		generarUser();
		generarPassword();
	}

	private void generarUser() {
		this.username=idAgent;
	}

	Agent() {
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	private void generarPassword() {
		StringBuffer pass = new StringBuffer();
		int low = 65;
		int top = 90;
		for (int i = 0; i < 9; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * (top - low) + low);
			pass.append((char) numAleatorio);
		}
		for (int i = 0; i < 3; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * (9 - 0) + 0);
			pass.append(numAleatorio);
		}
		setPassword(pass.toString());
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	private void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Long getId() {
		return id;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idAgent == null) ? 0 : idAgent.hashCode());
		result = prime * result + kindCode;
		result = prime * result + ((localizacion == null) ? 0 : localizacion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idAgent == null) {
			if (other.idAgent != null)
				return false;
		} else if (!idAgent.equals(other.idAgent))
			return false;
		if (kindCode != other.kindCode)
			return false;
		if (localizacion == null) {
			if (other.localizacion != null)
				return false;
		} else if (!localizacion.equals(other.localizacion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agent [nombre=" + nombre + ", localizacion=" + localizacion + ", id=" + id + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}

	public String getIdAgent() {
		return idAgent;
	}

	private void setIdAgent(String idAgent) {
		this.idAgent = idAgent;
	}

}
