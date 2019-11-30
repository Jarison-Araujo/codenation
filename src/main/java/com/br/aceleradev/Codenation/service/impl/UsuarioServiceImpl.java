package com.br.aceleradev.Codenation.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.br.aceleradev.Codenation.domain.dao.CompanyDao;
import com.br.aceleradev.Codenation.domain.dao.UserDao;
import com.br.aceleradev.Codenation.entity.Empresa;
import com.br.aceleradev.Codenation.entity.Usuario;
import com.br.aceleradev.Codenation.service.UsuarioService;
import com.br.aceleradev.Codenation.vo.UserVO;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	
	@Transactional
	@Modifying
	public UserVO updateNameUser(UserVO userVO) {
		
		Usuario user = userDao.getOne(userVO.getId());
		user.setNome(userVO.getNome());
		
		Usuario userAlt = userDao.save(user);
		
		UserVO userVOAlt= new UserVO(userAlt.getId(), userAlt.getNome());
		return userVOAlt;
		
	}
	
	
	@Override
	@Transactional
	public void salvarUsuario(String nome, String documento, int idade, String login, String senha, Long empresa, float salario) {
		
		Empresa empresaUser = companyDao.getOne(empresa);
		
		Usuario usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setDocumento(documento);
		usuario.setIdade(idade);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setSalario(salario);
		usuario.setEmpresa(empresaUser);
		
		userDao.save(usuario);
		
	}

	@Override
	@Transactional
	public void deleteUsuario(Long id) {
		
		userDao.deleteById(id);
		
	}

	@Override
	public void updateNomeUsuario(Long id, String name) {
		userDao.updateNomeUsuario(id, name);
		
	}

	@Override
	public void alterarEmpresaUsuario(Long idUsuario, Long idEmpresa) {
		userDao.updateEmpresaUsuario(idUsuario, idEmpresa);
	}

	
}
