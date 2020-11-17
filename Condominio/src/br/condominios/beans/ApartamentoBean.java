package br.condominios.beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.RollbackException;

import org.primefaces.event.RowEditEvent;

import br.condominios.controller.ApartamentoDAO;
import br.condominios.model.Apartamento;
import br.condominios.util.Mensagens;

@ManagedBean(name="MBApartamentos")
@ViewScoped
public class ApartamentoBean {
	
	private Apartamento apartamento = new Apartamento();
	private List<Apartamento> listaDeApartamentos;
			
	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
	public List<Apartamento> getListaDeApartamentos() {
		return listaDeApartamentos;
	}

	public void setListaDeApartamentos(List<Apartamento> listaDeApartamentos) {
		this.listaDeApartamentos = listaDeApartamentos;
	}

	public void cadastrarApto() {
		try {
			ApartamentoDAO apto = new ApartamentoDAO();
			apto.cadastrar(apartamento);
			listaDeApartamentos = apto.listarApartamentos();
			Mensagens.adicionarMensagemDeSucesso("Apartamento cadastrado com sucesso");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public void editarApto() {
		try {
			ApartamentoDAO apto = new ApartamentoDAO();
			apto.editar(apartamento);
			listaDeApartamentos = apto.listarApartamentos();
			Mensagens.adicionarMensagemDeSucesso("Dados alterados com sucesso");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public void removerApto() {
		try {
			ApartamentoDAO apto = new ApartamentoDAO();
			apto.remover(apartamento);
			listaDeApartamentos = apto.listarApartamentos();
			Mensagens.adicionarMensagemDeSucesso("Apartamento excluído com sucesso");
		} catch (RollbackException e) {
			Mensagens.adicionarMensagemDeErro("Primeiro exclua todos os registros associados a esse apartamento. "+ e);
		}
	}
	
	public void editarVaga(RowEditEvent<Apartamento> evento) throws SQLException {
		ApartamentoDAO apto = new ApartamentoDAO();
		Apartamento apartamento = (Apartamento) evento.getObject();
		apto.editar(apartamento);
	}
	
	@SuppressWarnings("unused")
	public void editarVagaCancelar(RowEditEvent<Apartamento> evento) {
		Apartamento apartamento = (Apartamento) evento.getObject();
	}
	
	@PostConstruct
	public void listarTodos() {
		ApartamentoDAO apto = new ApartamentoDAO();
		listaDeApartamentos = apto.listarApartamentos();
	}
	
	public Apartamento getById(int apartamento) {
		ApartamentoDAO apto = new ApartamentoDAO();
		Apartamento retorno = apto.getById(apartamento);
		return retorno;
	}
	
}
