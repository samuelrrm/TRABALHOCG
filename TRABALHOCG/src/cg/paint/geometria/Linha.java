/************************************************************
 * UMA SIMPLES APLICACAO QUE IMPLEMENTA ALGUMAS
 * PRIMITIVAS 2D UTILIZANDO ALGORITMOS CLASSICOS DEFINIDOS
 * NO LIVRO "COMPUTER GRAPHICS PRINCIPLES AND PRACTICE, SECOND
 * EDITION", CAP. 2, DE FOLEY, VAN DAN, FEINER & HUGHES
 * PARA UTILIZAÇÃO PRATICA NO CURSO DE COMPUTACAO GRAFICA
 * DO CURSO DE CIENCIA DA COMPUTACAO - FAESA
 *
 * TIAGO T. WIRTTI
 ************************************************************/

/*
 * Construcao de linha usando o algoritmo MidPointLine
 */
package cg.paint.geometria;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import cg.paint.pena.Caneta;
import cg.paint.pena.Pixel;


public class Linha extends Geometria {

	private int x0, y0, x1, y1, xaux, yaux;

	public Linha(int x0, int y0, int x1, int y1){
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;	
		this.y1 = y1;	
		this.xaux = x0;
		this.yaux = y0;
	}
	Shape shape;

	// Mostra as coordenadas da linha
	public void exibeTextoCoords(Graphics2D g) {
		g.setFont(new Font("SansSerif", Font.PLAIN, 10));
		g.setStroke(new BasicStroke(1.0f));              
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.red);             
		shape =	new Ellipse2D.Float(x0 , y0 , 2, 2); 
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


	// REPRESENTACAO DAS REGIOES
	// ATENCAO: X cresce da esquerda para a direita
	//          Y cresce de cima para baixo
	/*            
	 *       ******* X
	 *       *                         *
	 *       *                         *
	 *       *               (3)       *      (2)                             
	 *              *  			       *  			        *
	 *       Y         *  	           *  	             *
	 *                   *             *              *
	 *                      *  	       *  	       *
	 *              (4)       *        *        *        (1)
	 *                           *     *     *
	 *                              *  *  *
	 *           **********************************************
	 *                              *  *  * 
	 *                           *     *     *
	 *              (5)       *        *        *        (8) 
	 *                     *           *           *
	 *                  *              *              *
	 *               *                 *                 *
	 *            *                    *                    *
	 *                      (6)        *       (7)
	 *                                 *
	 *                                 *
	 *                                 *
	 */

	// metodo que desenha as retas em todas as regioes
	public void desenha(Graphics2D graphics2D, Caneta caneta) {
		int dxAux = x1 - x0;
		int dyAux = y1 - y0;
		//	    System.out.println("ENTROU????? +++++++++++++++++++++++++++++======================>>>>");
		if (dxAux == 0) { // linha vertical ...
			drawV(graphics2D, caneta);
		}
		else if (dyAux == 0) { // linha horizontal ...
			drawH(graphics2D, caneta);
		}
		else if (dxAux > 0) {       		// (1) , (2) , (7) , (8)
			if (dyAux > 0) {   		      // (7) , (8)
				if (Math.abs(dxAux) > Math.abs(dyAux)) { // (8)
					// regiao (8) aqui
					draw8(graphics2D, caneta);
					//						System.out.println("draw8()");
				}
				else{        						     // (7)
					// regiao (7) aqui
					draw7(graphics2D, caneta);
					//						System.out.println("draw7()");
				}
			}
			else{ // dy < 0			  	  // (1) , (2)
				if (Math.abs(dxAux) > Math.abs(dyAux)) { // (1)
					// regiao (1) aqui
					draw1(graphics2D, caneta);
					//						System.out.println("draw1()");
				}
				else{        				  		     // (2)
					// regiao (2) aqui
					draw2(graphics2D, caneta); 
					//						System.out.println("draw2()");
				}
			}
		} 
		else {  // dx < 0           // (3) , (4) , (5) , (6)
			if (dyAux > 0) {   			  // (5) , (6)
				if (Math.abs(dxAux) > Math.abs(dyAux)) { // (5)
					// regiao (5) aqui
					draw5(graphics2D, caneta);
					//						System.out.println("draw5()");
				}
				else{        						     // (6)
					// regiao (6) aqui
					draw6(graphics2D, caneta);
					//						System.out.println("draw6()");
				}
			}
			else{ // dy < 0 		// (3) , (4)
				if (Math.abs(dxAux) > Math.abs(dyAux)) { // (4) 				
					// regiao (4) aqui
					draw4(graphics2D, caneta);
					//						System.out.println("draw4()");
				}
				else{        						     // (3)
					// regiao (3) aqui
					draw3(graphics2D, caneta);
					//						System.out.println("draw3()");
				}
			}
		}		
	}

