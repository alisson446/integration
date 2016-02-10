package br.com.integration.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path(value = "/index")
public class IndexController {

	private final Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
		result.include("nome", "alisson");
	}
	
}