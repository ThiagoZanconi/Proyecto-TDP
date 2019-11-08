package gui;

import Objetos.ObstaculoTemporal;
import juego.Elemento;

public class HiloDuracionObjeto extends Thread{
	protected boolean run;
	protected int duracion;
	protected Elemento miObstaculoTemporal;
	
	public HiloDuracionObjeto(ObstaculoTemporal o,int d) {
		run=true;
		miObstaculoTemporal=o;
		duracion=d;	
	}
	
	public void run() {
		while(run){
			try {
				Thread.sleep(duracion);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			run=false;
			miObstaculoTemporal.destruir();
		}
	}

}
