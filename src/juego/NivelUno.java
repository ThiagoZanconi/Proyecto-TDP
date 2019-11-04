package juego;

import gui.Hilo;
import gui.HiloAparicionEnemigos;

public final class NivelUno extends Nivel {
	protected HiloAparicionEnemigos hiloAparicionEnemigos;
	protected Hilo hiloGeneral;
	public NivelUno(Juego j) {
		super(j);	
		hiloAparicionEnemigos=new HiloAparicionEnemigos(juego);
		hiloGeneral=new Hilo(juego);
	}
	
	public void iniciar() {
		hiloGeneral.start();
		hiloAparicionEnemigos.start();	
	}
	
	@Override
	public void detenerJuego() {
		hiloGeneral.detenerHilo();
		hiloAparicionEnemigos.detenerHilo();
		//hiloGeneral.interrupt();
		//hiloAparicionEnemigos.interrupt();
	}
	

}
