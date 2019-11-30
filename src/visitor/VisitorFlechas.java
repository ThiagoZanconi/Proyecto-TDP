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
		e.recibirDaño(misFlechas.getDaño());
		
	}

	@Override
	public void visitarAliado(Aliado a) {
		// TODO Auto-generated method stub
		
	}

}
