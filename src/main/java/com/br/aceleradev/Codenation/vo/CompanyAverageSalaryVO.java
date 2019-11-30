package com.br.aceleradev.Codenation.vo;

import java.math.BigDecimal;

public class CompanyAverageSalaryVO {
	
	private String nome;
	
	private BigDecimal averageSalary;
	
	
	public CompanyAverageSalaryVO() {}
	
	public CompanyAverageSalaryVO(String nome, BigDecimal averageSalary) {
		this.nome = nome;
		this.averageSalary = averageSalary;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getAverageSalary() {
		return averageSalary;
	}
	public void setAverageSalary(BigDecimal averageSalary) {
		this.averageSalary = averageSalary;
	}

	
}
