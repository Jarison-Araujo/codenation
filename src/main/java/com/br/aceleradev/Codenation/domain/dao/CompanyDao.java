package com.br.aceleradev.Codenation.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.aceleradev.Codenation.entity.Empresa;
import com.br.aceleradev.Codenation.vo.CompanyVO;

public interface CompanyDao extends JpaRepository<Empresa, Long> {
	
	@Query(value = ("SELECT name FROM company c WHERE c.name like :name ORDER BY name"), nativeQuery = true)
	List<CompanyVO> buscarEmpresasTeste(@Param("name") String name);
	
	List<CompanyVO> findByNome(@Param("name") String nome);
	
	@Query(value = ("SELECT COUNT(*) FROM company"), nativeQuery = true)
	Integer getCompanyCount();
	
	
}