	private void drawH(Graphics2D g, Caneta caneta){ // linha horizontal
		//		System.out.println(" DRAWH");
		int x = x0;

		// teste: da esquerda para a direita???
		if (x0 < x1){
			// desenha a ponta da caneta
			g.setColor(Color.blue);     
			Pixel pixelCentro = new Pixel(x, y0);
			caneta.plota(g, pixelCentro);

			while (x < x1) {
				x += Pixel.getDim();	
				g.setColor(Color.blue); 
				// desenha a ponta da caneta
				pixelCentro = new Pixel(x, y0);
				caneta.plota(g, pixelCentro);
			}   	   
			g.drawLine(x0, y0, x, y0);              
		}
		else { // da direita para a esquerda...
			// desenha a ponta da caneta
			g.setColor(Color.blue);     
			Pixel pixelCentro = new Pixel(x, y0);
			caneta.plota(g, pixelCentro);

			while (x > x1) {
				x -= Pixel.getDim();	
				g.setColor(Color.blue); 
				// desenha a ponta da caneta
				pixelCentro = new Pixel(x, y0);
				caneta.plota(g, pixelCentro);
			}   	   
			//		    g.drawLine(x, y0, x0, y0);              
		}	    
	}

	private void drawV(Graphics2D g, Caneta caneta){ // linha horizontal
		//		System.out.println(" DRAWV");
		int y = y0;

		// teste: da esquerda para a direita???
		if (y0 > y1){
			// desenha a ponta da caneta
			g.setColor(Color.blue);     
			Pixel pixelCentro = new Pixel(x0, y);
			caneta.plota(g, pixelCentro);

			while (y > y1) {
				y -= Pixel.getDim();	
				g.setColor(Color.blue);     
				pixelCentro = new Pixel(x0, y);
				caneta.plota(g, pixelCentro);
			}   	   
			g.drawLine(x0, y0, x0, y);              
		}
		else { // da direita para a esquerda...
			// desenha a ponta da caneta
			g.setColor(Color.blue);     
			Pixel pixelCentro = new Pixel(x0, y);
			caneta.plota(g, pixelCentro);

			while (y < y1) {
				y += Pixel.getDim();	
				g.setColor(Color.blue); 
				// desenha a ponta da caneta
				pixelCentro = new Pixel(x0, y);
				caneta.plota(g, pixelCentro);
			}   	   
			//		    g.drawLine(x0, y0, x0, y);              
		}	    
	}

	// MidpointLine para regiï¿½o 1
	private void draw1(Graphics2D graphics2D, Caneta caneta) {
		//		System.out.println(" DRAW1");
		int dx		= x1 - x0;
		int dy		= y1 - y0;
		int d		= Math.abs(-2*dy - dx);
		int incrPA	= -2*dy;
		int incrPB	= 2*(-dy - dx);
		int x = x0;
		int y = y0;

		// desenha a ponta da caneta
		graphics2D.setColor(Color.blue);     
		Pixel pixelCentro = new Pixel(x, y);
		caneta.plota(graphics2D, pixelCentro);

		while (x < x1) {
			if (d <= 0)	{
				d += incrPA;
				x += Pixel.getDim();	
			}
			else {
				d += incrPB;
				x += Pixel.getDim();	
				y -= Pixel.getDim();    				
			}
			graphics2D.setColor(Color.blue); 
			// desenha a ponta da caneta
			pixelCentro = new Pixel(x, y);
			caneta.plota(graphics2D, pixelCentro);
		}   	   
		//	    graphics2D.drawLine(x0, y0, x1, y1);              
	}

