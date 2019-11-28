package gui;

import enemigos.Enemigo;
import stateEnemigos.VelocidadNormal;

public class HiloVolverEstadoNormal extends Thread {
	protected Enemigo miEnemigo;
	
	public HiloVolverEstadoNormal(Enemigo e) {
		miEnemigo=e;
	}
	
	public void run() {
		try {
			sleep(3000);
			miEnemigo.setEstadoVelocidad(new VelocidadNormal(miEnemigo));
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
