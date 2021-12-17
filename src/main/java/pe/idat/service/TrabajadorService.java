package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.Trabajador;

public interface TrabajadorService {
	public abstract void insert(Trabajador trabajador);
	public abstract void update(Trabajador trabajador);
	public abstract void delete(Integer trabajadorId);
	public abstract Trabajador findById(Integer trabajadorId);
	public abstract Collection<Trabajador> findAll();
}
