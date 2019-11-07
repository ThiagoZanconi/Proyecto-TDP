package gui;

import juego.Juego;

public class HiloAparicionEnemigosNivelDos extends HiloAparicionEnemigos {

	public HiloAparicionEnemigosNivelDos(Juego j) {
		super(j);
		spawnEnemigos=6000;
		proximaOleada=25;
	}

}
