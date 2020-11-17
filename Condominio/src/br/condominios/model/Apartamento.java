package br.condominios.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int apto;
	private String torre;
	private String vaga;
	private String obs;
	@OneToMany(mappedBy = "apartamentoVisitante", fetch = FetchType.LAZY)
	private List<Visitante> visitantes;
	@OneToMany(mappedBy = "apartamentoVeiculo", fetch = FetchType.LAZY)
	private List<Veiculo> veiculos;
	@OneToMany(mappedBy = "apartamentoMorador", fetch = FetchType.LAZY)
	private List<Morador> morador;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApto() {
		return apto;
	}
	public void setApto(int apto) {
		this.apto = apto;
	}
	public String getTorre() {
		return torre;
	}
	public void setTorre(String torre) {
		this.torre = torre;
	}
	public String getVaga() {
		return vaga;
	}
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public List<Visitante> getVisitantes() {
		return visitantes;
	}
	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	public List<Morador> getMorador() {
		return morador;
	}
	public void setMorador(List<Morador> morador) {
		this.morador = morador;
	}
		
}
