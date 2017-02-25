package com.sgcom.web.test.unitest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sgcom.web.model.Categoria;
import com.sgcom.web.service.CategoriaBO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/SGCom-servlet.xml")
public class BasicTest {
	
	@Autowired
	CategoriaBO categoriaBO;
	
	@Test
    public void tesMethod() {
		try {
			Collection<Categoria> listaCategorias = categoriaBO.listCategorias();
			assertNotNull("Retorno de Categorias no NULO", listaCategorias);							
		} catch (Exception e) {
			System.err.println("Excepción durante Consulta de Categorias");
			fail(); 		
		}
    }
}
