package cg.paint.desenho;

import java.util.ArrayList;
import java.util.List;

import cg.paint.geometria.Geometria;

public class Desenhos {
	List <Geometria> desenhos;

	public Desenhos() {
		this.desenhos = new ArrayList<Geometria>();
		// TODO Auto-generated constructor stub
	}

	public List<Geometria> getDesenhos() {
		return desenhos;
	}

	public void setDesenhos(List<Geometria> desenhos) {
		this.desenhos = desenhos;
	}

	public Desenhos(List<Geometria> desenhos) {
		this.desenhos = desenhos;
	}
	
	
}
