package br.com.radar.negocio.dominio;

import java.io.Serializable;

public class Coordenada implements Serializable {
	private static final long serialVersionUID = 8062972890447877158L;

	private int id;
	private Double latitude;
	private Double longitude;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
