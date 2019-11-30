package com.br.aceleradev.Codenation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.br.aceleradev.Codenation.service.impl.UsuarioServiceImpl;
import com.br.aceleradev.Codenation.vo.UserVO;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@PutMapping("/updateName")
	@ResponseStatus(HttpStatus.OK)
	public UserVO updateUser(@RequestBody UserVO userVO) {
		return usuarioService.updateNameUser(userVO);
		
	}
	
	@PutMapping("/updateCompany")
	@ResponseStatus(HttpStatus.OK)
	public void updateUserCompany(@Param("idUser") Long idUser, @Param("idCompany") Long idCompany) {
		usuarioService.alterarEmpresaUsuario(idUser, idCompany);
	}
	
		

}
