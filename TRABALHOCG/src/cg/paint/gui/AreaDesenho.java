package cg.paint.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ListIterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cg.paint.comportamento.Preenchivel;
import cg.paint.comportamento.Transforma;
import cg.paint.comportamento.Transformavel;
import cg.paint.controle.ControleDesenhaPoligono;
import cg.paint.controle.ControleDesenhoCircunferencia;
import cg.paint.controle.ControleDesenhoLinha;
import cg.paint.controle.ControleDesenhoQuadrado;
import cg.paint.controle.ControleDesenhoRetangulo;
import cg.paint.controle.ControlePreenche;
import cg.paint.controle.ControleSeleciona;
import cg.paint.controle.ControleTransforma;
import cg.paint.desenho.Desenhista;
import cg.paint.desenho.DesenhistaPoligono;
import cg.paint.desenho.Desenhos;
import cg.paint.geometria.FiguraAberta;
import cg.paint.geometria.Geometria;
import cg.paint.pena.Caneta;
import cg.paint.util.TamanhoCaneta;



/**
 * Neste JPanel serao desenhadas a primitivas e manipulados 
 * os eventos de mouse.
 **/
@SuppressWarnings("serial")
public class AreaDesenho extends JPanel implements MouseListener {
	// pontos para desenhar qualquer objeto
	//	private int xi, yi, xaux, yaux; // para poligonos
	private int x1, y1; 
	private int x2, y2;
	private Caneta caneta;

	// controles de desenho 
	private static int count; // conta objetos desenhados
	private Desenhos desenhos;

	// configuração do painel de desenho
	private final int larguraJanela;
	private final int alturaJanela;

	public AreaDesenho() {
		count = 0; // conta objetos desenhados
		desenhos = new Desenhos();
		caneta = new Caneta(TamanhoCaneta.PEQUENO.getTamanho()); // três pixels
		larguraJanela = 450;
		alturaJanela = 450;
	}

	public void montaPainelDesenho(){
		setPreferredSize(new Dimension(larguraJanela,alturaJanela));
		addMouseListener(this);
	}

