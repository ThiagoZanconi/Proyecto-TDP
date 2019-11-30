package visitor;

import Objetos.Objeto;
import Objetos.Pared;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;

public class VisitorPared extends VisitorPremio{
	protected Pared miPared;
	
	public VisitorPared(Pared p) {
		miPared=p;
	}

	@Override
	public void visitarObjeto(Objeto o) {
		// TODO Auto-generated method stub	
	}
	
	public void visitarAliado(Aliado a) {
		a.setColisiono(true);
	}
	
	public void visitarDisparo(Disparo d) {
		miPared.recibirDaño(d.getDaño());
		d.destruir();
		
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.detener();
		e.atacar();
	}
	
	public void visitarObjeto() {
		
	}

}
