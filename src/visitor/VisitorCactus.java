package visitor;

import Objetos.Cactus;
import aliados.Aliado;
import enemigos.Enemigo;

public class VisitorCactus extends VisitorObstaculoTemporal{
	
	private Cactus miCactus;
	
	public VisitorCactus(Cactus c) {
		miCactus=c;		
	}
	
	public void visitarEnemigo(Enemigo e) {
		
	}

	
	public void visitarAliado(Aliado a) {
		
		
	}
	
}
