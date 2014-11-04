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
 * Interface que define constantes e mï¿½todos das classes primitivas
 */
package cg.paint.geometria;
import java.awt.Graphics2D;

import cg.paint.comportamento.Selecionavel;
import cg.paint.comportamento.Transformavel;
import cg.paint.pena.Caneta;

/**
 * Este interface define metodos que precisam ser implementados 
 * por um objeto (primitiva) que seria desenhado na area de desenho
 */
public abstract class Geometria implements Transformavel, Selecionavel{
	public abstract void exibeTextoCoords(Graphics2D g); 		 
	public abstract void desenha(Graphics2D g, Caneta c);

}

