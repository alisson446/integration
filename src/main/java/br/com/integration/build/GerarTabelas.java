package br.com.integration.build;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.integration.model.contato.Contato;
import br.com.integration.model.contato.OperadoraEnum;

public class GerarTabelas {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("integration");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Contato contato = new Contato();
		contato.setNome("alisson");
		contato.setOperadora(OperadoraEnum.OI);
		contato.setTelefone("987967254");
		manager.persist(contato);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
	
}
