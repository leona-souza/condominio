package br.condominios.beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.condominios.controller.VisitanteDAO;
import br.condominios.model.Visitante;
import br.condominios.util.Mensagens;

@ManagedBean(name = "MBVisitantes")
@ViewScoped
public class VisitanteBean {
	
	private Visitante visitante = new Visitante();
	private List<Visitante> listaDeVisitantes;
	
	public Visitante getVisitante() {
		return visitante;
	}
	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
	public List<Visitante> getListaDeVisitantes() {
		return listaDeVisitantes;
	}
	public void setListaDeVisitantes(List<Visitante> listaDeVisitantes) {
		this.listaDeVisitantes = listaDeVisitantes;
	}
	
	public void cadastrarVisitante() {
		try {
			VisitanteDAO visitantedao = new VisitanteDAO();
			visitantedao.cadastrar(visitante);
			listaDeVisitantes = visitantedao.listarVisitantes();
			Mensagens.adicionarMensagemDeSucesso("Visitante cadastrado com sucesso.");
		} catch(SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public void removerVisitante() {
		try {
			VisitanteDAO visitantedao = new VisitanteDAO();
			visitantedao.remover(visitante);
			listaDeVisitantes = visitantedao.listarVisitantes();
			Mensagens.adicionarMensagemDeSucesso("Visitante excluído com sucesso.");
		} catch(Exception e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public void alterarVisitante() {
		try {
			VisitanteDAO visitantedao = new VisitanteDAO();
			visitantedao.alterar(visitante);
			Mensagens.adicionarMensagemDeSucesso("Visitante alterado com sucesso.");
		} catch(Exception e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}

	@PostConstruct
	public void listarTodos() {
		try {
			VisitanteDAO visitantedao = new VisitanteDAO();
			listaDeVisitantes = visitantedao.listarVisitantes();
		} catch (SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public List<Visitante> getById(int apartamento) {
		try {
			VisitanteDAO visitantedao = new VisitanteDAO();
			listaDeVisitantes = visitantedao.getById(apartamento);
		} catch (SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
		return listaDeVisitantes;
	}

}
