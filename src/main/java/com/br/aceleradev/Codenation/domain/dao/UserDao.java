package com.br.aceleradev.Codenation.domain.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.aceleradev.Codenation.entity.Usuario;

public interface UserDao extends JpaRepository<Usuario, Long> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE user u set u.name :name WHERE u.id = :id", nativeQuery = true)
	void updateNomeUsuario(@Param("id") Long id,  @Param("name") String name);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user u set u.company_pk = :idEmpresa WHERE u.id = :id", nativeQuery = true)
	void updateEmpresaUsuario(@Param("id") Long id,  @Param("idEmpresa") Long idEmpresa);
	
}
