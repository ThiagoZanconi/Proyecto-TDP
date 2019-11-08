package Objetos;

import visitor.Visitor;

public abstract class Obstaculo extends Objeto{

	public Obstaculo(int v) {
		super(v);
	}

	public void aceptar(Visitor v) {
		
	}

	public void actividadSinColision() {
		
	}

}
