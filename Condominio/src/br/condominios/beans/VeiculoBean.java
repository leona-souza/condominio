package br.condominios.beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.condominios.controller.VeiculoDAO;
import br.condominios.model.Veiculo;
import br.condominios.util.Mensagens;

@ManagedBean(name = "MBVeiculos")
@ViewScoped
public class VeiculoBean {

	private Veiculo veiculo = new Veiculo();
	private List<Veiculo> listaDeVeiculos;
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public List<Veiculo> getListaDeVeiculos() {
		return listaDeVeiculos;
	}
	public void setListaDeVeiculos(List<Veiculo> listaDeVeiculos) {
		this.listaDeVeiculos = listaDeVeiculos;
	}
	
	public void cadastrarVeiculo() {
		try {
			VeiculoDAO veiculodao = new VeiculoDAO();
			veiculodao.cadastrar(veiculo);
			listaDeVeiculos = veiculodao.listarVeiculos();
			Mensagens.adicionarMensagemDeSucesso("Veículo cadastrado com sucesso.");
		} catch(SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public void alterarVeiculo() {
		try {
			VeiculoDAO veiculodao = new VeiculoDAO();
			veiculodao.alterar(veiculo);
			listaDeVeiculos = veiculodao.listarVeiculos();
			Mensagens.adicionarMensagemDeSucesso("Veículo alterado com sucesso.");
		} catch(SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	public void removerVeiculo() {
		try {
			VeiculoDAO veiculodao = new VeiculoDAO();
			veiculodao.remover(veiculo);
			listaDeVeiculos = veiculodao.listarVeiculos();
			Mensagens.adicionarMensagemDeSucesso("Veículo removido com sucesso.");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemDeErro("Erro: "+ e);
		}
	}
	
	@PostConstruct
	public void listarTodas() {
		VeiculoDAO veiculodao = new VeiculoDAO();
		listaDeVeiculos = veiculodao.listarVeiculos();
	}
	
	public List<Veiculo> getById(int apartamento) {
		VeiculoDAO veiculodao = new VeiculoDAO();
		listaDeVeiculos = veiculodao.getById(apartamento);
		return listaDeVeiculos;
	}
	
}
