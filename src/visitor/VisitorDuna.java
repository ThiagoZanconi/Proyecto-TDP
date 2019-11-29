package visitor;

import Objetos.Duna;
import Objetos.Objeto;
import Objetos.Premio;
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

	@Override
	public void visitarPremio(Premio p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarObjeto(Objeto o) {
		// TODO Auto-generated method stub
		
	}

}
