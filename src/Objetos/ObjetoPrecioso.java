package Objetos;

import visitor.Visitor;

public abstract class ObjetoPrecioso extends Premio{

	public ObjetoPrecioso(int x,int y) {
		super(x, y);
	}

	public void aceptar(Visitor v) {
		
	}

	public void actividadSinColision() {
		
	}

}
