/************************************************************
 * UMA SIMPLES APLICA��O QUE IMPLEMENTA ALGUMAS
 * PRIMITIVAS 2D UTILIZANDO ALGORITMOS CL�SSICOS DEFINIDOS
 * NO LIVRO "COMPUTER GRAPHICS PRINCIPLES AND PRACTICE, SECOND
 * EDITION", CAP. 2, DE FOLEY, VAN DAN, FEINER & HUGHES
 * PARA UTILIZA��O PR�TICA NO CURSO DE COMPUTA��O GR�FICA
 * DO CURSO DE CI�NCIA DA COMPUTA��O - FAESA
 *
 * TIAGO T. WIRTTI
 ************************************************************/

package cg.paint.pena;

import java.io.Serializable;

public abstract class Ponto implements Serializable {
	protected double x, y;

	public Ponto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ponto(double x, double y) {
		super();
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