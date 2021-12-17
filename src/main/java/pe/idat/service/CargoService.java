package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.Cargo;

public interface CargoService {

	public abstract void insert(Cargo cargo);
	public abstract void update(Cargo cargo);
	public abstract void delete(Integer cargoId);
	public abstract Cargo findById(Integer cargoId);
	public abstract Collection<Cargo> findAll();
	
}
