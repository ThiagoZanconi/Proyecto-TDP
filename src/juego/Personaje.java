package juego;

import java.util.List;

public abstract class Personaje extends Elemento{
	protected int alcance;
	protected int velocidadDeProyectil;
	
	public Personaje(int f,int a,int v,int vp) {
		super(v);
		fuerzaDeImpacto=f;
		alcance=a;
		velocidadDeProyectil=vp;
	}
	
	public void atacar() {
		Disparo x=new Disparo(fuerzaDeImpacto,velocidadDeProyectil);
		
	}
	
	public void disparar() {
		
	}
	
	
}
