package juego;
import gui.*;
public final class Juego {
	
	protected static Tienda tienda;
	protected static GUI gui;
	protected static Mapa mapa;
	private static final Juego juego=new Juego(gui);
	
	private Juego(GUI gui) {
		this.gui=gui;
		
	}
	
	public static Juego getJuego(Tienda t,GUI g,Mapa m) {
		tienda=t;
		gui=g;
		mapa=m;
		return juego;
		
	}

}
