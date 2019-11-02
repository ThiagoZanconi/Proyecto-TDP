package aliados;

import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorAlcanceAliado;

public abstract class Aliado extends Personaje {
	protected boolean colisiono;
	protected int costoMonedas;
	public Aliado(int f, int a,int v,int vp) {
		super(f,a,v,vp);
		visitorAlcance=new VisitorAlcanceAliado(this);
		colisiono=false;
	}
	
	public void setColisiono(boolean x) {
		colisiono=x;
	}
	
	public boolean getColisiono() {
		return colisiono;
	}
	
	public int getCostoMonedas() {
		return costoMonedas;
	}
	
	public void aceptar(Visitor v) {
		v.visitarAliado(this);	
	}

	public void actividadSinColision() {
		adaptador.chequearColisionDeAtaques(this);
	}

}