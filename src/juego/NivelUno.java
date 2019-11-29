package juego;

import gui.HiloAparicionEnemigos;

public final class NivelUno extends Nivel {
	
	public NivelUno(Juego j) {
		super(j);	
		hiloAparicionEnemigos=new HiloAparicionEnemigos(juego,7000,20);
	}

}
