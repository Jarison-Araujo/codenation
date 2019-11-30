package com.br.aceleradev.Codenation.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.br.aceleradev.Codenation.entity.Empresa;
import com.br.aceleradev.Codenation.entity.Usuario;
import com.br.aceleradev.Codenation.exception.CodenationException;
import com.br.aceleradev.Codenation.service.AplicacaoService;

public class AplicacaoServiceImpl implements AplicacaoService {

	private List<Usuario> usuarios = new ArrayList<>();
	private List<Empresa> empresas = new ArrayList<>();

	Logger LOG = LoggerFactory.getLogger(AplicacaoServiceImpl.class);

	public void criarUsuario(Long id, String nome, String documento, int idade, String login, String senha,
			Long empresa, float salario) {

		if (nome.isEmpty() || documento.isEmpty() || login.isEmpty() || senha.isEmpty() || idade == 0 || salario == 0) {
			throw new CodenationException(
					"USUARIO COM CAMPOS OBRIGATORIOS VAZIO [nome, documento, login, senha e idade sao obrigatorios]");
		} else {
			boolean retorno = buscaUsuario(nome, login, documento);
			if (!retorno) {
				Empresa empresaFuncionario = empresaUsuario(empresa);
				if (empresaFuncionario == null) {
					LOG.error("ERRO: USUARIO {} NAO INCLUIDO /  EMPRESA {} NAO LOCALIZADA! ", nome, empresa);
				} else {
					Usuario novoUsuario = objetoUsuario(id, nome, documento, idade, login, senha, empresaFuncionario,
							salario);
					usuarios.add(novoUsuario);

					LOG.info("USUARIO {} INCLUIDO COM SUCESSO!!", nome);
				}
			}
		}
	}

	public void criarEmpresa(Long id, String nome, String documento, int vagas, String site) {
		boolean retorno = buscaEmpresa(nome, documento);
		if (!retorno) {
			Empresa novaEmpresa = objetoEmpresa(id, nome, documento, vagas, site);
			empresas.add(novaEmpresa);
			LOG.info("EMPRESA {} INCLUIDA COM SUCESSO!!", nome);
		}
	}

	public void maiorSalario(Long idEmpresa) {
		System.out.println("Falta implementar :: Imprimir maior salario de cada empresa  e maior salario geral !");
	}

	public void mediaSalarial(Long idEmpresa) {
		System.out.println("Falta implementar :: imprimir media salarial de cada empresa!");
	}
	
	public void menorCusto(Long idEmpresa) {
		System.out.println("Falta implementar :: Imprimir qual empresa q tem o menor custo!");
	}
	
	public void mediaIdade(Long idEmpresa) {
		System.out.println("Falta implementar :: Imprimir a media de idade!");
	}

	public void usuariosEmpresaPorIdade(Long idEmpresa) {
		System.out.println("Falta implementar :: Orderne e imprima todos os usuarios por idade em cada empresa!");
	}

	public void folhaEmpresa(Long idEmpresa) {

		float totalFolha = 0;

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmpresa().getId().equals(idEmpresa)) {
				totalFolha += usuarios.get(i).getSalario();
			}
		}
		LOG.info("EMPRESA {}  -> TOTAL FOLHA R$ {} ", idEmpresa, totalFolha);

		/*
		 * usuarios.forEach(usuario -> {
		 * if(usuario.getEmpresa().getId().equals(idEmpresa)) {
		 * LOG.info("EMPRESA {}  -> FUNCIONARIO {}  R$ {} ", idEmpresa,
		 * usuario.getNome(), usuario.getSalario()); } });
		 * usuarios.sort(Comparator.comparing(Usuario::getSalario));
		 */
	}

	public void find(Long id) {
		empresas.forEach(n -> {
			if (n.getId() == id) {
				System.out.println("JA EXISTE UMA EMPRESA COM ESSE ID " + id);
			}
		});
	}

	private Usuario objetoUsuario(Long id, String nome, String documento, int idade, String login, String senha,
			Empresa empresa, float salario) {
		Usuario usuario = new Usuario();

		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setDocumento(documento);
		usuario.setIdade(idade);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setEmpresa(empresa);
		usuario.setSalario(salario);

		return usuario;
	}

	private Empresa objetoEmpresa(Long id, String nome, String documento, int vagas, String site) {
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setNome(nome);
		empresa.setDocumento(documento);
		empresa.setVagas(vagas);
		empresa.setSite(site);
		return empresa;
	}

	private Empresa empresaUsuario(Long id) {
		return empresas.stream().filter(empresa -> empresa.getId().equals(id)).findFirst().get();
	}

	private boolean buscaEmpresa(String nome, String documento) {
		for (Empresa empresa : empresas) {
			if (nome.equals(empresa.getNome())) {
				System.out.println("ERRO - JA EXISTE UMA EMPRESA COM ESSE NOME [" + nome + "] !!");
				return true;
			} else if (documento.equals(empresa.getDocumento())) {
				System.out.println("ERRO - JA EXISTE UMA EMPRESA COM ESSE DOCUMENTO [" + documento + "] !!");
				return true;
			}
		}
		return false;
	}

	private boolean buscaUsuario(String nome, String login, String documento) {
		for (Usuario usuario : usuarios) {
			if (nome.equals(usuario.getNome())) {
				System.out.println("ERRO - JA EXISTE UM USUARIO COM ESSE NOME [" + nome + "] !!");
				return true;
			} else if (login.equals(usuario.getLogin())) {
				System.out.println("ERRO - JA EXISTE UM USUARIO COM ESSE LOGIN [" + login + "] !!");
				return true;
			} else if (documento.equals(usuario.getDocumento())) {
				System.out.println("ERRO - JA EXISTE UM USUARIO COM ESSE DOCUMENTO [" + documento + "] !!");
				return true;
			}
		}
		return false;
	}

}
