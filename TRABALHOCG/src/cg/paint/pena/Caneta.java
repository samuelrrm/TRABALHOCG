package cg.paint.pena;

import java.awt.Graphics2D;

import cg.paint.util.TamanhoPixel;

public class Caneta {
	private int qtdePixLado; // pode ser impar ou par
	private Pixel[][] pena;
	private int tamanhoPixel = TamanhoPixel.MEDIO.getValue(); // default
	
	public Caneta(){
	}

	public Caneta(int qtdePixelLado){
		this.qtdePixLado = qtdePixelLado;
		pena = new Pixel[qtdePixelLado][qtdePixelLado];
		Pixel.setDim(tamanhoPixel);
	}

	public Pixel[][] getPena() {
		return pena;
	}

	public void setPena(Pixel[][] pena) {
		this.pena = pena;
	}

	public int getQtdePixLado() {
		return qtdePixLado;
	}

	public void setQtdePixLado(int qtdePixLado) {
		this.qtdePixLado = qtdePixLado;
	}
	
	public void plota(Graphics2D g, Pixel pixelCentro){
		// gera pena a partir do pixel central
		geraPena(pixelCentro);
		// plota ponto quadrado NxN, onde N=qtdePixLado
		for (int iy = 0; iy < qtdePixLado; iy++){
			for (int ix = 0; ix < qtdePixLado; ix++){
				pena[ix][iy].draw(g);
			}
		}
	}
	private void geraPena(Pixel centro){
		// centro do primeiro pixel da ponta da caneta...
		// ou seja, o superior esquerdo
		double xPix, yPix, xIni, yIni; 
		Pixel.setDim(tamanhoPixel);
		// trata a situacao da pena quadrada com numero PAR de pixels
		if (qtdePixLado % 2 == 0){
			xIni = centro.getXc() - (qtdePixLado/2)*Pixel.getDim() + (Pixel.getDim()/2);
			yIni = centro.getYc() - (qtdePixLado/2)*Pixel.getDim() + (Pixel.getDim()/2);
//			System.out.println("PAR");
//			System.out.println("xini = "+xIni+ "   yini = "+ yIni );
		}
		// trata a situacao da pena quadrada com numero IMPAR de pixels
		else {
			xIni = centro.getXc() - (qtdePixLado/2)*Pixel.getDim();
			yIni = centro.getYc() - (qtdePixLado/2)*Pixel.getDim();
//			System.out.println("IMPAR");
//			System.out.println("xini = "+xIni+ "   yini = "+ yIni );
		}
		// carrega a pena com o pixels
		xPix = xIni;
		yPix = yIni;
		for (int iy = 0; iy < qtdePixLado; iy++){
			for (int ix = 0; ix < qtdePixLado; ix++){
				pena[ix][iy] = new Pixel(xPix, yPix, tamanhoPixel);
				xPix += Pixel.getDim();
			}
			xPix = xIni;
			yPix += Pixel.getDim();
		}
	}

	public int getTamanhoPixel() {
		return tamanhoPixel;
	}

	public void setTamanhoPixel(int tamanhoPixel) {
		this.tamanhoPixel = tamanhoPixel;
	}
}