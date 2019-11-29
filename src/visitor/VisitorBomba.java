package visitor;

import Objetos.Bomba;
import Objetos.Objeto;

public class VisitorBomba extends VisitorPremio{
	protected Bomba miBomba;
	public VisitorBomba(Bomba b) {
		miBomba=b;
	}

	@Override
	public void visitarObjeto(Objeto o) {
		// TODO Auto-generated method stub
		
	}
	

}
