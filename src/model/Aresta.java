package model;

public class Aresta {
	private No pontoEsquerdo;
	private No pontoDireito;
	private Double peso;
	
	public Aresta(){
		
	}
    public Aresta(No pontoEsquerdo, No pontoDireito, Double peso){
    	this.pontoDireito = pontoDireito;
    	this.pontoEsquerdo = pontoEsquerdo;
    	this.peso = peso;
    }
	public No getPontoEsquerdo() {
		return pontoEsquerdo;
	}

	public void setPontoEsquerdo(No pontoEsquerdo) {
		this.pontoEsquerdo = pontoEsquerdo;
	}

	public No getPontoDireito() {
		return pontoDireito;
	}

	public void setPontoDireito(No pontoDireito) {
		this.pontoDireito = pontoDireito;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
