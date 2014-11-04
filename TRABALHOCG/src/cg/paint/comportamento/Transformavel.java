package cg.paint.comportamento;

public interface Transformavel extends Selecionavel{
	void translada(int tx, int ty);
	void rotacionar(double angulo);
	void deformar(double dx, double dy);
}
