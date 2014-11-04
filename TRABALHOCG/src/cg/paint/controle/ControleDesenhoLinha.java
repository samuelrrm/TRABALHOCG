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
 * Gerencia do desenho da linha
 */

package cg.paint.controle;

public class ControleDesenhoLinha{
	private static boolean desenhaLinha = false; 
	private static boolean obtemPontosLinha = false;
	
	// habilita/desabilita desenho da linha
    public static void setDesenhaLinha(boolean b) {
    	desenhaLinha = b;
    }
    
	// retorna se a linha pode ou n�o ser desenhada
    public static boolean getDesenhaLinha() {
    	return desenhaLinha;
    }    
 
    public static boolean getObtemPontosLinha() {
    	return obtemPontosLinha;
    }

    public static void setObtemPontosLinha(boolean b) {
    	obtemPontosLinha = b;
    }
}
