package cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequencia")
public class SequenciaId {
	
	@Id
    private String id;

    private int sequencia;
    
    public SequenciaId() {}

	public SequenciaId(String id, int sequencia) {
		super();
		this.id = id;
		this.sequencia = sequencia;
	}

	public int getSequencia() {
		return sequencia;
	}

	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
