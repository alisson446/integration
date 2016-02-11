package br.com.integration.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.integration.model.ClienteEntity;
import br.com.integration.model.contato.Contato;
import br.com.integration.model.contato.OperadoraEnum;

@Resource
@Path(value = "/request")
public class RequestController {
	
	private Result result;
	
	public RequestController(Result result) {
		this.result = result;
	}
	
	@Get
	@Path(value = "/obter")
	public void obterCliente() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("integration");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select c from ClienteEntity c");
		List<ClienteEntity> lista = query.getResultList();
		
		result.use(json()).withoutRoot().from(lista).serialize();
		manager.close();
		factory.close();
	}
	
}
