package com.br.aceleradev.Codenation.service;


public interface UsuarioService {
	
	public void salvarUsuario(String nome, String documento, int idade, String login, String senha,
			Long empresa, float salario);
	
	public void deleteUsuario(Long id);
	
	public void updateNomeUsuario(Long id, String name);
	
	public void alterarEmpresaUsuario(Long idUsuario, Long idEmpresa);
}