	// Programacao a ser executada quando o botï¿½o direito
	// do mouse for pressionado sobre a ï¿½rea de desenho
	public void mousePressed(MouseEvent e) {
		// se a funcao de desenho esta habilitada
		if (ControleDesenhoLinha.getObtemPontosLinha()) {
			// obtem pontos iniciais para desenho
			x1 = (int)e.getX();
			y1 = (int)e.getY();  
			System.out.println("x1 = "+ x1 + ", y1 = "+ y1);
		}
		if (ControleDesenhoRetangulo.getObtemPontosRetangulo()){
			// obtem pontos iniciais para desenho
			x1 = (int)e.getX(); // x centro 
			y1 = (int)e.getY(); // y centro
			System.out.println("x1 = "+ x1 + ", y1 = "+ y1);
		}
		if (ControleDesenhoQuadrado.isObtenPontosQuadrado()){
			// obtem pontos iniciais para desenho
			x1 = (int)e.getX(); // x centro 
			y1 = (int)e.getY(); // y centro
			System.out.println("x1 = "+ x1 + ", y1 = "+ y1);
		}
		if (ControleDesenhoCircunferencia.getObtemPontosCircunferencia()){
			// obtem pontos iniciais para desenho
			x1 = (int)e.getX(); // x centro 
			y1 = (int)e.getY(); // y centro
			System.out.println("x1 = "+ x1 + ", y1 = "+ y1);
		}
		if (ControleDesenhaPoligono.getObtemPontosPoligono()) {
			// obtem pontos iniciais para desenho
			x1 = (int)e.getX();
			y1 = (int)e.getY();  
			System.out.println("x1 = "+ x1 + ", y1 = "+ y1);
		}
		if(ControleTransforma.isTransforma()){
			// obtem pontos iniciais para desenho
			x1 = (int)e.getX();
			y1 = (int)e.getY();  
			System.out.println("x1 = "+ x1 + ", y1 = "+ y1);
		}
		if (ControleDesenhaPoligono.getDesenhaPoligono()){
			// o desenho de cada lado do poligono acontece quando se clica na area de desenho ...
			// por isso o desenho do poligono acontece aqui, ao contrario dos outros elementos ...
			// que sao desenhados quando o mouse e liberado
			System.out.println("DESENHA POLIGONO ---------------------->>>>>>>>>>>>>>>>>>>");
			DesenhistaPoligono.setCaneta(this.caneta);
			DesenhistaPoligono.desenhaPoligonoFechado(x1, y1, this.getGraphics());
			if (DesenhistaPoligono.isConcluido()){
				desenhos.getDesenhos().add(count++, DesenhistaPoligono.getPoligonoFechado());
			}
		}

		// Verifica se algum objeto foi selecionado.
		if (ControleSeleciona.isSelecaoHabilitada()){
			System.out.println("LISTA DESENHO ====> "+desenhos.getDesenhos().size());
			//			System.out.println("LISTA DESENHO ====> "+listaDesenho.size());
			for (Geometria el: desenhos.getDesenhos()){
				if (!(el instanceof FiguraAberta)){
					if (el.estaContido(e.getX(), e.getY())){
						JOptionPane.showMessageDialog(this,el.toString()+" selecionado:\n", "Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}

		// Verifica objetos para serem preenchidos.
		if (ControlePreenche.isPreencheHabilitado()){
			System.out.println("LISTA DESENHO ====> "+desenhos.getDesenhos().size());
			for (Geometria el: desenhos.getDesenhos()){
				//			for (Geometria el: listaDesenho){
				if (el instanceof Preenchivel){
					Preenchivel pf = (Preenchivel)el;
					if (pf.estaContido(e.getX(), e.getY())){
						System.out.print(pf.toString()+" sera preenchido.");
						pf.preenche(this.getGraphics());
					}
				}
			}
		}

	}

	// Programaï¿½ï¿½o a ser executada quando o botï¿½o direito
	// do mouse for pressionado sobre a ï¿½rea de desenho
	// Aqui acontecem as chamadas ï¿½s funï¿½ï¿½es que desenham 
	// as primitivas ...
	public void mouseReleased(MouseEvent e) { 
		// se a funï¿½ï¿½o de desenho estï¿½ habilitada
		if (ControleDesenhoLinha.getObtemPontosLinha() ) {
			x2 = (int)e.getX();
			y2 = (int)e.getY();
			System.out.println("x2 = "+ x2 + ", y2 = "+ y2);
		}
		// se a funï¿½ï¿½o de desenhar linha foi acionada
		// ou seja, se a opï¿½ï¿½o de menu "line" foi acionada
		if (ControleDesenhoLinha.getDesenhaLinha()) { 
			System.out.println("Desenha linha!!!");
			Geometria linha = 
				Desenhista.desenhaLinha(x1, y1, x2, y2, this.getGraphics(), caneta); // desenha linha
			desenhos.getDesenhos().add(count++, linha);
			//			listaDesenho.add(count++, linha);
		}

		// se a funï¿½ï¿½o de desenho estï¿½ habilitada
		if (ControleDesenhoRetangulo.getObtemPontosRetangulo()) {
			x2 = (int)e.getX();
			y2 = (int)e.getY();
			System.out.println("x2 = "+ x2 + ", y2 = "+ y2);
		}

		// se a funï¿½ï¿½o de desenhar retangulo foi acionada
		// ou seja, se a opï¿½ï¿½o de menu "rectangle" foi acionada
		if (ControleDesenhoRetangulo.getDesenhaRetangulo()) { 
			System.out.println("Desenha retangulo!!!");
			Geometria retangulo = 
				Desenhista.desenhaRetangulo(x1, y1, x2, y2, this.getGraphics(), caneta); // desenha retangulo
			desenhos.getDesenhos().add(count++, retangulo);
			//			listaDesenho.add(count++, retangulo);
		}

		if (ControleDesenhoQuadrado.isObtenPontosQuadrado()) {
			x2 = (int)e.getX();
			y2 = (int)e.getY();
			System.out.println("x2 = "+ x2 + ", y2 = "+ y2);
		}
		// ???
		// pode obter pontos circunferencia???
		if (ControleDesenhoCircunferencia.getObtemPontosCircunferencia()){
			x2 = (int)e.getX();
			y2 = (int)e.getY();
			System.out.println("x2 = "+ x2 + ", y2 = "+ y2);
		}
		if (ControleDesenhoCircunferencia.getDesenhaCircunferencia()){
			System.out.println("Desenha circunferencia!!!");
			Geometria circunferencia = 
				Desenhista.desenhaCircunferencia(x1, y1, x2, y2, this.getGraphics(), caneta); // desenha retangulo
			desenhos.getDesenhos().add(count++, circunferencia);
			//			listaDesenho.add(count++, circunferencia);
		}

		// Faz a transformacao nos objetos
		if(ControleTransforma.isTransforma()){
			// obtem pontos iniciais para desenho
			x2 = (int)e.getX();
			y2 = (int)e.getY();
			System.out.println("x2 = "+ x2 + ", y2 = "+ y2);
			for (Geometria el: desenhos.getDesenhos()){
				if (el instanceof Transformavel){
					Transformavel elemento = (Transformavel)el;
					if (elemento.estaContido(x1, y1)){
						System.out.print("Transformacao no "+elemento.toString());
						if (ControleTransforma.getOperacao() == Transforma.TRANSLADA){
							elemento.translada(x2-x1, y2-y1);
						}
						else if (ControleTransforma.getOperacao() == Transforma.ROTACIONA){

						}
						else {
							elemento.deformar(2, 2); // apenas testando
						}
						//						ControleTransforma.setOperacao(Transforma.LIMPA);
						repaint();
					}
				}
			}
		}
	}

	public void mouseExited(MouseEvent e){
	}

	public void mouseEntered(MouseEvent e){
	}

	public void mouseClicked(MouseEvent e){
	}

	// ----- TRATA POLIGONO ----


	// ----- TRATA POLIGONO PREENCHIDO ----
	// Esta funï¿½ï¿½o desenha a polï¿½gono preenchido atravï¿½s de um objeto da classe Polygon


	// -------------- GENï¿½RICAS -------------     
	// redesenha a tela quando acontece algum evento de atualizacao
	protected void paintComponent(Graphics g) {
		clear(g); // limpa tela...
		ListIterator it = desenhos.getDesenhos().listIterator();
		//		ListIterator it = listaDesenho.listIterator();
		while (it.hasNext()){
			Geometria el = (Geometria)it.next();
			el.desenha((Graphics2D)g, caneta);
			//			el.drawCoords((Graphics2D)g);
		}
	}

	public void clear() { 
		Graphics g = this.getGraphics();
		super.paintComponent(g);
		this.desenhos.getDesenhos().clear();
		//		this.listaDesenho.clear();
		count = 0;
	}

	private void clear(Graphics g) {
		super.paintComponent(g);
	}

	public Caneta getCaneta() {
		return caneta;
	}

	public void setCaneta(Caneta caneta) {
		this.caneta = caneta;
	}
}
