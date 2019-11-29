package Objetos;

import juego.Elemento;
import stateObjetos.EstadoObjeto;
import stateObjetos.EstadoObjetoAtaca;

public abstract class Objeto extends Elemento{
	protected EstadoObjeto estado;

	public Objeto() {
		super();
		estado=new EstadoObjetoAtaca(this);
	}

	public String esUn() {
		return "Objeto";
	}
	
	public void setEstadoObjeto(EstadoObjeto e) {
		estado=e;
	}
	
}
