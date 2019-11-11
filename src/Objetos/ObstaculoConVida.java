package Objetos;

import visitor.Visitor;

public abstract class ObstaculoConVida extends Obstaculo{

	public ObstaculoConVida(int v) {
		super(v);
		// TODO Auto-generated constructor stub
	}

	public void recibirDa�o(int da�o) {
		vida=vida-da�o;
		if(vida<=0) {
			destruir();
		}
	}
	
	public void aceptar(Visitor v) {
		v.VisitarObstaculoConVida(this);	
	}
	
}
