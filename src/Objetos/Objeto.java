package Objetos;

import juego.Elemento;

public abstract class Objeto extends Elemento{

	public Objeto(int v) {
		super(v);
	}

	public String esUn() {
		return "Objeto";
	}
	
}
