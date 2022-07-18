package cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.model.domain;



import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="fruites")
public class Fruita {
	
	@Transient
    public static final String SEQUENCE_NAME = "fruita_sequencia";
	


	@Id
	private int id;
	private String nom;
	private int quantitatQuilos;
	
	public Fruita() {}

	public Fruita(String nom, int quantitatQuilos) {
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}
	
	public void setId(int id) {
		this.id = id;
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
