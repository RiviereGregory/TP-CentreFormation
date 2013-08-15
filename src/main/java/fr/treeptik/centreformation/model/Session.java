package fr.treeptik.centreformation.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SESSION")
public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NumeroSession")
	private Integer numero;

	@Column(name = "DateSession")
	private Date date;

	@Column(name = "HeureDebut")
	private String heureDebut;

	@Column(name = "HeureFin")
	private String heureFin;

	@ManyToOne
	@JoinColumn(name = "Concerner")
	private Seminaire concerner;

	@OneToMany(mappedBy = "demandeSatifaite")
	private List<Commande> commandes;

	public Session() {
	}

	public Session(Integer numero, Date date, String heureDebut, String heureFin,
			Seminaire concerner, List<Commande> commandes) {
		super();
		this.numero = numero;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.concerner = concerner;
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Session [numero=" + numero + ", date=" + date + ", heureDebut=" + heureDebut
				+ ", heureFin=" + heureFin + ", concerner=" + concerner + ", commandes="
				+ commandes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Session other = (Session) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public Seminaire getConcerner() {
		return concerner;
	}

	public void setConcerner(Seminaire concerner) {
		this.concerner = concerner;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

}
