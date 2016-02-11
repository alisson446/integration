package br.com.integration.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path(value = "/")
public class IndexController {

private Result result;
	
	public IndexController(Result result) {
		this.result = result;
	}
	
	@Path(value = "/index")
	public void index() {
		result.redirectTo("index.html");
	}
	
}