package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import domain.TipoPlato;

import repositories.TipoPlatoRepository;

public class TipoPlatoService {

	// Managed repository ----------------------------------
	@Autowired 
	TipoPlatoRepository tipoPlatoRepository;
	
	// Supporting services ---------------------------------
	
	// Constructors ----------------------------------------
	public TipoPlatoService() {
		super();
	}

	// Simple CRUD methods ---------------------------------
	public TipoPlato create(){
		TipoPlato result = new TipoPlato();
		return result;
	}
	
	public Collection<TipoPlato> getTipoPlatos(){
		Collection<TipoPlato> result;
		
		result = tipoPlatoRepository.findAll();
		return result;
	}
	
	public TipoPlato findOne(int tipoPlatoId){
		TipoPlato result;
		
		result = tipoPlatoRepository.findOne(tipoPlatoId);
		return result;
	}
	
	public TipoPlato save(TipoPlato tipoPlato){
		TipoPlato result;
	
		result = tipoPlatoRepository.save(tipoPlato);
		return result;
	}

	public void delete(TipoPlato tipoPlato){
		tipoPlatoRepository.delete(tipoPlato);
	}
}
