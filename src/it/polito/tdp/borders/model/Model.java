package it.polito.tdp.borders.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	public Model() {
	   
	}
	
	public Graph<Country,DefaultEdge> creaGrafo(int anno) {
	   BordersDAO dao= new BordersDAO();
	   Graph<Country,DefaultEdge> grafo=new SimpleGraph<>(DefaultEdge.class);
	   TuttiPaesi totalePaesi=new TuttiPaesi();
	   List<Border> confiniRichiesti=dao.getCountryPairs(totalePaesi, anno);
	   for(Border b:confiniRichiesti) {
		   if(!grafo.vertexSet().contains(b.getC1())) {
		      grafo.addVertex(b.getC1());
		   }
		   if(!grafo.vertexSet().contains(b.getC2())) {
			      grafo.addVertex(b.getC2());
			}
	   }
	   for(Border b:confiniRichiesti) {
		   grafo.addEdge(b.getC1(), b.getC2());
	   }
	   
	   return grafo;
	}
	
	public int calcolaGrado(Country c,Graph<Country,DefaultEdge> grafo) {
		return grafo.edgesOf(c).size();
	}
	
	public int getNumeroComponentiConnesse(Graph<Country,DefaultEdge> grafo) {
		if (grafo == null) {
			throw new RuntimeException("Grafo non esistente");
		}

		ConnectivityInspector<Country, DefaultEdge> ci = new ConnectivityInspector<Country, DefaultEdge>(grafo);
		return ci.connectedSets().size();
	}


}
