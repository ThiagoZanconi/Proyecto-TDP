package gui;

import Objetos.Lago;

public class HiloAtaqueLago extends Thread{
	protected Lago miLago;
	
	public HiloAtaqueLago(Lago l) {
		miLago=l;
	}
	
	public void run() {
			miLago.setPuedeAtacar(false);
			try {
				Thread.sleep(3000);
				miLago.setPuedeAtacar(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		
	}

}
