package statePersonajes;

import gui.HiloVelocidadAtaque;
import juego.Personaje;

public class EstadoAtacando extends Estado{

	public EstadoAtacando(Personaje p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void atacar() {
		miPersonaje.generarDisparo();
		miPersonaje.setEstado(new EstadoNoAtacando(miPersonaje));
		HiloVelocidadAtaque hilo=new HiloVelocidadAtaque(miPersonaje);
		hilo.start();
	}

}
