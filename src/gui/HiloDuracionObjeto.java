package gui;

import juego.Elemento;

public class HiloDuracionObjeto extends Thread{
	protected boolean run;
	protected int duracion;
	protected Elemento miElemento;
	
	public HiloDuracionObjeto(Elemento e,int d) {
		run=true;
		miElemento=e;
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
			miElemento.destruir();
		}
	}

}
