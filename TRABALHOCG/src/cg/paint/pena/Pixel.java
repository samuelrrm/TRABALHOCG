package cg.paint.pena;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pixel extends Ponto implements Intensidade{
	
	private static int dim = 15; // Como a classe Rectangle2D.Double sempre representa um pixel a mais no parametro o valor deve ser par, para melhorar a simetria.
	private double xc = x;
	private double yc = y;
	private double xp = xc-(xc%dim); // Pontos iniciais do pixel
	private double yp = yc-(yc%dim); // Os pixels reais são enquadrados dentro dos pixels virtuais.
	
	public Pixel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pixel(double x, double y, int dim) {
		super(x, y);
		this.dim = dim;
	}

	public Pixel(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

/*
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke(1.0f));              
	    g.setColor(Color.blue);
    	Shape shape = new Rectangle2D.Double(xp, yp, dim, dim); 
    	g.draw(shape);
	    g.setColor(Color.red);             
    	shape =	new Ellipse2D.Float((float)(xp-1+(int)dim/2), (float)(yp-1+(int)dim/2), 2.8f, 2.8f); // O -1 é necessário para que o círculo fique no Centro. (definição do ponto inicial)
	    g.draw(shape);
	    g.setColor(Color.black);   
	}
//*/
	
	public void draw(Graphics2D g){
		draw(g, Intensidade.CINZA_125);
	}
	
	public void draw(Graphics2D g, Color intensidade) {
		g.setStroke(new BasicStroke(1.0f));              
	    g.setColor((Color) intensidade);
//    	g.fillRect((int)xp, (int)yp, (int)(dim), (int)(dim));
    	g.fillOval((int)xp, (int)yp, (int)(dim), (int)(dim));
	    g.setColor(Color.black);   
//    	Shape shape = new Rectangle2D.Double(xp, yp, dim, dim);
    	Shape shape = new Ellipse2D.Double(xp, yp, dim, dim);
    	g.draw(shape);
	}

	public static int getDim() {
		return dim;
	}

	public static void setDim(int dim) {
		Pixel.dim = dim;
	}

	public double getXp() {
		return xp;
	}

	public void setXp(double xp) {
		this.xp = xp;
	}

	public double getXc() {
		return xc;
	}

	public void setXc(double xc) {
		this.xc = xc;
	}

	public double getYc() {
		return yc;
	}

	public void setYc(double yc) {
		this.yc = yc;
	}

	public double getYp() {
		return yp;
	}

	public void setYp(double yp) {
		this.yp = yp;
	}

}
