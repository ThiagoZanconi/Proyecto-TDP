package MagiasTemporalesStrategy;

import juego.Personaje;

public class Bendicion extends Strategy{

	public void estrategia(Personaje personaje) {
		int da�o=-10;
		personaje.recibirDa�o(da�o);
	}

	public boolean afectaUsuario() {
		return true;
	}

	public String obtenerSprite() {
		return "Sprites\\bendicion.png";
	}

}
