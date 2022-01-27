package pe.idat.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pe.idat.entity.RoleVo;
import pe.idat.entity.UserVo;
import pe.idat.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService , UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	@Transactional( readOnly = true)
	public UserVo findByUsername(String username) {
		return repository.findByUsuario(username);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo user = this.findByUsername(username);
		
		if(user!=null) {
			
			Collection<GrantedAuthority> roles = new ArrayList<>();
			
			for(RoleVo role:user.getItemsRole()) {
				roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
			}
			
			
			return new User(user.getUsuario(), user.getContraseña(), roles);
			
		}
				
		throw new UsernameNotFoundException("Username " +username+ "no encontrado");
	}
	
	
	
	@Override
	@Transactional
	public void insert(UserVo uservo) {
		repository.save(uservo);
	}

	@Override
	@Transactional
	public void update(UserVo uservo) {
		repository.save(uservo);
		
	}

	@Override
	@Transactional
	public void delete(Integer usuarioId) {
		repository.deleteById(usuarioId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public UserVo findById(Integer usuarioId) {
		return repository.findById(usuarioId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<UserVo> findAll() {
		return repository.findAll();
	}



}
