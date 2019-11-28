package stateEnemigos;

import enemigos.Enemigo;

public class VelocidadNormal extends EstadoVelocidad {

	public VelocidadNormal(Enemigo e) {
		super(e);
	}

	@Override
	public int velocidad() {
		return miEnemigo.getVelocidadNormal();
	}

}
