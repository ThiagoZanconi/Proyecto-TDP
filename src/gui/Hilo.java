package gui;

import juego.Juego;

public class Hilo extends Thread{
	private GUI gui;
	private Juego juego;
	
	public Hilo(GUI gui,Juego juego) {
		this.gui=gui;
		this.juego=juego;
		
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.mover();
		}
	}
}
