package gui;

import juego.Juego;

public class HiloAparicionEnemigos extends Thread{
	protected Juego juego;
	protected boolean run;
	protected int cambioOleada;                  //Cantidad de enemigos que aparecen antes de cambiar oleada
	protected int spawnEnemigos;                 //Aparece un enemigo cada x segundos
	protected int proximaOleada;                 //Cantidad de enemigos que aparecieron hasta el momento
	public HiloAparicionEnemigos(Juego j) {
		juego=j;
		spawnEnemigos=7000;
		cambioOleada=0;
		proximaOleada=20;
		run=true;
	}
	
	public void detenerHilo() {
		run=false;
	}

	public void run() {
		while(run){
			try {
				Thread.sleep(spawnEnemigos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.generarEnemigoAleatorio();
			cambioOleada++;
			if(cambioOleada==proximaOleada) {
				cambioOleada=0;
				proximaOleada+=15;				 //Proxima oleada es mas grande  
				spawnEnemigos-=2000;             //Enemigos aparecen con mas frecuencia
				if(proximaOleada==80) {			 //Termina el juego en victoria
					run=false;  				 
					juego.victoria();
				}
				else {
					try {
						Thread.sleep(10000);     //Descanso entre oleadas
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
