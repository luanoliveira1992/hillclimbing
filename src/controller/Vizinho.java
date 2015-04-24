package controller;

import java.util.List;

import model.No;

public class Vizinho {
	/*
	 * A regra de gerar vizinhos de baseia em mudar de posição
	 * dois nos 
	 * */
	public static List<No> gerarVizinho(List<No> atual){
		RegraMapa mapa = new RegraMapa();
		mapa.criarRegra();
		int range = (4 - 1) + 1;
		
		int posicaoMudanca =  (int)(Math.random() * range) + 1;
		List<No> resultado = fazMudanca(atual,posicaoMudanca);
		
		while(!mapa.verificarSolucaoPossivel(resultado)){
			posicaoMudanca =  (int)(Math.random() * range) + 1;
			
		    resultado = fazMudanca(atual,posicaoMudanca);
		}
		return resultado;
	}
	
	private static List<No> fazMudanca(List<No> atual, int mudanca){
		No esquerdo = atual.get(mudanca);
		No direito = atual.get(mudanca-1);
		
		atual.set(mudanca, direito);
		atual.set(mudanca-1, esquerdo);
		
		
		
		
		
		return atual;
	}

}
