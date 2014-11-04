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
 * Construï¿½ï¿½o de retangulo usando o algoritmo scanline
 */
 
package cg.paint.geometria;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import cg.paint.pena.Caneta;
import cg.paint.pena.Ponto;
import cg.paint.pena.PontoInterseccao;
import cg.paint.util.PontoComparator;
import cg.paint.util.PontoComparatorPreenche;


public class PoligonoFechado extends FiguraFechada{
	private int x0, y0, x1, y1;
	private boolean preenche;
	private List <Linha> poligono = new ArrayList<Linha>(); //<- ?????
	
	public PoligonoFechado(){
		this.preenche=false;
	}

	public void defineExtremos(){ // define x, y maximos e minimos
		double x_min = 1000000, x_min_novo = 1000000;
		double y_min = 1000000, y_min_novo = 1000000;
		double x_max = 0, x_max_novo = 0;
		double y_max = 0, y_max_novo = 0;
		for (Linha lado : poligono){
			x_min_novo = Math.max(lado.getXIni(), lado.getXFim());
			y_min_novo = Math.max(lado.getYIni(), lado.getYFim());
			x_max_novo = Math.max(lado.getXIni(), lado.getXFim());
			y_max_novo = Math.max(lado.getYIni(), lado.getYFim());
			if (y_min_novo < y_min){
				y_min = y_min_novo;
			}
			if (x_min_novo < x_min){
				x_min = x_min_novo;
			}
			if (y_max_novo > y_max){
				y_max = y_max_novo;
			}
			if (x_max_novo > x_max){
				x_max = x_max_novo;
			}
		}		
		this.x0 = (int) x_min;
		this.y0 = (int) y_min;
		this.x1 = (int) x_max;
		this.y1 = (int) y_max;
	}
    Shape shape;

    String label = new String ("Retangulo2D");
    
    @Override
	public void exibeTextoCoords(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

    public void desenha(Graphics2D graphics2D, Caneta caneta) { // desenho sem preenchimento
 		this.desenha(graphics2D, caneta, false);
    }
    
    public void desenha(Graphics2D graphics2D, Caneta caneta, boolean preencher) {
 		ListIterator it = poligono.listIterator();
		while (it.hasNext()){
			Linha lado = (Linha)it.next();
			lado.desenha(graphics2D, caneta);
			if(preencher)
				lado.desenha(graphics2D, caneta);
		}
		if(this.preenche)
			this.preenche((Graphics)graphics2D);
    }
	
    private void setLadoPoligono(int xi, int yi, int xf, int yf, Caneta caneta){
		poligono.add(new Linha(xi, yi, xf, yf));
	}

	// Esta funcao desenha do poligono atravez de um objeto da classe Polygon
    public void desenhaLadoPoligono(int xi, int yi, int xf, int yf, Caneta caneta, Graphics g){
    	System.out.println(" xi = " + xi + ", yi = " + yi + " -- xf = " + xf + ", yf = " + yf);
		Geometria linha = new Linha(xi, yi, xf, yf);
		linha.desenha((Graphics2D) g, caneta);
		setLadoPoligono(xi, yi, xf, yf, caneta);
    }
	
	public List getLados() {
		return poligono;
	}

	public void setLados(List poligono) {
		this.poligono = poligono;
	}
	
	public boolean estaContido(double x, double k) {
		// TODO Auto-generated method stub
		List <Ponto> interseccao = new ArrayList <Ponto> ();
		for (Linha lado : poligono){
			double x0,y0,x1,y1;
			double max = Math.max(lado.getYIni(), lado.getYFim());
			double min = Math.min(lado.getYIni(), lado.getYFim());
			if (k <= max && k > min){
				x0=lado.getXIni();
				x1=lado.getXFim();
				y0=lado.getYIni();
				y1=lado.getYFim();
				double xi = (x0+((x1-x0)/(y1-y0))*(k-y0));
				interseccao.add(new PontoInterseccao(xi, k));
			}
		}
		Collections.sort(interseccao, new PontoComparator());
		boolean flag = false;
		for (int i = 0; i < interseccao.size(); i ++){
			System.out.println("XX = "+interseccao.get(i).getX());
			if (i % 2 == 0 && interseccao.get(i).getX() <= x 
					       && interseccao.get(i+1).getX() >= x ){
				System.out.println("x0 = "+interseccao.get(i).getX()+", x1 = "+interseccao.get(i+1).getX());
				flag = true;
				System.out.println("Achou...");
				break;
			}
		}
		return flag;
	}

	@Override
	public String toString() {
		return "PoligonoFechado [poligono=" + poligono + "]";
	}

	public void preenche(Graphics g) {
		// eh possivel aproveitar o codigo acima
	}

	@Override
	public void translada(int tx, int ty) {
 		ListIterator it = poligono.listIterator();
		while (it.hasNext()){
			Linha lado = (Linha)it.next();
			lado.translada(tx, ty);
//			lado.x0=lado.x0+tx;		// mau uso
//			lado.x1=lado.x1+tx;
//			lado.y0=lado.y0+ty;
//			lado.y1=lado.y1+ty;
		}
	}

	@Override
	public void deformar(double dx, double dy) {
		// TODO Auto-generated method stub
		ListIterator it = poligono.listIterator();
		while (it.hasNext()){
			Linha lado = (Linha)it.next();
			lado.deformar(dx, dy);
		}
	}

	@Override
	public void rotacionar(double angulo) {
		// TODO Auto-generated method stub
		
	}

	
	public int getX0() {
		return x0;
	}

	public int getY0() {
		return y0;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}


}