package visitor;

import Objetos.ObstaculoConVida;
import Objetos.ObstaculoTemporal;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorObstaculoTemporal extends Visitor{

	@Override
	public void visitarEnemigo(Enemigo e) {
		e.detener();
	}

	@Override
	public void visitarAliado(Aliado a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarDisparo(Disparo d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarElementoDerrota(ElementoDerrota e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VisitarObstaculoTemporal(ObstaculoTemporal ot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VisitarObstaculoConVida(ObstaculoConVida ov) {
		// TODO Auto-generated method stub
		
	}

}
