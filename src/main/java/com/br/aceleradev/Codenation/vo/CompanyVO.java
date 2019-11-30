package com.br.aceleradev.Codenation.vo;

public class CompanyVO {
	
	private Long id;
	
	private String nome;
	
	private String documento;
	
	private int vagas;
	
	private String site;
	
	private AddressVO address;
	
	public CompanyVO() {}
	
	public CompanyVO(Long id, String nome, String documento, int vagas, String site, AddressVO address) {
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.vagas = vagas;
		this.site = site;
		this.address = address;
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

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
