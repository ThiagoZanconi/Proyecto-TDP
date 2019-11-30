package Objetos;

import juego.Elemento;
import stateObjetos.EstadoObjeto;
import stateObjetos.EstadoObjetoAtaca;

public abstract class Objeto extends Elemento{
	protected EstadoObjeto estado;
	protected int costoMonedas;
	protected boolean colisiono;

	public Objeto() {
		super();
		estado=new EstadoObjetoAtaca(this);
	}
	
	public int getCostoMonedas() {
		return costoMonedas;
	}

	public void setEstadoObjeto(EstadoObjeto e) {
		estado=e;
	}
	
	public boolean getColisiono() {
		return colisiono;
	}
	
	public void setColisiono(boolean b) {
		colisiono=b;
	}
	
}
