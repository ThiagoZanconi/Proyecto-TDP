package gui;

import juego.Juego;

public class HiloAparicionEnemigos extends Thread{
	protected Juego juego;
	protected boolean run;
	public HiloAparicionEnemigos(Juego j) {
		juego=j;	
		run=true;
	}
	
	public void detenerHilo() {
		run=false;
	}

	public void run() {
		while(run){
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.generarEnemigoAleatorio();
		}
	}

}
