package MagiasTemporalesStrategy;

import juego.Personaje;

public class campoDeProteccion extends Strategy{

	public void estrategia(Personaje personaje) {
		personaje.destruir();
	}

}
