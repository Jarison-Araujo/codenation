package com.br.aceleradev.Codenation.vo;

public class AddressVO {
	
	private Long id;
	
	private String cep;
	
	private String rua;
	
	private String cidade;
	
	private Integer numero;
	
	public AddressVO() {
	}

	public AddressVO(Long id, String cep, String rua, String cidade, Integer numero) {
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
