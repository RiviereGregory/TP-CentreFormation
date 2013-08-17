package fr.treeptik.centreformation.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FACTURE")
public class Facture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NumeroFacture")
	private Integer numero;

	@Column(name = "DateFacture")
	private Date date;

	@Column(name = "MontantFacture")
	private Integer montant;

	@Column(name = "NbrPlacesFacturees ")
	private Integer nombresPlaces;

	@OneToOne
	@JoinColumn(name = "CommandeNumero")
	private Commande commande;

	public Facture() {
	}

	public Facture(Integer numero, Date date, Integer montant, Integer nombresPlaces) {
		super();
		this.numero = numero;
		this.date = date;
		this.montant = montant;
		this.nombresPlaces = nombresPlaces;
	}

	@Override
	public String toString() {
		return "Facture [numero=" + numero + ", date=" + date + ", montant=" + montant
				+ ", nombresPlaces=" + nombresPlaces + "]";
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
		Facture other = (Facture) obj;
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

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public Integer getNombresPlaces() {
		return nombresPlaces;
	}

	public void setNombresPlaces(Integer nombresPlaces) {
		this.nombresPlaces = nombresPlaces;
	}

}
