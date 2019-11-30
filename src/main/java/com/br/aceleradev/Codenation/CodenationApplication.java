package com.br.aceleradev.Codenation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
//@EnableScheduling
public class CodenationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodenationApplication.class, args);

		/*
		 * EntityManagerFactory factory =
		 * Persistence.createEntityManagerFactory("application"); factory.close();
		 */

		/*
		 * LerArquivoController controllerFile = new LerArquivoController();
		 * 
		 * String arquivoEmpresa =
		 * "C:\\Users\\jaris\\eclipse-workspace\\Codenation\\arquivos\\empresa.txt";
		 * String arquivoUsuarios =
		 * "C:\\\\Users\\\\jaris\\\\eclipse-workspace\\\\Codenation\\\\arquivos\\usuarios.txt";
		 * 
		 * controllerFile.lerArquivoEmpresa(arquivoEmpresa);
		 * controllerFile.lerArquivoUsuario(arquivoUsuarios);
		 * controllerFile.folhaEmpresa(5L); controllerFile.mediaSalarial(5L);
		 */

	}
}
