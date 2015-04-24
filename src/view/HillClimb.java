package view;

import java.util.ArrayList;
import java.util.List;

import model.No;
import controller.RegraMapa;

public class HillClimb {
	private RegraMapa mapa;
	
	
	public static void main(String[] args) {
		HillClimb climp = new HillClimb();
		List<No> nos = new ArrayList<>();
		
		climp.mapa.criarRegra();
		
		No A = new No("A");
		No B = new No("B");
		No C = new No("C");
		No D = new No("D");
		No E = new No("E");
		
		nos.add(0, C);
		nos.add(1, B);
		nos.add(2, A);
		nos.add(3, D);
		nos.add(4, E);
		
		 boolean resultado = climp.mapa.verificarSolucaoPossivel(nos);
		 System.out.println(resultado);
		
	}
	
	public HillClimb(){
		this.mapa = new RegraMapa();
	}

	public RegraMapa getMapa() {
		return mapa;
	}

	public void setMapa(RegraMapa mapa) {
		this.mapa = mapa;
	}
	
	

}
