package cg.paint.controle;

public class ControleDesenhoQuadrado {
	private static boolean desenhaQuadrado;
	private static boolean obtenPontosQuadrado;

	public static void setDesenhaQuadrado(boolean desenhaQuadrado) {
		ControleDesenhoQuadrado.desenhaQuadrado = desenhaQuadrado;
	}
	public static boolean isDesenhaQuadrado() {
		return desenhaQuadrado;
	}
	public static void setObtenPontosQuadrado(boolean obtenPontosQuadrado) {
		ControleDesenhoQuadrado.obtenPontosQuadrado = obtenPontosQuadrado;
	}
	public static boolean isObtenPontosQuadrado() {
		return obtenPontosQuadrado;
	}

	
}
