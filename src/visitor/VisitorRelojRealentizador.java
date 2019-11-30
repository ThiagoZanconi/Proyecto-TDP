package visitor;

import Objetos.Objeto;
import Objetos.RelojRealentizador;
import enemigos.Enemigo;
import stateEnemigos.Realentizado;

public class VisitorRelojRealentizador extends VisitorPremio {

	protected RelojRealentizador miRelojRealentizador;
	
	public VisitorRelojRealentizador(RelojRealentizador r) {
		miRelojRealentizador=r;
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.setEstadoVelocidad(new Realentizado(e));
	}
	
	@Override
	public void visitarObjeto(Objeto o) {
		// TODO Auto-generated method stub
		
	}

}
