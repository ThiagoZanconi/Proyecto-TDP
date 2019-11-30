package visitor;

import Objetos.CuboHielo;
import enemigos.Enemigo;
import stateEnemigos.Congelado;

public class VisitorCuboHielo extends VisitorObjeto{
	
	protected CuboHielo miCuboHielo;
	
	public VisitorCuboHielo(CuboHielo c) {
		miCuboHielo=c;
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.setEstadoVelocidad(new Congelado(e));
	}

}
