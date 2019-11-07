package juego;

import gui.HiloAparicionEnemigosNivelUno;

public final class NivelUno extends Nivel {
	
	public NivelUno(Juego j) {
		super(j);	
		hiloAparicionEnemigos=new HiloAparicionEnemigosNivelUno(juego);
	}

}
