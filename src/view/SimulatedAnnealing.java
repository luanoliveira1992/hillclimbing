package view;

import java.util.ArrayList;
import java.util.List;

import controller.RegraMapa;
import controller.Vizinho;
import model.No;

public class SimulatedAnnealing {
	private double temperatura = 10;
	private double decrescimo = 0.1;
	private Vizinho vizinho;
	private RegraMapa mapa;

	public SimulatedAnnealing() {
		this.vizinho = new Vizinho();
		this.mapa = new RegraMapa();
	}

	public static void main(String[] args) {
		SimulatedAnnealing annealing = new SimulatedAnnealing();

		List<No> atual = annealing.retornaAtual();
		List<No> proximo = annealing.vizinho.gerarVizinho(new ArrayList<No>(
				atual));
		for (byte i = 0; i < 2; i++) {
			proximo = annealing.vizinho
					.gerarVizinho(new ArrayList<No>(proximo));
		}
		while (annealing.temperatura > 1.0) {

			Double energiaAtual = annealing.mapa.valorFuncaoSolucao(atual);
			Double energiaProximo = annealing.mapa.valorFuncaoSolucao(proximo);

			if (probabilidadeAceitacao(energiaAtual, energiaProximo,
					annealing.temperatura) > Math.random()) {
				atual = proximo;
			}
			
			for (byte i = 0; i < 3; i++) {
				proximo = annealing.vizinho
						.gerarVizinho(new ArrayList<No>(proximo));
			}
			annealing.temperatura *= 1 - annealing.decrescimo;
			System.out.println("Solução Temporária: ");
			System.out.println(atual+" Valor: "+energiaAtual);
		}
		System.out.println("Solução Final: ");
		System.out.println(atual);

	}

	// Calcula a probabilidade de aceitação
	public static double probabilidadeAceitacao(double energia,
			double novaEnergia, double temperatura) {
		// Se a solução é melhor, logo é aceita
		if (novaEnergia < energia) {
			return 1.0;
		}
		// Se ela é pior, calcula a probabilidade de aceitação
		return Math.exp((energia - novaEnergia) / temperatura);
	}

	public List<No> retornaAtual() {

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

}
