package model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private List<Aresta> arestas;
	
	
	public Grafo(){
		this.arestas = new ArrayList<>();
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}
	
	
	
	

}
