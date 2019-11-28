package juego;

import java.awt.Rectangle;

import statePersonajes.Estado;
import statePersonajes.EstadoAtacando;
import visitor.VisitorAlcance;

public abstract class Personaje extends Elemento{
	protected int fuerzaDeImpacto;
	protected int alcance;
	protected int velocidadDeProyectil;
	protected Rectangle alcanceDeAtaque;
	protected VisitorAlcance visitorAlcance;
	protected int vidaMaxima;
	protected Estado estado;
	
	public Personaje(int f,int a,int v,int vp) {
		super(v);
		fuerzaDeImpacto=f;
		alcance=a;
		velocidadDeProyectil=vp;
		estado=new EstadoAtacando(this);
		vidaMaxima=v;
	}
	
	public abstract void generarDisparo();
	
	public void atacar() {
		estado.atacar();
	}
	
	public void setEstado(Estado e) {
		estado=e;
	}
	
	public Rectangle getAlcanceDeAtaque() {
		return alcanceDeAtaque;
	}
	
	public VisitorAlcance getVisitorAlcance() {
		return visitorAlcance;
	}

	
	public int getFuerzaDeImpacto() {
		return fuerzaDeImpacto;
	}
	
	public void recibirDaño(int daño) {
		vida=vida-daño;
		if(vida<=0) {
			destruir();
		}
	}
	
	public boolean equals(Personaje e) {
		return this.rectangulo.equals(e.getRectangulo());
	}
}
