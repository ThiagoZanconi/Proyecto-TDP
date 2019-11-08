package Objetos;

import visitor.Visitor;

public abstract class ObjetoPrecioso extends Premio{

	public ObjetoPrecioso(int v) {
		super(v);
	}

	public void aceptar(Visitor v) {
		
	}

	public void actividadSinColision() {
		
	}

}
