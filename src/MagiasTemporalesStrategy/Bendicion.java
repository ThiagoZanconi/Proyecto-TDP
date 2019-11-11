package MagiasTemporalesStrategy;

import juego.Personaje;

public class Bendicion extends Strategy{

	public void estrategia(Personaje personaje) {
		int daño=-10;
		personaje.recibirDaño(daño);
	}

	public boolean afectaUsuario() {
		return true;
	}

	public String obtenerSprite() {
		return "Sprites\\bendicion.png";
	}

}
