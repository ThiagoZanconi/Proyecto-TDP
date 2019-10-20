package visitor;

import juego.Aliado;
import juego.Disparo;
import juego.Elemento;
import juego.Enemigo;

public class VisitorAliado extends Visitor {
	
	public VisitorAliado(Elemento e) {
		miElemento=e;
		
	}
	
	
	public void visitarAliado(Aliado a) {
		a.denegarCreacion();
		a.getGrafico().setVisible(false);
		
	}
	public void visitarEnemigo(Enemigo e) {
		e.setEnMovimiento(false);
		
	}

	public void visitarDisparo(Disparo d) {
		
	}

}
