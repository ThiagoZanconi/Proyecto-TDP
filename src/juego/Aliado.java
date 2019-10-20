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
	public void recibirDa�o(int da�o) {
		vida=vida-da�o;
		if(vida<=0) {
			destruir();
		
		}
	}
	public void denegarCreacion() {
		destruir();
		//devolverOro();
	}

	public void actividadSinColision() {
		
	}

}
