package cg.paint.desenho;

import java.awt.Graphics;
import java.awt.Graphics2D;

import cg.paint.geometria.Circuferencia;
import cg.paint.geometria.Geometria;
import cg.paint.geometria.Linha;
import cg.paint.geometria.Retangulo;
import cg.paint.pena.Caneta;



public class Desenhista {
	
	// CHAMADA MIDPOINT LINE
	public static Geometria desenhaLinha(int x0, int y0, int x1, int y1, Graphics g, Caneta caneta) {
		Geometria linha = new Linha(x0, y0, x1, y1);
		linha.desenha((Graphics2D)g, caneta);
//		linha.drawCoords((Graphics2D)g);
		return linha;
}

 	// CHAMADA RETANGULO
    public static Geometria desenhaRetangulo(int x0, int y0, int x1, int y1, Graphics g, Caneta caneta) {
		Geometria retangulo= new Retangulo(x0, y0, x1, y1);
		retangulo.desenha((Graphics2D)g, caneta);
//		retangulo.drawCoords((Graphics2D)g);
		return retangulo;
    }    
    
	// MIDPOINT CIRCLE
    public static Geometria desenhaCircunferencia(int x0, int y0, int x1, int y1, Graphics g, Caneta caneta) {
		Geometria circunferencia= new Circuferencia(x0, y0, x1, y1);
		circunferencia.desenha((Graphics2D)g, caneta);
//		circunferencia.drawCoords((Graphics2D)g);
    	return circunferencia;
    }

	public static void desenhaPoligono(){
		
	}
	
	public static void preencheCircunferencia(){
		
	}
	
	public static void preencheRetangulo(){
		
	}
	
	public static void preenchePoligono(){
		
	}

}
