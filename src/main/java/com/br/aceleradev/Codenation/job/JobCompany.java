package com.br.aceleradev.Codenation.job;

import java.time.Instant;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.br.aceleradev.Codenation.service.impl.EmpresaServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobCompany {
	
	@Autowired
	EmpresaServiceImpl empresaService;
	
	SimpleDateFormat format = new SimpleDateFormat("");
	
	@Scheduled(fixedRate = 5000)
	public void listCompany() {
		Instant inicial = Instant.now();
	    
		log.info("### START VERIFY COUNT COMPANIES {}", inicial);
		log.info("### FOUND {} COMPANY IN BASE", empresaService.getCompanyCount());
		Instant fim = Instant.now();
		log.info("### END VERIFY COUNT COMPANIES {}  DURATION {} ", fim, Duration.between(inicial, fim).toMillis());
			
	}

}
