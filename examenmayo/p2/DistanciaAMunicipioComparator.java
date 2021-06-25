package org.mp.examenmayo.p2;

import java.util.Comparator;

public class DistanciaAMunicipioComparator implements Comparator {

	private Municipio municipio;
	
	public DistanciaAMunicipioComparator(Municipio municipio) {
		super();
		this.municipio = municipio;
	}

	@Override
	public int compare(Object o1, Object o2) {

		Municipio aux1 = (Municipio) o1;
		Municipio aux2 = (Municipio) o2;
		
		double dist1 = distanciaEntrePuntosLatLon(this.municipio.getLatitud(), this.municipio.getLongitud(), aux1.getLatitud(), aux1.getLongitud());
		double dist2 = distanciaEntrePuntosLatLon(this.municipio.getLatitud(), this.municipio.getLongitud(), aux2.getLatitud(), aux2.getLongitud());
		
		int comparacion = 0;
		
		if(dist1 > dist2) {
			comparacion = 1;
		}else if(dist1 <= dist2) {
			comparacion = -1;
		}
		
		return comparacion;
	}
	
	private  double distanciaEntrePuntosLatLon(double lat1, double lng1, double lat2, double lng2) {  
       
        double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(lng2 - lng1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    }  

}
