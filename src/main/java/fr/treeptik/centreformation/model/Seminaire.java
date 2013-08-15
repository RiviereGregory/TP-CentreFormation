package fr.treeptik.centreformation.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SEMINAIRE")
public class Seminaire implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CodeSeminaire")
	private Integer code;

	@Column(name = "PrixSeminaire")
	private Integer prix;

	@Column(name = "DureeSeminaire")
	private Integer duree;

	@Column(name = "NiveauSeminaire")
	private Integer niveau;

	@Column(name = "NbrPlacesSeminaire")
	private Integer nombresPlaces;

	@OneToMany(mappedBy = "concerner")
	private List<Session> sessions;

	public Seminaire() {
	}

	public Seminaire(Integer code, Integer prix, Integer duree, Integer niveau,
			Integer nombresPlaces, List<Session> sessions) {
		super();
		this.code = code;
		this.prix = prix;
		this.duree = duree;
		this.niveau = niveau;
		this.nombresPlaces = nombresPlaces;
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Seminaire [code=" + code + ", prix=" + prix + ", duree=" + duree + ", niveau="
				+ niveau + ", nombresPlaces=" + nombresPlaces + ", sessions=" + sessions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Seminaire other = (Seminaire) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public Integer getNombresPlaces() {
		return nombresPlaces;
	}

	public void setNombresPlaces(Integer nombresPlaces) {
		this.nombresPlaces = nombresPlaces;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

}
