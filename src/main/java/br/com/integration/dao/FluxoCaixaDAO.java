package br.com.integration.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.integration.idao.IFluxoCaixaDAO;
import br.com.integration.model.TbFluxoCaixa;

public class FluxoCaixaDAO implements IFluxoCaixaDAO {
	
	private Session session;
	private Transaction transaction;
	private Criteria criteria;
	private TbFluxoCaixa fluxoSelecionado;
	
	
	@Override
	public List<TbFluxoCaixa> todos() throws Exception {
		try {
			criteria = session.createCriteria(TbFluxoCaixa.class);
			List fluxosCadastrados = criteria.list();
			
			return fluxosCadastrados;
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void salvar(TbFluxoCaixa fluxoCaixa) throws Exception {
		try {
			transaction = session.beginTransaction();
			session.save(fluxoCaixa);
			transaction.commit();
		} catch(Exception e) {
			throw e;
		}
	}
	
	public boolean verificar(String codigoFluxo) {
		criteria = session.createCriteria(TbFluxoCaixa.class);
		criteria.add(Restrictions.eq("codigofluxo", codigoFluxo));
		
		if(criteria.list().isEmpty()) {
			return false;
		}
		return true;
	}
	
	public TbFluxoCaixa exibirFluxoCaixa(String codigoFluxo) throws Exception {
		try {
			criteria = session.createCriteria(TbFluxoCaixa.class);
			criteria.add(Restrictions.eq("codigofluxo", codigoFluxo));
			fluxoSelecionado = (TbFluxoCaixa) criteria.uniqueResult();
			
			return fluxoSelecionado;
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void editar(TbFluxoCaixa fluxoCaixa) throws Exception {
		try {
			transaction = session.beginTransaction();
			session.merge(fluxoCaixa);
			transaction.commit();
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void excluir(String codigoFluxo) throws Exception {
		try {
			criteria = session.createCriteria(TbFluxoCaixa.class);
			criteria.add(Restrictions.eq("codigofluxo", codigoFluxo));
			fluxoSelecionado = (TbFluxoCaixa) criteria.uniqueResult();
			
			session.delete(fluxoSelecionado);
		} catch(Exception e) {
			throw e;
		}
	}
	
}
