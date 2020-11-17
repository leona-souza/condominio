package br.condominios.controller;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.condominios.model.Visitante;

public class VisitanteDAO {

	EntityManagerFactory emf;
	EntityManager em;
	
	public VisitanteDAO() {
		emf = Persistence.createEntityManagerFactory("condominio");
		em = emf.createEntityManager();	
	}
	
	public void cadastrar(Visitante visitante) throws SQLException {
		em.getTransaction().begin();
		em.merge(visitante);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Visitante visitante) throws SQLException {
		em.getTransaction().begin();
		Visitante remover = em.find(Visitante.class, visitante.getId());
		em.remove(remover);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void alterar(Visitante visitante) throws SQLException {
		em.getTransaction().begin();
		em.merge(visitante);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Visitante> listarVisitantes() throws SQLException {
		em.getTransaction().begin();
		Query query = em.createQuery("from Visitante");
		List<Visitante> lista = query.getResultList();
		emf.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Visitante> getById(int apartamento) throws SQLException {
		em.getTransaction().begin();
		Query query = em.createQuery("from Visitante where apartamentoVisitante_id="+ apartamento);
		List<Visitante> lista = query.getResultList();
		emf.close();;
		return lista;
	}
	
}
