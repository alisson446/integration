package br.com.integration.controller;

import static br.com.caelum.vraptor.view.Results.json;
import static br.com.caelum.vraptor.view.Results.status;

import java.util.List;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.integration.dao.FluxoCaixaDAO;
import br.com.integration.model.TbFluxoCaixa;
import br.com.integration.rn.FluxoCaixaRn;

@Resource
@Path(value = "/index")
public class IndexController {

	private Result result;
	private FluxoCaixaDAO fluxoDAO;
	private FluxoCaixaRn fluxoRn;
	private Validator validator;
	
	public IndexController(Result result) {
		this.result = result;
		fluxoDAO = new FluxoCaixaDAO();
	}
	
	@Path(value = "/")
	public void index() throws Exception {
		result.redirectTo("../index.html");
	}
	
	@Get
	@Path(value = "/todos")
	public void todos() throws Exception {
		List<TbFluxoCaixa> todos = fluxoDAO.todos();
		result.use(json()).withoutRoot().from(todos).serialize();
	}
	
	@Post
	@Path(value = "/salvar/{caixa}")
	public void salvar(TbFluxoCaixa caixa) throws Exception {
		fluxoDAO.salvar(caixa);
		
		result.use(status()).ok();
	}
	
	@Get
	@Path(value = "/exibir/{codigoFluxo}")
	public void exibir(String codigoFluxo) throws Exception {
		fluxoDAO.exibirFluxoCaixa(codigoFluxo);
		result.use(json()).withoutRoot().from(fluxoDAO.todos()).serialize();
	}
	
	@Post
	@Consumes("application/json")
	@Path(value = "/exibir/{fluxo}")
	public void editar(TbFluxoCaixa fluxo) throws Exception {
		fluxoDAO.editar(fluxo);
		result.use(status()).ok();
	}
	
	@Post
	@Consumes("application/json")
	@Path(value = "/exibir/{codigoFluxo}")
	public void excluir(String codigoFluxo) throws Exception {
		fluxoDAO.excluir(codigoFluxo);
		result.use(status()).ok();
	}
	
}