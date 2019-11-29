package juego;

import gui.HiloAparicionEnemigos;

public class NivelDos extends Nivel {
	
	public NivelDos(Juego j) {
		super(j);
		hiloAparicionEnemigos=new HiloAparicionEnemigos(juego,6000,25);
	}
	
}
