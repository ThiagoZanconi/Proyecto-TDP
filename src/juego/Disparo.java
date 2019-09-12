package juego;

public class Disparo extends Elemento {
	
	
	protected int daño;
	protected int velocidad;
	
	
	public Disparo(int daño, int velocidad) {
		super(-1);
		this.daño=daño;
		this.velocidad=velocidad;
		
	}
	
	
}
