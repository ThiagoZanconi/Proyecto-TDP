package MagiasTemporalesStrategy;

import juego.Personaje;

public class CampoDeProteccion extends Strategy{

	public CampoDeProteccion() {
		
	}
	
	public void estrategia(Personaje personaje) {
		personaje.destruir();
	}

}
