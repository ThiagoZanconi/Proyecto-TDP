package visitor;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import juego.Personaje;

public class VisitorAlcanceAliado extends VisitorAlcance{
	
	public VisitorAlcanceAliado(Personaje p) {
		miPersonaje=p;
	}
	
	public void visitarEnemigo(Enemigo e) {
		
		miPersonaje.atacar();
		if(miPersonaje.getPuedeAtacar()) {
			hiloVelocidadAtaque hilo=new hiloVelocidadAtaque(miPersonaje);
			hilo.start();
		}
		
	}
	
	public void visitarAliado(Aliado e) {
		
	}
	
	public void visitarDisparo(Disparo d) {
		
	}

}
