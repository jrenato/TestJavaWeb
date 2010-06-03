package br.com.radar.negocio.dominio;

import java.io.Serializable;
import java.util.Set;

public class Endereco implements Serializable {
	private static final long serialVersionUID = 6577248025233160724L;

	private int id;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private Set<Telefone> telefone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Set<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}
}
