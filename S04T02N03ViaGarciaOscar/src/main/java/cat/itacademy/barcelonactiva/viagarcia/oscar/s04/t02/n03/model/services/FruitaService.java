package cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.model.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.model.repository.FruitaRepository;

@Service
public class FruitaService implements Services {
	
	@Autowired
	private FruitaRepository fruitaRepository;
	
	public Fruita add(Fruita fruita) {
		
		return fruitaRepository.save(fruita);
	}
	
	public Fruita getOne(int id) {
		
		return fruitaRepository.findById(id).orElse(null);
	}
	
	public List<Fruita> getAll() {
		
		return fruitaRepository.findAll();
	}

	public Fruita update(Fruita fruita) {
		
		Optional<Fruita> fruitaExisteix = fruitaRepository.findById(fruita.getId());
		Fruita fruitaAntiga = null;
		
		if (fruitaExisteix.isPresent()) {
			
			fruitaAntiga = fruitaExisteix.get();
			fruitaAntiga.setNom(fruita.getNom());
			fruitaAntiga.setQuantitatQuilos(fruita.getQuantitatQuilos());
			fruitaRepository.save(fruitaAntiga);
			
		} else {
			
			fruitaAntiga = new Fruita();
		}
		return fruitaAntiga;
			
	}
	
	public String delete(int id) {
		
		fruitaRepository.deleteById(id);
		return "Fruita esborrada";
		
	}
	
	
}
