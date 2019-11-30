package visitor;

import Objetos.MinaOro;
import Objetos.Objeto;
import Objetos.Premio;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;

public class VisitorMinaOro extends VisitorObjeto {
	protected MinaOro miMina;
	
	public VisitorMinaOro(MinaOro m) {
		miMina=m;
	}
	
	public void visitarEnemigo(Enemigo e) {
		e.detener();
		e.atacar();
	}

	@Override
	public void visitarAliado(Aliado a) {
		miMina.setColisiono(true);
		a.setColisiono(true);
	}
	
	public void visitarDisparo(Disparo d) {
		miMina.destruir();
		d.destruir();	
	}
	
	public void visitarPremio(Premio p) {
		miMina.recibirDaño(p.getDaño());
	}
	
	public void visitarObjeto(Objeto o) {
		o.setColisiono(true);
	}

}
