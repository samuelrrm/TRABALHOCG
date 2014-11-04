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
 * Gerencia do desenho da circunferencia
 */
 
package cg.paint.controle;

public class ControleDesenhoCircunferencia{
	private static boolean desenhaCircunferencia = false;
	private static boolean obtemPontosCircunferencia = false;
	
	// habilita/desabilita desenho da circunfer�ncia 
    public static void setDesenhaCircunferencia(boolean b) {
    	desenhaCircunferencia = b;
    }
    
	// retorna se a circunfer�ncia pode ou n�o ser desenhada
    public static boolean getDesenhaCircunferencia() {
    	return desenhaCircunferencia;
    }    
 
    public static boolean getObtemPontosCircunferencia() {
    	return obtemPontosCircunferencia;
    }

    public static void setObtemPontosCircunferencia(boolean b) {
    	obtemPontosCircunferencia = b;
    }
}