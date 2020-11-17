package br.condominios.beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.condominios.controller.MoradorDAO;
import br.condominios.model.Morador;
import br.condominios.util.Mensagens;

@ManagedBean(name="MBMoradores")
@ViewScoped
public class MoradorBean {
	
	private Morador morador = new Morador();
	private List<Morador> listaDeMoradores;
	
	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
	}

	public List<Morador> getListaDeMoradores() {
		return listaDeMoradores;
	}

	public void setListaDeMoradores(List<Morador> listaDeMoradores) {
		this.listaDeMoradores = listaDeMoradores;
	}

	public void cadastrarMorador() {
		try {
			MoradorDAO moradordao = new MoradorDAO();
			moradordao.cadastrar(morador);
			listaDeMoradores = moradordao.listarMoradores();
			Mensagens.adicionarMensagemDeSucesso("Morador cadastrado com sucesso");
		} catch(SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public void removerMorador() {
		try {
			MoradorDAO moradordao = new MoradorDAO();
			moradordao.remover(morador);
			listaDeMoradores = moradordao.listarMoradores();
			Mensagens.adicionarMensagemDeSucesso("Morador removido com sucesso");
		} catch(SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public void alterarMorador() {
		try {
			MoradorDAO moradordao = new MoradorDAO();
			moradordao.alterar(morador);
			listaDeMoradores = moradordao.listarMoradores();
			Mensagens.adicionarMensagemDeSucesso("Morador alterado com sucesso");
		} catch(SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}

	@PostConstruct
	public void listarTodos() {
		MoradorDAO moradordao = new MoradorDAO();
		listaDeMoradores = moradordao.listarMoradores();
	}
	
	public List<Morador> getById(int apartamento) {
		MoradorDAO moradordao = new MoradorDAO();
		listaDeMoradores = moradordao.getById(apartamento);
		return listaDeMoradores;
	}

}
