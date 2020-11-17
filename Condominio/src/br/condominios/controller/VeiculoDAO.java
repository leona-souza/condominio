package br.condominios.controller;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.condominios.model.Veiculo;

public class VeiculoDAO {
	
	EntityManagerFactory emf;
	EntityManager em;

	public VeiculoDAO() {
		emf = Persistence.createEntityManagerFactory("condominio");
		em = emf.createEntityManager();	
	}
	
	public void cadastrar(Veiculo veiculo) throws SQLException {
		em.getTransaction().begin();
		em.merge(veiculo);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Veiculo veiculo) throws SQLException {
		em.getTransaction().begin();
		Veiculo remover = em.find(Veiculo.class, veiculo.getId());
		em.remove(remover);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void alterar(Veiculo veiculo) throws SQLException {
		em.getTransaction().begin();
		em.merge(veiculo);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> listarVeiculos() {
		em.getTransaction().begin();
		Query query = em.createQuery("from Veiculo");
		List<Veiculo> lista = query.getResultList();
		emf.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> getById(int apartamento) {
		em.getTransaction().begin();
		Query query = em.createQuery("from Veiculo where apartamentoVeiculo_id="+ apartamento);
		List<Veiculo> lista = query.getResultList();
		emf.close();
		return lista;
	}
	
}
