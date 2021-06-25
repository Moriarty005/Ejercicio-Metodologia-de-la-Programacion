package org.mp.examenmayo.p2;

public class Municipio implements Comparable {
	
	private String provincia;
	private String municipio;
	private double latitud;
	private double longitud;
	private double altitud;
	private int habitantes;

	public Municipio(String provincia, String municipio, double latitud,
			double longitud, double altitud,
			int habitantes) {
		super();
		this.provincia = provincia;
		this.municipio = municipio;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.habitantes = habitantes;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}


	public double getAltitud() {
		return altitud;
	}


	public int getHabitantes() {
		return habitantes;
	}

	@Override
	public String toString() {
		return "Municipio [provincia=" + provincia + ", municipio=" + municipio
				+ ", latitud=" + latitud + ", longitud=" + longitud + ", altitud=" + altitud + ", habitantes="
				+ habitantes + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipio other = (Municipio) obj;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Object o) {
		
		Municipio aux = (Municipio) o;
		
		
		return this.getMunicipio().compareTo(aux.getMunicipio());
	}	 
}
