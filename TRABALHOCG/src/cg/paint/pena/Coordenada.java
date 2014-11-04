package cg.paint.pena;

import java.io.Serializable;

public class Coordenada implements Serializable {
	private double x;
	private double y;
	
	public Coordenada() {
		super();
	}
	public Coordenada(double x, double y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
}
