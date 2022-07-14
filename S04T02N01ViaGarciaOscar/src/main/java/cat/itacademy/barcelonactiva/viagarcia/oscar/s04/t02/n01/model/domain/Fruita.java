package cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n01.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name="fruita")
public class Fruita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "quantitat")
	private int quantitatQuilos;
	
	public Fruita() {}

	public Fruita(String nom, int quantitatQuilos) {
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}

	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}
	
	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quantitat=" + quantitatQuilos + "]";
	}	

}
