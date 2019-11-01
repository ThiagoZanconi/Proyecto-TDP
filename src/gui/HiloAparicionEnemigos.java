package gui;

import juego.Juego;

public class HiloAparicionEnemigos extends Thread{
	protected Juego juego;
	public HiloAparicionEnemigos(Juego j) {
		juego=j;	
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.generarEnemigoAleatorio();
		}
	}

}
