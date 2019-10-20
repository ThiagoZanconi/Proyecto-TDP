package visitor;
import juego.*;
public class VisitorEnemigo extends Visitor {
	
	public VisitorEnemigo(Elemento e) {
		miElemento=e;
	}
	
	
	public void visitarAliado(Aliado a) {
		a.recibirDa�o(miElemento.getFuerzaDeImpacto());
		
	}
	/**
	 * Colision enemigo con enemigo no hace nada
	 */
	public void visitarEnemigo(Enemigo e) {
		
	}

	public void visitarDisparo(Disparo d) {
		
	}

}
