package gui;

import juego.Personaje;

public class HiloVelocidadAtaque extends Thread {
	protected Personaje miPersonaje;
	
	public HiloVelocidadAtaque(Personaje p) {
		miPersonaje=p;
	}
	
	public void run() {
		miPersonaje.setPuedeAtacar(false);
		try {
			sleep(3000);
			miPersonaje.setPuedeAtacar(true);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
