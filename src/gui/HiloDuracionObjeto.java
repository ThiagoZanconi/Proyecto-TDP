package gui;

import Objetos.Objeto;

public class HiloDuracionObjeto extends Thread{
	protected boolean run;
	protected int duracion;
	protected Objeto miObjeto;
	
	public HiloDuracionObjeto(Objeto o,int d) {
		run=true;
		miObjeto=o;
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
			miObjeto.destruir();
		}
	}

}
