package visitor;
import Objetos.Objeto;
import Objetos.Obstaculo;
import Objetos.Premio;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.ElementoDerrota;

public abstract class Visitor {	
	public abstract void visitarEnemigo(Enemigo e);
	public abstract void visitarAliado(Aliado a);
	public abstract void visitarDisparo(Disparo d);
	public abstract void visitarElementoDerrota(ElementoDerrota e);
	public abstract void VisitarObstaculo(Obstaculo ot);
	public abstract void visitarPremio(Premio p);
	public abstract void visitarObjeto(Objeto o);
}
