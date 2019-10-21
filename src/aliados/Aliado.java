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
		adaptador.chequearColisionDeAtaques(this);
	}

}