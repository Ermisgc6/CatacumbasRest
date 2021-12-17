package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.Estado;

public interface EstadoService {
	public abstract void insert(Estado estado);
	public abstract void update(Estado estado);
	public abstract void delete(Integer estadoId);
	public abstract Estado findById(Integer estadoId);
	public abstract Collection<Estado> findAll();
}
