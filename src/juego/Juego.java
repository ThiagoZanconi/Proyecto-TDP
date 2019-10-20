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
		elementos=elementos.getElementos();
		return juego;
	}
	/**
	 * 
	 */
	
	public void mover() {
		for(int i=0;i<elementos.size();i++) {
			for(int j=i+1;j<elementos.size();j++) {
				elementos.chequearColision(elementos.getElemento(i),elementos.getElemento(j));
			}
		}
		
	}
	
	

}
