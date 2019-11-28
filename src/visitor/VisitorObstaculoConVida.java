package visitor;

import Objetos.ObstaculoConVida;
import Objetos.ObstaculoTemporal;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public class VisitorObstaculoConVida extends Visitor{
	ObstaculoConVida miObstaculo;
	
	public VisitorObstaculoConVida(ObstaculoConVida o) {
		miObstaculo=o;
	}
	
	public VisitorObstaculoConVida() {
		
	}
	

	public void visitarEnemigo(Enemigo e) {
		e.detener();
	}

	public void visitarAliado(Aliado a) {
		
	}

	public void visitarDisparo(Disparo d) {
		miObstaculo.recibirDaño(d.getDaño());
		d.destruir();
	}

	@Override
	public void visitarElementoDerrota(ElementoDerrota e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VisitarObstaculoTemporal(ObstaculoTemporal ot) {
		miObstaculo.aceptar(ot.getVisitor());
	}

	@Override
	public void VisitarObstaculoConVida(ObstaculoConVida ov) {
		miObstaculo.destruir();
	}

}
