package br.condominios.controller;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import br.condominios.model.Apartamento;

public class ApartamentoDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public ApartamentoDAO() {
		emf = Persistence.createEntityManagerFactory("condominio");
		em = emf.createEntityManager();
	}
		
	public void cadastrar(Apartamento apartamento) throws SQLException {
		em.getTransaction().begin();
		em.merge(apartamento);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void editar(Apartamento apartamento) throws SQLException {
		em.getTransaction().begin();
		em.merge(apartamento);
		em.getTransaction().commit();
		emf.close();
	}
		
	public void remover(Apartamento apartamento) throws RollbackException {
		em.getTransaction().begin();
		Apartamento remover = em.find(Apartamento.class, apartamento.getId());
		em.remove(remover);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Apartamento> listarApartamentos() {
		em.getTransaction().begin();
		List<Apartamento> lista = em.createQuery("from Apartamento").getResultList();
		emf.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public Apartamento getById(int apartamento) {
		em.getTransaction().begin();
		Query query = em.createQuery("FROM Apartamento where id="+ apartamento);
		List<Apartamento> lista = query.getResultList();
		Apartamento retorno = new Apartamento();
		retorno.setApto(lista.get(0).getApto());
		retorno.setTorre(lista.get(0).getTorre());
		emf.close();
		return retorno;
	}
	
}
