package MagiasTemporalesStrategy;

import juego.Personaje;

public class MagiaNula extends Strategy{

	public MagiaNula() {
		
	}
	
	public void estrategia(Personaje personaje) {
		//Es la magia por defecto, no hace nada
	}
	
	public boolean afectaUsuario() {
		return false;
	}

	public String obtenerSprite() {
		return " ";
	}
}
