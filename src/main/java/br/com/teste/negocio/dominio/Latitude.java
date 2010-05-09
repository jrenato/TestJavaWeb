package br.com.teste.negocio.dominio;

public class Latitude extends Coordenada {
	public DIRECAO_LATITUDE getDirecao() {
		return direcao;
	}

	public void setDirecao(DIRECAO_LATITUDE direcao) {
		this.direcao = direcao;
	}

	private DIRECAO_LATITUDE direcao;
}
