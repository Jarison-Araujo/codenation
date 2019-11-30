package com.br.aceleradev.Codenation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.aceleradev.Codenation.service.impl.EmpresaServiceImpl;
import com.br.aceleradev.Codenation.vo.CompanyVO;
import com.br.aceleradev.Codenation.vo.UserVO;

@RestController
@RequestMapping("/v1/company")
public class CompanyController {

	@Autowired
	private EmpresaServiceImpl empresaService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public CompanyVO createCompany(@RequestBody CompanyVO companyVO) {

		return empresaService.salvarEmpresa(companyVO);

	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteCompany(@Param("id") Long id) {
		empresaService.deleteEmpresa(id);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CompanyVO> listCompany(@RequestParam String name){
		return empresaService.buscarEmpresa(name);
		
	}
		
}
