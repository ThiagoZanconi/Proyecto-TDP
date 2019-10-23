package aliados;

import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorAlcanceAliado;

public abstract class Aliado extends Personaje {

	public Aliado(int f, int a,int v,int vp) {
		super(f,a,v,vp);
		visitorAlcance=new VisitorAlcanceAliado(this);
	}
	
	public void aceptar(Visitor v) {
		v.visitarAliado(this);	
	}
	
	public void denegarCreacion() {
		destruir();
		//devolverOro();
	}

	public void actividadSinColision() {
		adaptador.chequearColisionDeAtaques(this);
	}

}