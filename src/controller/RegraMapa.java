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
		
		byte resultado = 0;
		byte tamanhoSolucao = (byte) solucao.size();
		byte tamanhoGrafo = (byte) this.getGrafo().getArestas().size();
		for (byte i=1;i < tamanhoSolucao;i++) {
			for(byte j =0; j < tamanhoGrafo; j++){
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
		return resultado >= 4;
		
	}
	
	public Double valorFuncaoSolucao(List<No> solucao){

		List<String> resultadosVisto = new ArrayList<>();
		Double resultado = 0d;
		byte tamanhoSolucao = (byte) solucao.size();
		byte tamanhoGrafo = (byte) this.getGrafo().getArestas().size();
		for (byte i=1;i < tamanhoSolucao;i++) {
			for(byte j =0; j < tamanhoGrafo; j++){
				
				String primeira = solucao.get(i-1).getDescricao();
				String segunda = solucao.get(i).getDescricao();
				
				if(solucao.get(i-1).getDescricao().equals(this.getGrafo().getArestas().get(j).getPontoEsquerdo().getDescricao())){
					if(solucao.get(i).getDescricao().equals(this.getGrafo().getArestas().get(j).getPontoDireito().getDescricao())){
						 if(this.alteraValorResultado(solucao.get(i-1).getDescricao(), solucao.get(i).getDescricao(),resultadosVisto)){
							 resultadosVisto.add(primeira+segunda);
						     resultadosVisto.add(segunda+primeira);
						     resultado+= this.getGrafo().getArestas().get(j).getPeso();
						 }
					}
				}
				
				if(solucao.get(i-1).getDescricao().equals(this.getGrafo().getArestas().get(j).getPontoDireito().getDescricao())){
					 if(solucao.get(i).getDescricao().equals(this.getGrafo().getArestas().get(j).getPontoEsquerdo().getDescricao())){
						if(this.alteraValorResultado(solucao.get(i-1).getDescricao(), solucao.get(i).getDescricao(),resultadosVisto)){
						  resultadosVisto.add(primeira+segunda);
						  resultadosVisto.add(segunda+primeira);
						  resultado+= this.getGrafo().getArestas().get(j).getPeso();
						}
					 }
				}
				
			}
		}
		return resultado;
	}
	
	public boolean alteraValorResultado(String primeira, String segunda, List<String> resultadosVisto){
		 String valorAtual = segunda+primeira;
		 Boolean valor = resultadosVisto.contains(valorAtual);
		 if(!valor){
			return true;
		 }
		 return false;
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
