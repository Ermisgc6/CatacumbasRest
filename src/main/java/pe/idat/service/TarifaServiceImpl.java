package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Tarifa;
import pe.idat.repository.TarifaRepository;

@Service
public class TarifaServiceImpl implements TarifaService{

	@Autowired
	private TarifaRepository repository;
	
	@Override
	@Transactional
	public void insert(Tarifa tarifa) {
		repository.save(tarifa);
		
	}

	@Override
	@Transactional
	public void update(Tarifa tarifa) {
		repository.save(tarifa);
		
	}

	@Override
	public void delete(Integer tarifaId) {
		repository.deleteById(tarifaId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Tarifa findById(Integer tarifaId) {
		return repository.findById(tarifaId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Tarifa> findAll() {
		return repository.findAll();
	}

}
