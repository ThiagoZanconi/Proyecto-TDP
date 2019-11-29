package Objetos;

import visitor.Visitor;

public abstract class ObstaculoConVida extends Obstaculo{

	public ObstaculoConVida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void recibirDaño(int daño) {
		vida=vida-daño;
		if(vida<=0) {
			destruir();
		}
	}
	
	public void aceptar(Visitor v) {
		v.VisitarObstaculo(this);	
	}
	
}
