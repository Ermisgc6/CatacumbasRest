package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Cargo;
import pe.idat.repository.CargoRepository;

@Service
public class CargoServiceImpl implements CargoService{

	@Autowired
	private CargoRepository repository;
	
	
	@Override
	@Transactional
	public void insert(Cargo cargo) {
		repository.save(cargo);
		
	}

	@Override
	@Transactional
	public void update(Cargo cargo) {
		repository.save(cargo);
		
	}

	@Override
	@Transactional
	public void delete(Integer cargoId) {
		repository.deleteById(cargoId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo findById(Integer cargoId) {
		return repository.findById(cargoId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cargo> findAll() {
		return repository.findAll();
	}

}
