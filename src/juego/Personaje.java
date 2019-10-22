package juego;

import java.awt.Rectangle;

import visitor.VisitorAlcance;

public abstract class Personaje extends Elemento{
	protected int alcance;
	protected int velocidadDeProyectil;
	protected Rectangle alcanceDeAtaque;
	protected VisitorAlcance visitorAlcance;
	protected boolean puedeAtacar;
	
	public Personaje(int f,int a,int v,int vp) {
		super(v);
		fuerzaDeImpacto=f;
		alcance=a;
		velocidadDeProyectil=vp;
		puedeAtacar=true;
	}
	
	public abstract void atacar();
	
	public Rectangle getAlcanceDeAtaque() {
		return alcanceDeAtaque;
	}
	
	public VisitorAlcance getVisitorAlcance() {
		return visitorAlcance;
	}
	
	public boolean getPuedeAtacar() {
		return puedeAtacar;
	}
	
	public void setPuedeAtacar(boolean x) {
		puedeAtacar=x;
	}
}
