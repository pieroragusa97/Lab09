package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.borders.db.BordersDAO;

public class TuttiPaesi {
	Map<Integer,Country> paesi=new HashMap<Integer,Country>();
	
	
	public TuttiPaesi() {
		BordersDAO dao=new BordersDAO();
		List<Country> paesiLista=dao.loadAllCountries();
		for(Country c:paesiLista) {
			paesi.put(c.getCodice(), c);
		}
		
	}
	public Country ottieniPaese(int codice) {
		return paesi.get(codice);
	}
	
	

}
