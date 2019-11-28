package statePersonajes;

import juego.Personaje;

public abstract class Estado { 
	protected Personaje miPersonaje;
	
	public Estado(Personaje p) {
		miPersonaje=p;
	}
	
	public abstract void atacar();

}
