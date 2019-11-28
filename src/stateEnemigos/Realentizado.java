package stateEnemigos;

import enemigos.Enemigo;

public class Realentizado extends EstadoVelocidad {

	public Realentizado(Enemigo e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int velocidad() {
		return miEnemigo.getVelocidadNormal()-1;
		// TODO Auto-generated method stub
		
	}

}
