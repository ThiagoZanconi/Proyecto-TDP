package MagiasTemporalesStrategy;

import juego.Personaje;

public class Bendicion extends Strategy{

	public void estrategia(Personaje personaje) {
		personaje.recibirDa�o(-10);
	}

	public boolean afectaUsuario() {
		return true;
	}

	public String obtenerSprite() {
		return "Sprites\\bendicion.png";
	}

}
