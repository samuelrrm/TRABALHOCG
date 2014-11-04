package cg.paint.util;

public enum TamanhoCaneta {
	PEQUENO(1), MEDIO(3), GRANDE(5);
	
	int tamanho;
	private TamanhoCaneta(int tamanho){
		this.tamanho = tamanho;
	}
	
	public int getTamanho() {
		return tamanho;
	}
}
