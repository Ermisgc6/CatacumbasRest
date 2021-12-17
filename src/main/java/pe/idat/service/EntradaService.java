package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.Entrada;

public interface EntradaService {
	public abstract void insert(Entrada entrada);
	public abstract void update(Entrada entrada);
	public abstract void delete(Integer entradaId);
	public abstract Entrada findById(Integer entradaId);
	public abstract Collection<Entrada> findAll();
}
