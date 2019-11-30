package com.br.aceleradev.Codenation.controller;

import com.br.aceleradev.Codenation.service.impl.AplicacaoServiceImpl;

public class AplicacaoController {
	AplicacaoServiceImpl service = new AplicacaoServiceImpl();

	public void criarUsuario(Long id, String nome, String documento, int idade, String login, String senha, Long empresa, float salario) {
		service.criarUsuario(id, nome, documento, idade, login, senha, empresa, salario);
	}
	
	public void criarEmpresa(Long id, String nome, String documento, int vagas, String site) {
		service.criarEmpresa(id, nome, documento, vagas, site);
	}
	
	public void find(Long id) {
		service.find(id);
	}

}
