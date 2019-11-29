package visitor;

import Objetos.Lago;
import Objetos.Objeto;
import Objetos.Premio;
import aliados.Aliado;
import enemigos.Enemigo;

public class VisitorLago extends VisitorObstaculo{
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

	@Override
	public void visitarPremio(Premio p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarObjeto(Objeto o) {
		// TODO Auto-generated method stub
		
	}

}
