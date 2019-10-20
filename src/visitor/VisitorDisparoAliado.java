package visitor;

import juego.Aliado;
import juego.Disparo;
import juego.Elemento;
import juego.Enemigo;

public class VisitorDisparoAliado extends Visitor {
	
	public VisitorDisparoAliado(Elemento e) {
		miElemento=e;
	}
	
	public void visitarEnemigo(Enemigo e) {
		
	}
	public void visitarAliado(Aliado a) {
		
	}
	public void visitarDisparo(Disparo d) {
		
	}

}
