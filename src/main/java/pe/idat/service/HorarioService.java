package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.Horario;

public interface HorarioService {
	public abstract void insert(Horario horario);
	public abstract void update(Horario horario);
	public abstract void delete(Integer horarioId);
	public abstract Horario findById(Integer horarioId);
	public abstract Collection<Horario> findAll();
}
