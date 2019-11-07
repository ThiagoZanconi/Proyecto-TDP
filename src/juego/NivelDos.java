package juego;

import gui.HiloAparicionEnemigosNivelDos;

public class NivelDos extends Nivel {
	
	public NivelDos(Juego j) {
		super(j);
		hiloAparicionEnemigos=new HiloAparicionEnemigosNivelDos(juego);
	}
	
}
