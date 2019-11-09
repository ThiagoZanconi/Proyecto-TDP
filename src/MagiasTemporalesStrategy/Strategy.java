package MagiasTemporalesStrategy;

import juego.Personaje;

public abstract class Strategy {

	public abstract void estrategia(Personaje personaje);
	public abstract boolean afectaUsuario();
	public abstract String obtenerSprite();
	
}
