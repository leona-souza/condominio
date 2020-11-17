package br.condominios.controller;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.condominios.model.Morador;

public class MoradorDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public MoradorDAO() {
		emf = Persistence.createEntityManagerFactory("condominio");
		em = emf.createEntityManager();	
	}
	
	public void cadastrar(Morador morador) throws SQLException {
		em.getTransaction().begin();
		em.merge(morador);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Morador morador) throws SQLException {
		em.getTransaction().begin();
		Morador remover = em.find(Morador.class, morador.getId());
		em.remove(remover);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void alterar(Morador morador) throws SQLException {
		em.getTransaction().begin();
		em.merge(morador);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Morador> listarMoradores() {
		em.getTransaction().begin();
		Query query = em.createQuery("from Morador");
		List<Morador> lista = query.getResultList();
		emf.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Morador> getById(int apartamento) {
		em.getTransaction().begin();
		Query query = em.createQuery("from Morador where apartamentoMorador_id="+ apartamento);
		List<Morador> lista = query.getResultList();
		emf.close();
		return lista;
	}

}
