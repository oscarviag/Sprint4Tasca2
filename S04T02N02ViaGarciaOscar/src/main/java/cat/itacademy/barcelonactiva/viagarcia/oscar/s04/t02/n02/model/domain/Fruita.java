package cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n02.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name="fruites")
public class Fruita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 50, name = "nom", nullable=false)
	private String nom;
	
	@Column(name = "quantitat", nullable=false)
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
		return "id=" + id + ", nom=" + nom + ", quantitat=" + quantitatQuilos + "\n";
	}	

}
