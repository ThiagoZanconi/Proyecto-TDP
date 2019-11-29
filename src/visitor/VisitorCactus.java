package visitor;

import Objetos.Cactus;
import aliados.Aliado;
import enemigos.Enemigo;

public class VisitorCactus extends VisitorObstaculoConVida{
	
	private Cactus miCactus;
	
	public VisitorCactus(Cactus c) {
		miCactus=c;		
		miObstaculo=c;
	}
	
	public void visitarEnemigo(Enemigo e) {
		super.visitarEnemigo(e);
		System.out.println("Funciona");
		miCactus.atacar(e);
	}

	
	public void visitarAliado(Aliado a) {
		miCactus.atacar(a);
	}
	
}
