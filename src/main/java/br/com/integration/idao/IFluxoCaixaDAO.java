package br.com.integration.idao;

import java.util.List;
import br.com.integration.model.TbFluxoCaixa;

public interface IFluxoCaixaDAO {
	
	public List<TbFluxoCaixa> todos() throws Exception;
	
	public void salvar(TbFluxoCaixa fluxoCaixa) throws Exception;
	
	public boolean verificar(String codigoFluxo);
	
	public TbFluxoCaixa exibirFluxoCaixa(String codigoFluxo) throws Exception;
	
	public void editar(TbFluxoCaixa fluxoCaixa) throws Exception;
	
	public void excluir(String codigoFluxo) throws Exception;
	
}
