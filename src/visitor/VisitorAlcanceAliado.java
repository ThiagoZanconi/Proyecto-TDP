package visitor;
import Objetos.ObstaculoConVida;
import Objetos.ObstaculoTemporal;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;
import juego.Personaje;

public class VisitorAlcanceAliado extends VisitorAlcance{
	
	public VisitorAlcanceAliado(Personaje p) {
		miPersonaje=p;
	}
	
	public void visitarEnemigo(Enemigo e) {	
		miPersonaje.atacar();
	}
	
	public void visitarAliado(Aliado e) {
		
	}
	
	public void visitarDisparo(Disparo d) {
		
	}
	
	public void visitarElementoDerrota(ElementoDerrota e) {
		
	}

	@Override
	public void VisitarObstaculoTemporal(ObstaculoTemporal o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VisitarObstaculoConVida(ObstaculoConVida ov) {
		miPersonaje.atacar();
	}

}
