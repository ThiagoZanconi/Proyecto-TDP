package juego;

import visitor.Visitor;

public abstract class Aliado extends Personaje {
	protected Disparo miDisparo;

	public Aliado(int f, int a,int v,int vp) {
		super(f,a,v,vp);
		// TODO Auto-generated constructor stub
	}
	
	public void aceptar(Visitor v) {
		v.visitarAliado(this);
		
	}
	
	public void denegarCreacion() {
		destruir();
		//devolverOro();
	}

	public void destruir() {
		adaptador.eliminarElemento(this);
	}


}
