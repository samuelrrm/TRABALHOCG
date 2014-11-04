package cg.paint.util;

public enum TamanhoPixel {
	PEQUENO(5), MEDIO(8), GRANDE(12);
	
	int value;
	private TamanhoPixel(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
