package gui;

import juego.Personaje;
import statePersonajes.EstadoAtacando;

public class HiloVelocidadAtaque extends Thread {
	protected Personaje miPersonaje;
	
	public HiloVelocidadAtaque(Personaje p) {
		miPersonaje=p;
	}
	
	public void run() {
		try {
			sleep(3000);
			miPersonaje.setEstado(new EstadoAtacando(miPersonaje));
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
