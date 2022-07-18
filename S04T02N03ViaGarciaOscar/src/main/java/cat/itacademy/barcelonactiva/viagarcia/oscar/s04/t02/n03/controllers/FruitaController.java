package cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.model.services.GeneradorSequenciaService;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n03.model.services.Services;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {
	
	@Autowired
	private Services fruitaService;
	
	@Autowired
	private GeneradorSequenciaService serveiGeneradorId;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Fruita fruita) {
		
		
			fruita.setId(serveiGeneradorId.generarSequencia(Fruita.SEQUENCE_NAME));
		
			Fruita novaFruita = fruitaService.add(fruita);
			
			System.out.println(novaFruita.toString());
			if (novaFruita.getId()!=0 )
				
				return new ResponseEntity<>(novaFruita.toString() + "Afegida a la BD\n", HttpStatus.CREATED);
			
			else 
			
				return new ResponseEntity<>("No s'ha pogut crear la fruita a la BD", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
	/*public Fruita add(@RequestBody Fruita fruita) {
		
		return fruitaService.add(fruita);
			
	}*/
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<String> getOne(@PathVariable int id) {
		try {
			
			Fruita novaFruita = fruitaService.getOne(id);
			return new ResponseEntity<>(novaFruita.toString(), HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Aquest index no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	/*
	public Fruita getOne(@PathVariable int id) {
		
		return fruitaService.getOne(id);
		
	}*/
	
	@GetMapping("/getAll")
	public ResponseEntity<String> getAll() {

			List<Fruita> totesFruites = fruitaService.getAll();
			
			if (!totesFruites.isEmpty()) 
				return new ResponseEntity<>(totesFruites.toString(), HttpStatus.CREATED);			
			else 
				return new ResponseEntity<>("No existeixen fruites", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
		
	/*
	@GetMapping("/getAll")
	public List<Fruita> getAll() {
		
		return fruitaService.getAll();
		
	}*/
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Fruita fruita) {
			
			Fruita fruitaActualitzada = fruitaService.update(fruita);
			
			if (fruitaActualitzada.getId() != 0)
				
				return new ResponseEntity<>(fruitaActualitzada.toString() + " Fruita actualitzada", HttpStatus.CREATED);
			
			else 
			
				return new ResponseEntity<>("Aquest index no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
					
	}
	
	/*
	public Fruita update(@RequestBody Fruita fruita) {
		
		return fruitaService.update(fruita);
	}*/
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		
		try {
			
			fruitaService.delete(id);
			
			return new ResponseEntity<>("Fruita esborrada", HttpStatus.CREATED);
		}
		catch (Exception e) { 
		
			return new ResponseEntity<>("Aquesta fruita no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
				
		}
	}
	/*
	public String delete(@PathVariable int id) {
		
		return fruitaService.delete(id);
	}*/
	
	
}
