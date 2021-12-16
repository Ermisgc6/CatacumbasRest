package pe.idat.service;

import java.util.Collection;

import pe.idat.entity.UserVo;

public interface UserService {

	public abstract void insert(UserVo uservo);
	public abstract void update(UserVo uservo);
	public abstract void delete(Integer usuarioId);
	public abstract UserVo findById(Integer usuarioId);
	public abstract Collection<UserVo> findAll();
	
}
