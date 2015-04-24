package controller;

import java.util.ArrayList;
import java.util.List;

import model.Aresta;
import model.Grafo;
import model.No;

public class RegraMapa {
	private Grafo grafo;
	
	
	public void criarRegra(){
		No A = new No("A");
		No B = new No("B");
		No C = new No("C");
		No D = new No("D");
		No E = new No("E");
		
		Aresta CB = new Aresta(C,B,300d);
		Aresta CD = new Aresta(C,D,200d);
		Aresta BE = new Aresta(B,E,200d);
		Aresta BA = new Aresta(B,A,350d);
		Aresta ED = new Aresta(E,D,150d);
		Aresta AB = new Aresta(A,D,750d);
		
		List<Aresta> aresta = new ArrayList<>();
		
		aresta.add(CB);
		aresta.add(CD);
		aresta.add(BE);
		aresta.add(BA);
		aresta.add(ED);
		aresta.add(AB);
		
		this.getGrafo().setArestas(aresta);
	}
	
	public boolean verificarSolucaoPossivel(List<No> solucao){
		
		System.out.println(this.getGrafo().getArestas());
		byte resultado = 0;
		byte tamanhoSolucao = (byte) solucao.size();
		byte tamanhoGrafo = (byte) this.getGrafo().getArestas().size();
		for (byte i=1;i < tamanhoSolucao;i++) {
			for(byte j =0; j < tamanhoGrafo; j++){
				System.out.println(solucao.get(i-1).getDescricao());
				System.out.println(solucao.get(i).getDescricao());
                if(solucao.get(i-1).getDescricao().equals(this.getGrafo().getArestas().get(j).getPontoEsquerdo().getDescricao())){
					if(solucao.get(i).getDescricao().equals(this.getGrafo().getArestas().get(j).getPontoDireito().getDescricao())){
						resultado ++;
					}
				}
				
				if(solucao.get(i-1).getDescricao().equals(this.getGrafo().getArestas().get(j).getPontoDireito().getDescricao())){
					 if(solucao.get(i).getDescricao().equals(this.getGrafo().getArestas().get(j).getPontoEsquerdo().getDescricao())){
						 resultado ++;
					 }
				}
				
			}
		}
		
		System.out.println(resultado);
		return resultado >= 4;
		
	}
	
	public RegraMapa(){
		this.grafo = new Grafo();
	}


	public Grafo getGrafo() {
		return grafo;
	}


	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}
	
	
	

}