	// MidpointLine para regiï¿½o 2
	private void draw2(Graphics2D graphics2D, Caneta caneta) {
		int dx		= y1 - y0;
		int dy		= x1 - x0;
		int d		= -2*dy - dx;
		int incrPA	= -2*dy;
		int incrPB	= 2*(-dy-dx);
		int x = x0;
		int y = y0;
		// representa o pixel ...	
		graphics2D.setColor(Color.blue);               
		Pixel pixelCentro = new Pixel(x, y);
		caneta.plota(graphics2D, pixelCentro);
		while (x < x1){
			xaux = x; // para utilizar o drawLine
			yaux = y; // para utilizar o drawLine
			if (d > 0){
				d += incrPA;
				y -= Pixel.getDim();    				
			}
			else {
				d += incrPB;
				y -= Pixel.getDim();    				
				x += Pixel.getDim();
			}
			graphics2D.setColor(Color.blue); 
			pixelCentro = new Pixel(x, y);
			caneta.plota(graphics2D, pixelCentro);
		}
		//	    graphics2D.drawLine(x0, y0, x1, y1);              
	}
	// MidpointLine para regiï¿½o 3
	private void draw3(Graphics2D graphics2D, Caneta caneta){
		int dx		= y1 - y0;
		int dy		= x1 - x0;
		int d		= -2*dy + dx;
		int incrPA	= -2*dy;
		int incrPB	= 2*(-dy + dx);
		int x = x0;
		int y = y0;
		// representa o pixel ...	
		graphics2D.setColor(Color.blue);               
		Pixel pixelCentro = new Pixel(x, y);
		caneta.plota(graphics2D, pixelCentro);
		while (x > x1) {
			xaux = x; // para utilizar o drawLine
			yaux = y; // para utilizar o drawLine
			if (d <= 0)	{
				d += incrPA;
				y -= Pixel.getDim();	
			}
			else {
				d += incrPB;
				y -= Pixel.getDim();
				x -= Pixel.getDim();    				
			}
			graphics2D.setColor(Color.blue); 
			pixelCentro = new Pixel(x, y);
			caneta.plota(graphics2D, pixelCentro);
		}   	      	    	 	   
		//	    graphics2D.drawLine(x0, y0, x1, y1);              
	}


	// MidpointLine para regiï¿½o 4
	private void draw4(Graphics2D graphics2D, Caneta caneta) {
		int dx		= x1 - x0;
		int dy		= y1 - y0;
		int d		= - 2*dy + dx;
		int incrPA	= - 2*dy;
		int incrPB	= 2*(- dy + dx);
		int x = x0;
		int y = y0;

		// representa o pixel ...	
		graphics2D.setColor(Color.blue);               
		Pixel pixelCentro = new Pixel(x, y);
		caneta.plota(graphics2D, pixelCentro);

		while (x > x1) {
			xaux = x; // para utilizar o drawLine
			yaux = y; // para utilizar o drawLine
			if (d <= 0)	{
				d += incrPA;
				x -= Pixel.getDim();	
			}
			else {
				d += incrPB;
				x -= Pixel.getDim();
				y -= Pixel.getDim();    				
			}
			graphics2D.setColor(Color.blue); 
			pixelCentro = new Pixel(x, y);
			caneta.plota(graphics2D, pixelCentro);
		}   	   
		//	    graphics2D.drawLine(x0, y0, x1, y1);              
	}

	// MidpointLine para regiï¿½o 5
	private void draw5(Graphics2D graphics2D, Caneta caneta) {
		int dx		= x1 - x0;
		int dy		= y1 - y0;
		int d		= 2*dy + dx;
		int incrPA	= 2*dy;
		int incrPB	= 2*(dy + dx);
		int x = x0;
		int y = y0;

		// representa o pixel ...	
		graphics2D.setColor(Color.blue);               
		Pixel pixelCentro = new Pixel(x, y);
		caneta.plota(graphics2D, pixelCentro);

		while (x > x1) {
			xaux = x; // para utilizar o drawLine
			yaux = y; // para utilizar o drawLine
			if (d <= 0)	{
				d += incrPA;
				x -= Pixel.getDim();	
			}
			else {
				d += incrPB;
				x -= Pixel.getDim();
				y += Pixel.getDim();    				
			}
			graphics2D.setColor(Color.blue); 
			pixelCentro = new Pixel(x, y);
			caneta.plota(graphics2D, pixelCentro);
		}   	      	    		   
		//	    graphics2D.drawLine(x0, y0, x1, y1);              
	}    

	// MidpointLine para regiï¿½o 6
	private void draw6(Graphics2D graphics2D, Caneta caneta) {
		int dx		= y1 - y0;
		int dy		= x1 - x0;
		int d		= 2*dy + dx;
		int incrPA	= 2*dy;
		int incrPB	= 2*(dy + dx);
		int x = x0;
		int y = y0;

		// representa o pixel ...	
		graphics2D.setColor(Color.blue);               
		Pixel pixelCentro = new Pixel(x, y);
		caneta.plota(graphics2D, pixelCentro);

		while (x > x1) {
			xaux = x; // para utilizar o drawLine
			yaux = y; // para utilizar o drawLine
			if (d <= 0)	{
				d += incrPB;
				x -= Pixel.getDim();
				y += Pixel.getDim();    				
			}
			else {
				d += incrPA;
				y += Pixel.getDim();    				
			}
			graphics2D.setColor(Color.blue); 
			pixelCentro = new Pixel(x, y);
			caneta.plota(graphics2D, pixelCentro);
		}   	      	    		   
		//	    graphics2D.drawLine(x0, y0, x1, y1);              
	}    


