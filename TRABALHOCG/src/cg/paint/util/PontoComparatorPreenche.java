package cg.paint.util;

import java.util.Comparator;

import cg.paint.pena.Ponto;


public class PontoComparatorPreenche implements Comparator {

	public int compare(Object _p0, Object _p1) {
		Ponto p0=(Ponto)_p0;
		Ponto p1=(Ponto)_p1;
		int aux=(int)(p0.getY()-p1.getY());
		if(aux<0){
			return -1;
		}
		else if(aux>0){
			return 1;
		}
		else{
			return (int)(p0.getX()-p1.getX());			
		}
	}
}
