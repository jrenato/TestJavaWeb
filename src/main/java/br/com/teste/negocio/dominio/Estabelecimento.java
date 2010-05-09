package br.com.teste.negocio.dominio;

public class Estabelecimento {
	private String nome;
	private Endereco endereco;
	private PontoGeografico pontoGeografico;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public PontoGeografico getPontoGeografico() {
		return pontoGeografico;
	}
	public void setPontoGeografico(PontoGeografico pontoGeografico) {
		this.pontoGeografico = pontoGeografico;
	}
}
