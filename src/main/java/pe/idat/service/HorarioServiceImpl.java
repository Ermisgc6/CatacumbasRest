package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Horario;
import pe.idat.repository.HorarioRepository;

@Service
public class HorarioServiceImpl implements HorarioService{

	@Autowired
	private HorarioRepository repository;
	
	@Override
	@Transactional
	public void insert(Horario horario) {
		repository.save(horario);
		
	}

	@Override
	@Transactional
	public void update(Horario horario) {
		repository.save(horario);
		
	}

	@Override
	@Transactional
	public void delete(Integer horarioId) {
		repository.findById(horarioId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Horario findById(Integer horarioId) {
		return repository.findById(horarioId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Horario> findAll() {
		return repository.findAll();
	}

	
	


}
