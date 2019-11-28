package stateEnemigos;

import enemigos.Enemigo;

public abstract class EstadoVelocidad {
	protected Enemigo miEnemigo;
	
	public EstadoVelocidad(Enemigo e) {
		miEnemigo=e;
	}
	
	public abstract int velocidad();

}
