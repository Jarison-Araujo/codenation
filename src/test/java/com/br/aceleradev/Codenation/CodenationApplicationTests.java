package com.br.aceleradev.Codenation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.aceleradev.Codenation.annotation.Metodo;
import com.br.aceleradev.Codenation.service.impl.LerArquivoServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

@SpringBootTest
class CodenationApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	
	void meuTeste() {
		Class<LerArquivoServiceImpl> myClassLerArquivo = LerArquivoServiceImpl.class;
		for(Method declaredMethod : myClassLerArquivo.getDeclaredMethods()) {
			System.out.println("teste");
			 if(!declaredMethod.getAnnotation(Metodo.class).text().contains(null)) {
				assertEquals("METODO", declaredMethod.getAnnotation(Metodo.class).text());
			}
			
		}
	}

}
