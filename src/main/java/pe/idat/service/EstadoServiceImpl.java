package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Estado;
import pe.idat.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoRepository repository;
	
	@Override
	@Transactional
	public void insert(Estado estado) {
		repository.save(estado);
	}

	@Override
	@Transactional
	public void update(Estado estado) {
		repository.save(estado);	
	}

	@Override
	@Transactional
	public void delete(Integer estadoId) {
		repository.deleteById(estadoId);	
	}

	@Override
	@Transactional(readOnly = true)
	public Estado findById(Integer estadoId) {		
		return repository.findById(estadoId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Estado> findAll() {
		return repository.findAll();
	}

}
