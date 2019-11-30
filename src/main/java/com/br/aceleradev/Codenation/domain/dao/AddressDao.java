package com.br.aceleradev.Codenation.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.aceleradev.Codenation.entity.Endereco;

public interface AddressDao extends JpaRepository<Endereco, Long>{

}
