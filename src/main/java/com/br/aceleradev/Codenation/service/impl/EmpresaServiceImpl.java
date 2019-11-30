package com.br.aceleradev.Codenation.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.br.aceleradev.Codenation.domain.dao.AddressDao;
import com.br.aceleradev.Codenation.domain.dao.CompanyDao;

import com.br.aceleradev.Codenation.entity.Empresa;
import com.br.aceleradev.Codenation.entity.Endereco;

import com.br.aceleradev.Codenation.service.EmpresaService;
import com.br.aceleradev.Codenation.vo.AddressVO;
import com.br.aceleradev.Codenation.vo.CompanyVO;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private AddressDao addressDao;

	@Override
	@Transactional
	public CompanyVO salvarEmpresa(CompanyVO companyVO) {

		Endereco endereco = new Endereco();
		
		endereco.setCep(companyVO.getAddress().getCep());
		endereco.setRua(companyVO.getAddress().getCep());
		endereco.setCidade(companyVO.getAddress().getCidade());
		endereco.setNumero(companyVO.getAddress().getNumero());
		
		Empresa empresa = new Empresa();

		empresa.setNome(companyVO.getNome());
		empresa.setDocumento(companyVO.getDocumento());
		empresa.setVagas(companyVO.getVagas());
		empresa.setSite(companyVO.getSite());
		empresa.setEndereco(endereco);

		Empresa emp = companyDao.save(empresa);

		AddressVO adressVO = new AddressVO(endereco.getId(), endereco.getCep(), endereco.getRua(), endereco.getCidade(),
				endereco.getNumero());

		CompanyVO company = new CompanyVO(emp.getId(), emp.getNome(), emp.getDocumento(), emp.getVagas(), emp.getSite(),
				adressVO);

		return company;

	}

	@Override
	@Transactional
	public void deleteEmpresa(Long id) {

		companyDao.deleteById(id);

	}

	@Override
	public List<CompanyVO> buscarEmpresa(String name) {
		return companyDao.findByNome(name);

	}
	
	public Integer getCompanyCount() {
		return companyDao.getCompanyCount();
	}

}
