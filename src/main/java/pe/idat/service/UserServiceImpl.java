package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.UserVo;
import pe.idat.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	

	
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
