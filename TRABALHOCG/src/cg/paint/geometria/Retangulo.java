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

package cg.paint.geometria;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

import cg.paint.pena.Caneta;
import cg.paint.pena.Pixel;


public class Retangulo extends PoligonoFechado{

	//	private int x0, y0, x1, y1;

	public Retangulo(int xi, int yi, int xf, int yf){
		// eliminar as pontas (imperfeicoes) do retangulo
		xi = (int)(xi/Pixel.getDim())*Pixel.getDim();
		xf = (int)(xf/Pixel.getDim())*Pixel.getDim();
		yi = (int)(yi/Pixel.getDim())*Pixel.getDim();
		yf = (int)(yf/Pixel.getDim())*Pixel.getDim();
		// atribui os lados do retangulo
		super.getLados().add(new Linha(xi, yi, xf, yi));
		super.getLados().add(new Linha(xf, yi, xf, yf));
		super.getLados().add(new Linha(xf, yf, xi, yf));
		super.getLados().add(new Linha(xi, yf, xi, yi));
		super.defineExtremos();
	}

	Shape shape;

	String label = new String ("Retangulo2D");

	// Mostra as coordenadas da circunferï¿½ncia
	public void exibeTextoCoords(Graphics2D g) {
		//		g.setFont(new Font("SansSerif", Font.PLAIN, 10));      
		//		g.setStroke(new BasicStroke(1.0f));                    
		//		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,    
		//				   RenderingHints.VALUE_ANTIALIAS_ON);
		//
		//	    g.setColor(Color.red);               
		//    	shape =	new Ellipse2D.Float(xi, yi, 2, 2); 
		//    	g.draw(shape);
		//	    g.setColor(Color.black);           
		//    	g.drawString("x0 = "+Integer.toString(xi) + 
		//		             ",y0 = "+Integer.toString(yi), xi, yi);
		//	    g.setColor(Color.red);             
		//    	shape =	new Ellipse2D.Float(xf, yf, 2, 2); 
		//    	g.draw(shape);
		//	    g.setColor(Color.black);           
		//		g.drawString("x1 = "+Integer.toString(xf) + 
		//		             ",y1 = "+Integer.toString(yf) , xf, yf);     
	}

	// Desenha retangulo
	public void desenha(Graphics2D graphics2D, Caneta caneta) {
		// desenho do retangulo
		List <Linha> lados = super.getLados();
		for (Linha lado: lados){
			lado.desenha(graphics2D, caneta);
		}
	}

	// 	@Override
	//	public boolean estaContido(double x, double y) {
	//		// TODO Auto-generated method stub
	// 		int xi = getX0();
	// 		int yi = getY0();
	// 		int xf = getX1();
	// 		int yf = getY1();
	// 		
	//		if(xi <= x && x <= xf && yi <= y && y <= yf){
	//			System.out.println("TRUE:"+xi+","+yi+"|"+xf+","+yf+"|"+x+","+y+"|");
	//			return true;
	//		}
	//		System.out.println("FALSE:"+xi+","+yi+"|"+xf+","+yf+"|"+x+","+y+"|");
	//		return false;
	//	}

//	@Override
//	public void translada(int tx, int ty) {
//		super.translada(tx, ty);
//		//		for (Linha lado : (List<Linha>) getLados()){
//		//			lado.mover(tx, ty);
//		//		}
//	}

	@Override
	public void deformar(double dx, double dy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotacionar(double angulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Retangulo [getLados()=" + getLados() + "]";
	}


}
