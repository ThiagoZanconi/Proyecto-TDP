package visitor;

import Objetos.Duna;
import enemigos.Enemigo;
import stateEnemigos.Realentizado;

public class VisitorDuna extends VisitorObstaculo {
	protected Duna miDuna;
	
	public VisitorDuna(Duna l) {
		miDuna=l;
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.setEstadoVelocidad(new Realentizado(e));
	}

}
