package com.br.aceleradev.Codenation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity(name = "user")
public class Usuario {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "document", nullable = false, length = 255)
	private String documento;
	
	@Column(name = "ager")
	private int idade;
	
	@Column(name = "login", nullable = false, length = 255)
	private String login;
	
	@Column(name = "password", nullable = false, length = 255)
	private String senha;
	
	@Column(name = "salary")
	private float salario;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_pk")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "company_pk")
	private Empresa empresa;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_role",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<Role> roles;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = criptografia(senha);
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	private String criptografia(String senha) {
		/*
		A senha no arquivo deverá ser “criptografada”.
			-> Alterar “u” para = “#0P”
			-> Alterar “s” para = “[%0”
			-> Alterar “e” para = “lD7”
			-> Alterar “r” para = “çA=“
		*/
		return senha.replace("u", "#0P").replace("s", "[%0").replace("s", "lD7").replace("r", "çA=");
	}
	
	
}
