package visitor;

import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.Elemento;

public class VisitorAliado extends Visitor {
	
	public VisitorAliado(Elemento e) {
		miElemento=e;
		
	}
	/**
	 * Al momento de insertar un aliado sobre otro aliado se genera una colision que denega la creacion del nuevo aliado
	 */
	
	public void visitarAliado(Aliado a) {
		a.denegarCreacion();
		a.getGrafico().setVisible(false);
		
	}
	/**
	 * El enemigo colisiona con el aliado por lo que deja de caminar
	 */
	public void visitarEnemigo(Enemigo e) {
		e.detener();
	}

	public void visitarDisparo(Disparo d) {
		
	}

}
