package visitor;

import Objetos.Lago;
import aliados.Aliado;
import enemigos.Enemigo;
import gui.HiloAtaqueLago;

public class VisitorLago extends VisitorObstaculo {
	protected Lago miLago;
	
	public VisitorLago(Lago l) {
		miLago=l;
	}
	
	public void visitarEnemigo(Enemigo e) {
		miLago.atacar(e);
		if(miLago.getPuedeAtacar()) {
			HiloAtaqueLago hilo=new HiloAtaqueLago(miLago);
			hilo.start();
		}
		
	}
	
	public void visitarAliado(Aliado a) {
		miLago.atacar(a);
		if(miLago.getPuedeAtacar()) {
			HiloAtaqueLago hilo=new HiloAtaqueLago(miLago);
			hilo.start();
		}
		
	}

}
