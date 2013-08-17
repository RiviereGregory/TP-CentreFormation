package fr.treeptik.centreformation.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMANDE")
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NumeroCommande")
	private Integer numero;

	@Column(name = "DateCommande")
	private Date date;

	@Column(name = "NbrPlacesCommande")
	private Integer nombresPlaces;

	@ManyToOne
	@JoinColumn(name = "SocieteCode")
	private Societe societe;

	@ManyToOne
	@JoinColumn(name = "SessionNumero")
	private Session session;

	@OneToOne(mappedBy = "commande")
	private Facture facture;

	public Commande() {
	}

	public Commande(Integer numero, Date date, Integer nombresPlaces, Societe societe,
			Session session, Facture facture) {
		super();
		this.numero = numero;
		this.date = date;
		this.nombresPlaces = nombresPlaces;
		this.societe = societe;
		this.session = session;
		this.facture = facture;
	}

	@Override
	public String toString() {
		return "Commande [numero=" + numero + ", date=" + date + ", nombresPlaces=" + nombresPlaces
				+ ", societe=" + societe + ", session=" + session + ", facture=" + facture + "]";
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
		Commande other = (Commande) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public Integer getNombresPlaces() {
		return nombresPlaces;
	}

	public void setNombresPlaces(Integer nombresPlaces) {
		this.nombresPlaces = nombresPlaces;
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

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public Session getSession() {
		return session;
	}

	public void setDemandeSatifaite(Session session) {
		this.session = session;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

}
