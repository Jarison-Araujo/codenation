package com.br.aceleradev.Codenation.controller;

import com.br.aceleradev.Codenation.service.impl.LerArquivoServiceImpl;

public class LerArquivoController {
	
	LerArquivoServiceImpl service = new LerArquivoServiceImpl();
	
	public void lerArquivoEmpresa(String nome) {
		service.lerArquivoEmpresa(nome);
	}

	public void lerArquivoUsuario(String nome) {
		service.lerArquivoUsuario(nome);
	}
	
	public void folhaEmpresa(Long idEmpresa) {
		service.folhaEmpresa(idEmpresa);
	}
	
	public void mediaSalarial(Long idEmpresa) {
		service.mediaSalarial(idEmpresa);
	}

	

}
