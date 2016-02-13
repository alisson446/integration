package br.com.integration.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	private EntityManagerFactory emf;
	EntityManager em;
	
	public FluxoCaixaDAO(){
		emf = Persistence.createEntityManagerFactory("integration");
	}
	
	public void openSession() {
		em = emf.createEntityManager();
		session = em.unwrap(Session.class);
	}
	
	public void closeSession() {
		em.close();
		emf.close();
	}
	
	@Override
	public List<TbFluxoCaixa> todos() throws Exception {
		try {
			openSession();
			criteria = session.createCriteria(TbFluxoCaixa.class);
			List<TbFluxoCaixa> fluxosCadastrados = criteria.list();
			
			closeSession();
			return fluxosCadastrados;
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void salvar(TbFluxoCaixa fluxoCaixa) throws Exception {
		try {
			openSession();
			transaction = session.beginTransaction();
			em.merge(fluxoCaixa);
			transaction.commit();
			closeSession();
		} catch(Exception e) {
			throw e;
		}
	}
	
	public boolean verificar(String codigoFluxo) {
		openSession();
		criteria = session.createCriteria(TbFluxoCaixa.class);
		criteria.add(Restrictions.eq("codigoFluxo", codigoFluxo));
		
		if(criteria.list().isEmpty()) {
			return false;
		}
		
		closeSession();
		return true;
	}
	
	public TbFluxoCaixa exibirFluxoCaixa(String codigoFluxo) throws Exception {
		try {
			openSession();
			criteria = session.createCriteria(TbFluxoCaixa.class);
			criteria.add(Restrictions.eq("codigoFluxo", codigoFluxo));
			fluxoSelecionado = (TbFluxoCaixa) criteria.uniqueResult();
			
			closeSession();
			return fluxoSelecionado;
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void editar(TbFluxoCaixa fluxoCaixa) throws Exception {
		try {
			openSession();
			transaction = session.beginTransaction();
			session.merge(fluxoCaixa);
			transaction.commit();
			closeSession();
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public void excluir(String codigoFluxo) throws Exception {
		try {
			openSession();
			criteria = session.createCriteria(TbFluxoCaixa.class);
			criteria.add(Restrictions.eq("codigoFluxo", codigoFluxo));
			fluxoSelecionado = (TbFluxoCaixa) criteria.uniqueResult();
			
			session.delete(fluxoSelecionado);
			closeSession();
		} catch(Exception e) {
			throw e;
		}
	}
	
}
