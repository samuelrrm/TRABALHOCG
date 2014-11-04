package cg.paint.desenho;

import java.awt.Graphics;

import cg.paint.geometria.PoligonoFechado;
import cg.paint.pena.Caneta;



public class DesenhistaPoligono {
	
	public static Caneta caneta;
	
	private static boolean inicioPoligono;
	private static boolean fimPoligono;
	private static boolean desenhaPoligono; 
	
	
	// para desenhar poligonos ...
	private static PoligonoFechado poligonoFechado = new PoligonoFechado();
	private static int xi, yi, xaux, yaux; // para poligonos
	private static boolean concluido = false;

	// Gerencia o desenho do pol�gono fechado
	public static void desenhaPoligonoFechado(int x, int y, Graphics g){
		concluido = false;
		// se for o primeiro ponto
		if (getInicioPoligono()){
			System.out.println("Inicia poligono...");
			poligonoFechado = new PoligonoFechado();
			xi = x;
			yi = y;
			xaux = x;
			yaux = y;
			setInicioPoligono(false);
		} 
		// se N�O for o primeiro ponto
		else {
			poligonoFechado.desenhaLadoPoligono(xaux, yaux, x, y, getCaneta(), g);
			if (!fimPoligono(xi, yi, x, y)){
				xaux = x;
				yaux = y;
			}
			// se for o �ltimo
			else{
				x = xi; y = yi;
				// redesenhar a linha (precisa fazer clipping)
//				listaDesenho.add(new PoligonoFechado(poligonoFechado.getLados()));
				concluiUmPoligono();
				System.out.println("Conclui poligono...");
			}
		}
	}

	// Inicia um pol�gono
	public static void iniciaUmPoligono(){
//		poligonoFechado = new PoligonoFechado();
		inicioPoligono = true;
		fimPoligono = false;
	}

	// Fecha um pol�gono e prepara o desenho do pr�ximo
	public static void concluiUmPoligono() {
//		listaDesenho.add(poligono);
		// inicia outro poligono ...
//		poligonoFechado = new PoligonoFechado();
		inicioPoligono = true; 
		fimPoligono = false;   
		concluido = true;
		poligonoFechado.defineExtremos();
	}

	public static boolean getInicioPoligono(){
    	System.out.println("getInicioPoligono() = '"+ inicioPoligono +"'");
		return inicioPoligono; 
	}

	public static void setInicioPoligono(boolean b){
    	System.out.println("setInicioPoligono("+b+")");
		inicioPoligono = b; 
	}

	// quando desmarca o checkbox no menu
	public static void concluiDesenhoPoligonos() {
		poligonoFechado = null;
		inicioPoligono = false; 
		fimPoligono = true;       
		concluido = true;
	}	
	
	// Verifica o final do desenho de um pol�gono
	public static boolean fimPoligono(int xi, int yi, int xf, int yf) {
		fimPoligono = false; // por seguran�a...
		if (Math.abs(xf - xi) < 10 && Math.abs(yf - yi) < 10)
			fimPoligono = true;
		return fimPoligono;
	}

	public static PoligonoFechado getPoligonoFechado() {
		return poligonoFechado;
	}

	public static void setPoligonoFechado(PoligonoFechado poligonoFechado) {
		DesenhistaPoligono.poligonoFechado = poligonoFechado;
	}

	public static boolean isConcluido() {
		return concluido;
	}

	public static void setConcluido(boolean concluido) {
		DesenhistaPoligono.concluido = concluido;
	}
	
	public static Caneta getCaneta() {
		return caneta;
	}

	public static void setCaneta(Caneta caneta) {
		DesenhistaPoligono.caneta = caneta;
	}


}
