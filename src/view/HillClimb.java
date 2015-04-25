package view;

import java.util.ArrayList;
import java.util.List;

import model.No;
import controller.RegraMapa;
import controller.Vizinho;

public class HillClimb {

	private List<No> atual;
	private List<No> proximo;
	private Vizinho vizinho;

	public static void main(String[] args) {
		RegraMapa mapa = new RegraMapa();
		mapa.criarRegra();
		
		HillClimb climp = new HillClimb();
		List<No> nos = new ArrayList<>();
		int contador = 0;
		
		climp.setAtual(climp.retornaAtual());
		
		while(contador < 50){
		  List<No> proximaSolucao = climp.vizinho.gerarVizinho(new ArrayList<>(climp.atual));
		  Double atual = mapa.valorFuncaoSolucao(climp.getAtual());
		  Double proximo = mapa.valorFuncaoSolucao(proximaSolucao);
		  
		  if(atual > proximo){
			climp.setAtual(proximaSolucao);
		  }
		  contador++;
		  
		}
		System.out.println("Solução Final: ");
		System.out.println(climp.getAtual());
	}
	
	public List<No> retornaAtual(){
		
		No A = new No("A");
		No B = new No("B");
		No C = new No("C");
		No D = new No("D");
		No E = new No("E");
		
		List<No> atual = new ArrayList<>();
		
		
		atual.add(C);
		atual.add(B);
		atual.add(A);
		atual.add(D);
		atual.add(E);
		
		
		return atual;
	}

	public HillClimb() {
		this.vizinho = new Vizinho();
	}

	public List<No> getAtual() {
		return atual;
	}

	public void setAtual(List<No> atual) {
		this.atual = atual;
	}

	public List<No> getProximo() {
		return proximo;
	}

	public void setProximo(List<No> proximo) {
		this.proximo = proximo;
	}

}
