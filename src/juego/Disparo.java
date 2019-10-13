package juego;

import visitor.Visitor;

public class Disparo extends Elemento {
	
	
	protected int da�o;
	protected int velocidad;
	
	
	public Disparo(int da�o, int velocidad) {
		super(-1);
		this.da�o=da�o;
		this.velocidad=velocidad;
		
	}
	
	public void aceptar(Visitor v) {
		v.visitarDisparo(this);
	}
	
	
}
