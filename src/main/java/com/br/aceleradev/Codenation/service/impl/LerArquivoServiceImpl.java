package com.br.aceleradev.Codenation.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import com.br.aceleradev.Codenation.annotation.Metodo;
import com.br.aceleradev.Codenation.service.LerArquivoService;

public class LerArquivoServiceImpl implements LerArquivoService {

	AplicacaoServiceImpl service = new AplicacaoServiceImpl();

	@Override
	public void lerArquivoEmpresa(String nome) {

		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			Long contador = 1L;
			while (lerArq.ready()) {
				String linha = lerArq.readLine();
				if (!linha.equals("nome;documento;vagas;site")) {
					String[] dadosEmpresa = linha.split(";");
					service.criarEmpresa(contador, dadosEmpresa[0], dadosEmpresa[1], Integer.parseInt(dadosEmpresa[2]),
							dadosEmpresa[3]);
					contador++;
				}
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

	}

	@Override
	@Metodo(text="METODO")
	public void lerArquivoUsuario(String nome) {

		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			Long contador = 1L;
			while (lerArq.ready()) {
				String linha = lerArq.readLine();
				if (!linha.equals("nome;documento;idade;login;senha;empresa;salario")) {
					String[] dadosUsuario = linha.split(";");
					service.criarUsuario(contador, dadosUsuario[0], dadosUsuario[1], Integer.parseInt(dadosUsuario[2]), dadosUsuario[3], dadosUsuario[4], Long.parseLong(dadosUsuario[5]), Float.parseFloat(dadosUsuario[6]));
					contador++;
				}
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

	}
	
	public void folhaEmpresa(Long idEmpresa) {
		service.folhaEmpresa(idEmpresa);
	}
	
	public void mediaSalarial(Long idEmpresa) {
		service.mediaSalarial(idEmpresa);
	}
	
	public void maiorSalario(Long idEmpresa) {
		service.maiorSalario(idEmpresa);
	}

	public void menorCusto(Long idEmpresa) {
		service.menorCusto(idEmpresa);
	}
	
	public void mediaIdade(Long idEmpresa) {
		service.mediaIdade(idEmpresa);
	}

	public void usuariosEmpresaPorIdade(Long idEmpresa) {
		service.usuariosEmpresaPorIdade(idEmpresa);
	}
	 
	
	
}
