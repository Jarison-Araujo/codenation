package com.br.aceleradev.Codenation.service;

import java.util.List;

import com.br.aceleradev.Codenation.entity.Empresa;
import com.br.aceleradev.Codenation.vo.CompanyVO;

public interface EmpresaService {
	
	CompanyVO salvarEmpresa(CompanyVO companyVO);
	
	void deleteEmpresa(Long id);
	
	List<CompanyVO> buscarEmpresa(String name);
	
}
