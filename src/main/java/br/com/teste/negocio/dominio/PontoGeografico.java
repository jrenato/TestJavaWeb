package br.com.teste.negocio.dominio;

public class PontoGeografico {
	private Latitude latitude;
	private Longitude longitude;
	
	public Latitude getLatitude() {
		return latitude;
	}
	public void setLatitude(Latitude latitude) {
		this.latitude = latitude;
	}
	public Longitude getLongitude() {
		return longitude;
	}
	public void setLongitude(Longitude longitude) {
		this.longitude = longitude;
	}
}
