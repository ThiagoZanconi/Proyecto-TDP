package visitor;

import Objetos.Dummy;
import Objetos.Premio;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;

public class VisitorDummy extends VisitorObjeto{
	protected Dummy miDummy;
	
	public VisitorDummy(Dummy d) {
		miDummy=d;
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.destruir();
		e.destruirCampo();
		miDummy.destruir();
	}

	@Override
	public void visitarAliado(Aliado a) {
		miDummy.setColisiono(true);
		a.setColisiono(true);
	}
	
	public void visitarDisparo(Disparo d) {
		miDummy.destruir();
		d.destruir();	
	}
	
	public void visitarPremio(Premio p) {
		miDummy.destruir();
	}

}
