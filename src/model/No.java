package model;

public class No {
	private String descricao;

	public No(){
		
	}
    public No(String descricao){
		this.descricao = descricao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "No [descricao=" + descricao + "]";
	}
	
	
	
	
	

}
