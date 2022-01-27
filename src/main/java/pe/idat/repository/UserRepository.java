package pe.idat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pe.idat.entity.UserVo;

public interface UserRepository extends JpaRepository<UserVo, Integer>{
	
	public abstract UserVo findByUsuario(String usuario);
	
}
