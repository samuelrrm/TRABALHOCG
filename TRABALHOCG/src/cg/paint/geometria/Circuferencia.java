/************************************************************
 * UMA SIMPLES APLICAï¿½ï¿½O QUE IMPLEMENTA ALGUMAS
 * PRIMITIVAS 2D UTILIZANDO ALGORITMOS CLï¿½SSICOS DEFINIDOS
 * NO LIVRO "COMPUTER GRAPHICS PRINCIPLES AND PRACTICE, SECOND
 * EDITION", CAP. 2, DE FOLEY, VAN DAN, FEINER & HUGHES
 * PARA UTILIZAï¿½ï¿½O PRï¿½TICA NO CURSO DE COMPUTAï¿½ï¿½O GRï¿½FICA
 * DO CURSO DE CIï¿½NCIA DA COMPUTAï¿½ï¿½O - FAESA
 *
 * TIAGO T. WIRTTI
 ************************************************************/

/*
 * Construï¿½ï¿½o de circunferï¿½ncia usando o algoritmo MidPointCircle
 */
 
package cg.paint.geometria;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import cg.paint.pena.Caneta;
import cg.paint.pena.Pixel;

// deve mudar para estender a Elipse
public class Circuferencia extends Conica {
	
	private int x0, y0, x1, y1;
	private double raio;

    Shape shape;

    String label = new String ("Circle2D");
	
    // construtor
	public Circuferencia(int xc, int yc, int xf, int yf){
		x0 = xc;
		y0 = yc;
		x1 = xf;	
		y1 = yf;	
		raio = Math.sqrt((x1-x0)*(x1-x0) + (y1-y0)*(y1-y0));
		
	}

	// metodo que aproveita a simetria da circunferencia 
	// para replicar os pontos do primeiro octante
	private void circlePoints(int xf, int yf, Graphics2D g, Caneta caneta){
	    g.setColor(Color.blue);
	    // 1o octante
	    Pixel pix1 = new Pixel(+xf + x0, +yf + y0);
	    caneta.plota(g, pix1);
	    // 2o octante
	    Pixel pix2 = new Pixel(+yf + x0, +xf + y0);
	    caneta.plota(g, pix2);
	    // 3o octante
	    Pixel pix3 = new Pixel(+xf + x0, -yf + y0);
	    caneta.plota(g, pix3);
	    // 4o octante
	    Pixel pix4 = new Pixel(-yf + x0, +xf + y0);
	    caneta.plota(g, pix4);
	    // 5o octante
	    Pixel pix5 = new Pixel(-xf + x0, +yf + y0);
	    caneta.plota(g, pix5);
	    // 6o octante
	    Pixel pix6 = new Pixel(+yf + x0, -xf + y0);
	    caneta.plota(g, pix6);
	    // 7o octante
	    Pixel pix7 = new Pixel(-xf + x0, -yf + y0);
	    caneta.plota(g, pix7);
	    // 8o octante
	    Pixel pix8 = new Pixel(-yf + x0, -xf + y0);
	    caneta.plota(g, pix8);
	}
	
    // Mostra as coordenadas da circunferencia
    public void exibeTextoCoords(Graphics2D g) {
		g.setFont(new Font("SansSerif", Font.PLAIN, 10));      
		g.setStroke(new BasicStroke(1.0f));                    
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,    
				   RenderingHints.VALUE_ANTIALIAS_ON);

	    g.setColor(Color.red);               
    	shape =	new Ellipse2D.Float(x0, y0, 2, 2); 
    	g.draw(shape);
	    g.setColor(Color.black);           
    	g.drawString("x0 = "+Integer.toString(x0) + 
		             ",y0 = "+Integer.toString(y0), x0, y0);
	    g.setColor(Color.red);             
    	shape =	new Ellipse2D.Float(x1, y1, 2, 2); 
    	g.draw(shape);
	    g.setColor(Color.black);           
		g.drawString("x1 = "+Integer.toString(x1) + 
		             ",y1 = "+Integer.toString(y1) , x1, y1);     
	}

///*
	// MidpointCircle algoritmo de primeira ordem
    public void desenha(Graphics2D g, Caneta caneta) {
		int x		= 0;
	    int y		= (int)raio;
	    int d		= (int)(1 - raio);

	    // centro
	    g.setColor(Color.red);               
    	shape =	new Ellipse2D.Float(x0, y0, 2, 2); 
    	g.draw(shape);
	    
		// representa o pixel ...	
		circlePoints(x, y, g, caneta);	    	
    	while (y>x) {
    		if (d <= 0)	{
    			d += 2*x+3;
				x += Pixel.getDim();	
    		}
    		else {
    			d += 2*(x-y)+5;
    			y -= Pixel.getDim();    				
				x += Pixel.getDim();	
    		}
			circlePoints(x, y, g, caneta);	    	
    	}   	   
         	
    }
//*/

  	// MidpointCircle com diferecas de segunda ordem 
    // (MAIS EFICIENTE... POIS NAO USA MULTIPLICACOES, APEMAS SOMAS
/*
      public void draw(Graphics2D g) {
      	long ti = System.nanoTime();
		g.drawString("tempo inicio = "+ti,  x1, y1 +20);           	
		int x		= 0;
	    int y		= (int)raio;
	    int d		= (int)(1 - raio);
	    int deltaA  = 3;   // substituindo xp = 0 em 2*xp + 3
	    int deltaB  = (int)(-2*raio + 5); // substituindo xp = 0 e yp = raio em 2*xp - 2*yp + 5

		// representa o pixel ...	
		circlePoints(x, y, g);	    	
    	while (y>x) {
    		if (d <= 0)	{ // selecionou A
    			d += deltaA;
    			deltaA += 2;
    			deltaB += 2;
				x++;	
    		}
    		else {        // selecionou B
    			d += deltaB;
    			deltaA += 2;
    			deltaB += 4;
    			y--;    				
				x++;	
    		}
			circlePoints(x, y, g);	    	
    	}   	   
      	long tf = System.nanoTime();
		g.drawString("tempo final = "+tf,  x1, y1 + 40);           	
		long dif = tf - ti;
		g.drawString("diferenca = "+dif,  x1, y1 + 60);           	
    }
// */ 
    
 	@Override
	public boolean estaContido(double x, double y) {
 			
 		return false;

	}

	@Override
	public double calculaExcentricidade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void preenche(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void translada(int tx, int ty) {
		this.x0+=tx;
		this.x1+=tx;
		this.y0+=ty;
		this.y1+=ty;
	}
	
	@Override
	public void deformar(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotacionar(double angulo) {
		// TODO Auto-generated method stub
		// Não faz sentido rotacionar a circunferencia
	}

	@Override
	public String toString() {
		return "Circuferencia [raio=" + raio + ", x0=" + x0 + ", y0=" + y0
				+ "]";
	}


}
