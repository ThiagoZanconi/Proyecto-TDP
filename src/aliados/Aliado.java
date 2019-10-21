package aliados;

import disparos.Disparo;
import juego.Personaje;
import visitor.Visitor;

public abstract class Aliado extends Personaje {
	protected Disparo miDisparo;

	public Aliado(int f, int a,int v,int vp) {
		super(f,a,v,vp);
	}
	
	public void aceptar(Visitor v) {
		v.visitarAliado(this);
		
	}
	public void recibirDaño(int daño) {
		vida=vida-daño;
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