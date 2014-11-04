package cg.paint.geometria;

import cg.paint.pena.Coordenada;

public abstract class Conica extends FiguraFechada {
	private Coordenada centro;
	
	public abstract double calculaExcentricidade();

	public Coordenada getCentro() {
		return centro;
	}

	public void setCentro(Coordenada centro) {
		this.centro = centro;
	}
	
}
