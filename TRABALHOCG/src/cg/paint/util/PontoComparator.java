package cg.paint.util;

import java.util.Comparator;

import cg.paint.pena.Ponto;


public class PontoComparator implements Comparator {

	public int compare(Object p0, Object p1) {
		// TODO Auto-generated method stub
		return (int) (((Ponto)p0).getX()-((Ponto)p1).getX());
	}

}
