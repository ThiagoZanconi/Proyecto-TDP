package juego;
import gui.*;
public final class Juego {
	
	protected static Tienda tienda;
	protected static GUI gui;
	protected static Elementos elementos;
	protected static Elemento[][] mapa;
	protected static final Juego juego=new Juego(gui);
	
	private Juego(GUI gui) {
		mapa=(Elemento[][])new Elemento[1000][1000];
		 
		this.gui=gui;
		
	}
	
	public static Juego getJuego(Tienda t,GUI g) {
		tienda=t;
		gui=g;
		elementos=new Elementos();
		return juego;
		
		
	}

}
