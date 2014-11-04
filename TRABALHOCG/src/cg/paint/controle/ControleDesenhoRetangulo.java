/************************************************************
 * UMA SIMPLES APLICA��O QUE IMPLEMENTA ALGUMAS
 * PRIMITIVAS 2D UTILIZANDO ALGORITMOS CL�SSICOS DEFINIDOS
 * NO LIVRO "COMPUTER GRAPHICS PRINCIPLES AND PRACTICE, SECOND
 * EDITION", CAP. 2, DE FOLEY, VAN DAN, FEINER & HUGHES
 * PARA UTILIZA��O PR�TICA NO CURSO DE COMPUTA��O GR�FICA
 * DO CURSO DE CI�NCIA DA COMPUTA��O - FAESA
 *
 * TIAGO T. WIRTTI
 ************************************************************/

/*
 * Gerencia do desenho do retangulo
 */
 
package cg.paint.controle;

public class ControleDesenhoRetangulo {
 	private static boolean desenhaRetangulo = false;
 	private static boolean obtemPontosRetangulo = false;	
 	
	// habilita/desabilita desenho do ret�ngulo
    public static void setDesenhaRetangulo(boolean b) {
    	desenhaRetangulo = b;
    }
    
	// retorna se o ret�ngulo pode ou n�o ser desenhado
    public static boolean getDesenhaRetangulo() {
    	return desenhaRetangulo;
    }    

    public static boolean getObtemPontosRetangulo() {
    	return obtemPontosRetangulo;
    }

    public static void setObtemPontosRetangulo(boolean b) {
    	obtemPontosRetangulo = b;
    }
}