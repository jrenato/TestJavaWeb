package br.com.teste;

import javax.faces.event.ActionEvent;

public class TesteBean {
	private String nome = "aaa";
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void submeta(ActionEvent e) {
		this.nome += "--submetido";
	}
	public String submeter() {
		return "submeter";
	}
}
