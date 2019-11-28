package statePersonajes;

import juego.Personaje;

public class EstadoNoAtacando extends Estado {

	public EstadoNoAtacando(Personaje p) {
		super(p);
	}

	@Override
	public void atacar() {
		
	}

}
