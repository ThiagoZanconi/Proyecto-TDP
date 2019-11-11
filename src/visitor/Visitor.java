package visitor;
import Objetos.ObstaculoConVida;
import Objetos.ObstaculoTemporal;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public abstract class Visitor {	
	public abstract void visitarEnemigo(Enemigo e);
	public abstract void visitarAliado(Aliado a);
	public abstract void visitarDisparo(Disparo d);
	public abstract void visitarElementoDerrota(ElementoDerrota e);
	public abstract void VisitarObstaculoTemporal(ObstaculoTemporal ot);
	public abstract void VisitarObstaculoConVida(ObstaculoConVida ov);
}
