package visitor;

import Objetos.Bomba;
import Objetos.Objeto;
import aliados.Aliado;
import enemigos.Enemigo;

public class VisitorBomba extends VisitorPremio{
	protected Bomba miBomba;
	public VisitorBomba(Bomba b) {
		miBomba=b;
	}
	
	@Override
	public void visitarEnemigo(Enemigo e) {
		e.recibirDaño(miBomba.getDaño());
	}

	@Override
	public void visitarAliado(Aliado a) {
		a.recibirDaño(miBomba.getDaño());	
	}

	@Override
	public void visitarObjeto(Objeto o) {
		miBomba.aceptar(o.getVisitor());
	}
	

}
