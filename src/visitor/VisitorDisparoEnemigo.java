package visitor;

import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.Elemento;

public class VisitorDisparoEnemigo extends Visitor {
	
	public VisitorDisparoEnemigo(Elemento e) {
		miElemento=e;
	}
	
	public void visitarEnemigo(Enemigo e) {
		
	}
	public void visitarAliado(Aliado a) {
		
	}
	public void visitarDisparo(Disparo d) {
		
	}

}
