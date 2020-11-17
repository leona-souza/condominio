package br.condominios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="moradores")
public class Morador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String documento;
	private String telefone;
	@ManyToOne	
	private Apartamento apartamentoMorador = new Apartamento();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Apartamento getApartamentoMorador() {
		return apartamentoMorador;
	}
	public void setApartamentoMorador(Apartamento apartamentoMorador) {
		this.apartamentoMorador = apartamentoMorador;
	}
	
	
}
