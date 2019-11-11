package visitor;

import Objetos.Obstaculo;
import Objetos.ObstaculoConVida;
import Objetos.ObstaculoTemporal;
import aliados.Aliado;
import disparos.Disparo;
import enemigos.Enemigo;
import gui.HiloVelocidadAtaque;
import juego.ElementoDerrota;
import juego.Personaje;

public class VisitorAlcanceEnemigo extends VisitorAlcance{
	
	public VisitorAlcanceEnemigo(Personaje p) {
		miPersonaje=p;	
	}
	
	public void visitarEnemigo(Enemigo e) {
		
	}
	
	public void visitarAliado(Aliado e) {
		miPersonaje.atacar();
		if(miPersonaje.getPuedeAtacar()) {
			HiloVelocidadAtaque hilo=new HiloVelocidadAtaque(miPersonaje);
			hilo.start();
		}
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
		if(miPersonaje.getPuedeAtacar()) {
			HiloVelocidadAtaque hilo=new HiloVelocidadAtaque(miPersonaje);
			hilo.start();
		}
	}

}
