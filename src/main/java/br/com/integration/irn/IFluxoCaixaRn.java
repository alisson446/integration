package br.com.integration.irn;

import br.com.caelum.vraptor.Validator;
import br.com.integration.model.TbFluxoCaixa;

public interface IFluxoCaixaRn {
	
	public Validator validarSalvar(TbFluxoCaixa fluxo);
	
}
