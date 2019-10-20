package juego;

import java.util.List;

import javax.swing.JFrame;

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
	
	public void disparar(List<Disparo> l) {
		
	}
	
	public void denegarCreacion() {
		destruir();
		//devolverOro();
	}

	public void destruir() {
		
	}


}
