package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.Tarifa;

public interface TarifaService {

	public abstract void insert(Tarifa tarifa);
	public abstract void update(Tarifa tarifa);
	public abstract void delete(Integer tarifaId);
	public abstract Tarifa findById(Integer tarifaId);
	public abstract Collection<Tarifa> findAll();
}
