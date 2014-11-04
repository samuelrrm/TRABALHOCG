package cg.paint.controle;

public class ControlePreenche{
	private static boolean preencheHabilitado = false;

	public static boolean isPreencheHabilitado() {
		return preencheHabilitado;
	}

	public static void setPreencheHabilitado(boolean preencheHabilitado) {
		ControlePreenche.preencheHabilitado = preencheHabilitado;
	}
}
