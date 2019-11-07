package gui;

import juego.Juego;

public class HiloAparicionEnemigosNivelUno extends HiloAparicionEnemigos {

	public HiloAparicionEnemigosNivelUno(Juego j) {
		super(j);
		spawnEnemigos=7000;
		proximaOleada=20;
	}

}
