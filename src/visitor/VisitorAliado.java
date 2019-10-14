package visitor;

import juego.Aliado;
import juego.Disparo;
import juego.Enemigo;

public class VisitorAliado extends Visitor {
	
	public VisitorAliado() {
		
	}
	
	
	public void visitarAliado(Aliado a) {
		
	}
	public void visitarEnemigo(Enemigo e) {
		e.setEnMovimiento(false);
		
	}

	public void visitarDisparo(Disparo d) {
		
	}

}
