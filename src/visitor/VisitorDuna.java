package visitor;

import Objetos.Duna;
import aliados.Aliado;
import enemigos.Enemigo;

public class VisitorDuna extends VisitorObstaculoTemporal {
	protected Duna miDuna;
	
	public VisitorDuna(Duna l) {
		miDuna=l;
	}
	
	public void visitarEnemigo(Enemigo e) {
	
	}
	
	public void visitarAliado(Aliado a) {
		
		
	}

}
