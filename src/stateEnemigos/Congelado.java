package stateEnemigos;

import enemigos.Enemigo;
import gui.HiloVolverEstadoNormal;

public class Congelado extends EstadoVelocidad {

	public Congelado(Enemigo e) {
		super(e);
		HiloVolverEstadoNormal hilo=new HiloVolverEstadoNormal(e);
		hilo.start();
	}

	@Override
	public int velocidad() {
		return 0;
	}

}
