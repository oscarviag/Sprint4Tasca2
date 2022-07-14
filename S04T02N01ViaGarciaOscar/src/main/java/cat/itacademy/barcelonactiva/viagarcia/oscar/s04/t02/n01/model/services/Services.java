package cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s04.t02.n01.model.domain.Fruita;

public interface Services {
	
	public Fruita add(Fruita fruita);
	
	public Fruita getOne(int id);
	
	public List<Fruita> getAll();

	public Fruita update(Fruita fruita);
	
	public String delete(int id);

}
