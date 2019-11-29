package gui;

import Objetos.Objeto;
import stateObjetos.EstadoObjetoAtaca;

public class HiloVelocidadAtaqueObjeto extends Thread {

	protected Objeto miObjeto;
	
	public HiloVelocidadAtaqueObjeto(Objeto o) {
		miObjeto=o;
	}
	
	public void run() {
			try {
				Thread.sleep(3000);
				miObjeto.setEstadoObjeto(new EstadoObjetoAtaca(miObjeto));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
