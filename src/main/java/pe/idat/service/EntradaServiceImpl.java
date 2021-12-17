package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Entrada;
import pe.idat.repository.EntradaRepository;

@Service
public class EntradaServiceImpl implements EntradaService{

	@Autowired
	private EntradaRepository repository;
	
	@Override
	@Transactional
	public void insert(Entrada entrada) {
		repository.save(entrada);
	}

	@Override
	@Transactional
	public void update(Entrada entrada) {
		repository.save(entrada);
		
	}

	@Override
	@Transactional
	public void delete(Integer entradaId) {
		repository.deleteById(entradaId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Entrada findById(Integer entradaId) {
		return repository.findById(entradaId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Entrada> findAll() {
		return repository.findAll();
	}

}