	// MidpointLine para regiï¿½o 7
	private void draw7(Graphics2D graphics2D, Caneta caneta) {
		int dx		= y1 - y0;
		int dy		= x1 - x0;
		int d		= 2*dy - dx;
		int incrPA	= 2*dy;
		int incrPB	= 2*(dy - dx);
		int x = x0;
		int y = y0;

		// representa o pixel ...	
		graphics2D.setColor(Color.blue);               
		Pixel pixelCentro = new Pixel(x, y);
		caneta.plota(graphics2D, pixelCentro);

		while (x < x1) {
			xaux = x; // para utilizar o drawLine
			yaux = y; // para utilizar o drawLine
			if (d <= 0)	{
				d += incrPA;
				y += Pixel.getDim();	
			}
			else {
				d += incrPB;
				y += Pixel.getDim();
				x += Pixel.getDim();    				
			}
			graphics2D.setColor(Color.blue); 
			pixelCentro = new Pixel(x, y);
			caneta.plota(graphics2D, pixelCentro);
		}   	      	    	 	   
		//	    graphics2D.drawLine(x0, y0, x1, y1);              
	}

	// MidpointLine para regiï¿½o 8
	private void draw8(Graphics2D graphics2D, Caneta caneta) {
		int dx		= x1 - x0;
		int dy		= y1 - y0;
		int d		= 2*dy - dx; // a + 1/2 (b)
		int incrPA	= 2*dy;   // a = dy
		int incrPB	= 2*(dy - dx); // a + b = dy - dx
		int x = x0;
		int y = y0;

		// representa o pixel ...	
		//g.setColor(Color.blue);               
		Pixel pixelCentro = new Pixel(x, y);
		caneta.plota(graphics2D, pixelCentro);

		while (x < x1) {
			xaux = x; // para utilizar o drawLine
			yaux = y; // para utilizar o drawLine
			if (d <= 0)	{
				d += incrPA;
				x += Pixel.getDim();
			}
			else {
				d += incrPB;
				x += Pixel.getDim();
				y += Pixel.getDim();    				
			}
			//g.setColor(Color.blue); 
			pixelCentro = new Pixel(x, y);
			caneta.plota(graphics2D, pixelCentro);
		}   	   
		//	    graphics2D.drawLine(x0, y0, x1, y1);
	}

	public int getXIni(){
		return x0;
	}

	public int getYIni(){
		return y0;
	}

	public int getXFim(){
		return x1;
	}

	public int getYFim(){
		return y1;
	}

	//    @Override
	//	public boolean estaContido(double x, double y) {
	//		double max = Math.max(y0, y1);
	//		double min = Math.min(y0, y1);
	////		if (y <= max && y >= min && (x0+((x1-x0)/(y1-y0))*(y-y0))==x){
	////			System.out.println("TRUE:"+x0+","+y0+"|"+x1+","+y1+"|"+x+","+y+"|");
	////			return true;
	////		}
	//		double eq=((y1-y0)*(x-x0))/((y-y0)*(x1-x0));
	//		if (y <= max && y >= min && (eq>=0.8 && eq <=1.2)){
	//			System.out.println("TRUE:"+x0+","+y0+"|"+x1+","+y1+"|"+x+","+y+"|"+eq);
	//			return true;
	//		}
	//		System.out.println("FALSE:"+x0+","+y0+"|"+x1+","+y1+"|"+x+","+y+"|"+eq);
	//		return false;
	//	}

	@Override
	public boolean estaContido(double x, double y) {
		double a = y0 - y1;
		double b = x1 - x0;
		double c = x0*y1 - x1*y0;
		double d = Math.abs(a*x+b*y+c)/Math.sqrt(a*a + b*b);
		System.out.println("d ===========> "+d);
		boolean flag = false;
		if (d <= 20){
			flag = true;
			System.out.println(flag);
			return flag;
		}
		System.out.println(flag);
		return flag;
	}


	@Override
	public void translada(int tx, int ty) {
		this.x0 += tx;
		this.x1 += tx;
		this.y0 += ty;
		this.y1 += ty;
	}


	@Override
	public void deformar(double dx, double dy) {
		// TODO Auto-generated method stub
		this.x0 *= dx;
		this.x1 *= dx;
		this.y0 *= dy;
		this.y1 *= dy;		
	}


	@Override
	public void rotacionar(double angulo) {
		// TODO Auto-generated method stub

	}


	@Override
	public String toString() {
		return "Linha [x0=" + x0 + ", x1=" + x1 + ", y0=" + y0 + ", y1=" + y1
		+ "]";
	}



}
