package visitor;

import Objetos.Flechas;
import aliados.Aliado;
import enemigos.Enemigo;

public class VisitorFlechas extends VisitorObjeto {
	protected Flechas misFlechas;
	
	public VisitorFlechas(Flechas f) {
		misFlechas=f;	
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.recibirDa�o(misFlechas.getDa�o());
		
	}

	@Override
	public void visitarAliado(Aliado a) {
		// TODO Auto-generated method stub
		
	}

}
