package cg.paint.controle;

import cg.paint.comportamento.Transforma;

public class ControleTransforma {
	private static boolean transforma = false;
	private static Transforma operacao = null;
	
	public static boolean isTransforma() {
		return transforma;
	}
	public static void setTransforma(boolean transforma) {
		ControleTransforma.transforma = transforma;
	}
	public static Transforma getOperacao() {
		return operacao;
	}
	public static void setOperacao(Transforma operacao) {
		ControleTransforma.operacao = operacao;
	}
	

}
