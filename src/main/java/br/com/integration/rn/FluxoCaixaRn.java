package br.com.integration.rn;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.integration.dao.FluxoCaixaDAO;
import br.com.integration.irn.IFluxoCaixaRn;
import br.com.integration.model.TbFluxoCaixa;

public class FluxoCaixaRn implements IFluxoCaixaRn{
	
	private Validator validator;
	private FluxoCaixaDAO fluxoDAO;
	
	@Override
	public Validator validarSalvar(TbFluxoCaixa fluxo) {
		validator.checking(new Validations() { {
	        that(!fluxoDAO.verificar(fluxo.getCodigoFluxo()), "erro", "codigo.ja.existente");
	    } });
		
		return validator;
	}
	
}
