package juego;
import gui.*;
public final class Juego {
	
	protected static Tienda tienda;
	protected static GUI gui;
	protected static Elementos elementos;
	protected static final Juego juego=new Juego(gui);
	
	private Juego(GUI gui) {
		tienda=new Tienda();
		gui=gui;
		
	}
	
	public static Juego getJuego(GUI g) {
		gui=g;
		elementos=new Elementos();
		return juego;
	}
	/**
	 * 
	 */
	
	public void mover() {
		int i=0;
		while(i<elementos.size()) {
			for(int j=i;i<elementos.size();i++) {
				elementos.chequearColision(elementos.getElemento(i),elementos.getElemento(j));
			}
		}
		i++;
	}
	
	

}
