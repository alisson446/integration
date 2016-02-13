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
import br.com.integration.dao.FluxoCaixaDAO;
import br.com.integration.model.TbFluxoCaixa;

@Resource
@Path(value = "/index")
public class IndexController {

	private Result result;
	private TbFluxoCaixa fluxoCaixa;
	private FluxoCaixaDAO fluxoDAO;
	/*private FluxoCaixaRn fluxoRn;
	private Validator validator;*/
	
	public IndexController(Result result) {
		this.result = result;
		fluxoDAO = new FluxoCaixaDAO();
	}
	
	@Get
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
	@Consumes(value="application/json")
	@Path(value = "/salvar/{fluxo}")
	public void salvar(TbFluxoCaixa fluxo) throws Exception {
		/*validator = fluxoRn.validarSalvar(fluxo);
		
		if(validator.hasErrors()) {
			validator.onErrorSendBadRequest();
		}*/
		fluxoDAO.salvar(fluxo);
		
		result.use(status()).ok();
	}
	
	@Post
	@Path(value = "/exibir/{codigoFluxo}")
	public void exibir(String codigoFluxo) throws Exception {
		fluxoCaixa = fluxoDAO.exibirFluxoCaixa(codigoFluxo);
		result.use(json()).withoutRoot().from(fluxoCaixa).serialize();
	}
	
	@Post
	@Consumes("application/json")
	@Path(value = "/excluir/{codigoFluxo}")
	public void excluir(String codigoFluxo) throws Exception {
		fluxoDAO.excluir(codigoFluxo);
		result.use(status()).ok();
	}
	
}