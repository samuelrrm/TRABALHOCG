package cg.paint.controle;

public class ControleSeleciona {
	private static boolean selecaoHabilitada = false;

	public static boolean isSelecaoHabilitada() {
		return selecaoHabilitada;
	}

	public static void setSelecaoHabilitada(boolean selecaoHabilitada) {
		ControleSeleciona.selecaoHabilitada = selecaoHabilitada;
	}
}
