package stateObjetos;

import Objetos.Objeto;
import juego.Personaje;

public abstract class EstadoObjeto {
	protected Objeto miObjeto;
	
	public EstadoObjeto(Objeto o) {
		miObjeto=o;
	}
	
	public abstract void atacar(int d,Personaje p);

}
