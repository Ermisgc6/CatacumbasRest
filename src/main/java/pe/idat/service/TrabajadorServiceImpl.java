package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Trabajador;
import pe.idat.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImpl implements TrabajadorService{

	@Autowired
	private TrabajadorRepository repository;
	
	@Override
	@Transactional
	public void insert(Trabajador trabajador) {
		repository.save(trabajador);
		
	}

	@Override
	@Transactional
	public void update(Trabajador trabajador) {
		repository.save(trabajador);
		
	}

	@Override
	@Transactional
	public void delete(Integer trabajadorId) {
		repository.deleteById(trabajadorId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Trabajador findById(Integer trabajadorId) {
		return repository.findById(trabajadorId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Trabajador> findAll() {
		return repository.findAll();
	}

}
