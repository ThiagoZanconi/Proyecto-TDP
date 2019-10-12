package juego;
import gui.*;
public final class Juego {
	
	protected static Tienda tienda;
	protected static GUI gui;
	protected static Elementos elementos;
	private static final Juego juego=new Juego(gui);
	
	private Juego(GUI gui) {
		this.gui=gui;
		
	}
	
	public static Juego getJuego(Tienda t,GUI g) {
		tienda=t;
		gui=g;
		elementos=new Elementos();
		return juego;
		
	}

}
