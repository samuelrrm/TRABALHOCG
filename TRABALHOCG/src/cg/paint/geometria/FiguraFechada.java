package cg.paint.geometria;

import cg.paint.comportamento.Preenchivel;
import cg.paint.pena.Coordenada;

public abstract class FiguraFechada extends Geometria implements Preenchivel {
	private double area;
	private double 	perimetro;
	private Coordenada centroGeometrico;
	
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}
	public Coordenada getCentroGeometrico() {
		return centroGeometrico;
	}
	public void setCentroGeometrico(Coordenada centroGeometrico) {
		this.centroGeometrico = centroGeometrico;
	}
	
	
	
}
