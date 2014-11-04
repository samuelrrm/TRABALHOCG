package cg.paint.controle;

import cg.paint.desenho.DesenhistaPoligono;

public class ControleDesenhaPoligono {
	private static boolean desenhaPoligono = false;
	private static boolean obtemPontosPoligono = false;
	
	// habilita/desabilita desenho da circunfer�ncia 
    public static void setDesenhaPoligono(boolean b) {
    	// Habilita/desabilita desenho do pol�gono fechado
    	desenhaPoligono = b;
//        	System.out.println("setDesenhaPoligono("+b+") = '"+ desenhaPoligono +"'");
    	if (b) {
//    	    	System.out.println("ENTROU IF B == '"+ b +"'");
    		DesenhistaPoligono.iniciaUmPoligono();
    	} 	
    	else 	
    		DesenhistaPoligono.concluiDesenhoPoligonos();
    }
    
	// retorna se a circunfer�ncia pode ou n�o ser desenhada
    public static boolean getDesenhaPoligono() {
    	return desenhaPoligono;
    }    
 
    public static boolean getObtemPontosPoligono() {
    	return obtemPontosPoligono;
    }

    public static void setObtemPontosPoligono(boolean b) {
    	obtemPontosPoligono = b;
    }
}
