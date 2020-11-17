package br.condominios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String modelo;
	private String cor;
	private String placa;
	@ManyToOne
	private Apartamento apartamentoVeiculo = new Apartamento();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Apartamento getApartamentoVeiculo() {
		return apartamentoVeiculo;
	}
	public void setApartamentoVeiculo(Apartamento apartamentoVeiculo) {
		this.apartamentoVeiculo = apartamentoVeiculo;
	}	

}
