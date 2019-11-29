package visitor;

import Objetos.Lago;
import aliados.Aliado;
import enemigos.Enemigo;

public class VisitorLago extends VisitorObstaculoTemporal {
	protected Lago miLago;
	
	public VisitorLago(Lago l) {
		miLago=l;
	}
	
	public void visitarEnemigo(Enemigo e) {
		miLago.atacar(e);
	}
	
	public void visitarAliado(Aliado a) {
		miLago.atacar(a);	
	}

}
