package visitor;

import juego.Personaje;

public class hiloVelocidadAtaque extends Thread {
	protected Personaje p;
	
	public hiloVelocidadAtaque(Personaje x) {
		p=x;
	}
	
	public void run() {
		p.setPuedeAtacar(false);
		try {
			sleep(3000);
			p.setPuedeAtacar(true);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
