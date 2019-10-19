package juego;
import visitor.*;

public class Enemigo extends Personaje {
	
	protected boolean colisiono;

	public Enemigo(int f, int a, int v,int vp) {
		super(f, a, v,vp);
		// TODO Auto-generated constructor stub
	}
	
	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
		
	}
	
	
}
