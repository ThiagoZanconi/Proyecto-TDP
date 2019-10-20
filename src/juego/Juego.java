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
				chequearColision(elementos.getElemento(i),elementos.getElemento(j));
				chequearColision(elementos.getElemento(j),elementos.getElemento(i));
			}
			elementos.getElemento(i).actividadSinColision();
		}
		elementos.eliminar();
	}
	
	/**
	 * Chequea la colision entre dos elementos e1 y e2 (Si hay colision se ejecutan las operaciones correspondientes a la colision en cuestion)
	 * @param e1
	 * @param e2
	 */
	
	public void chequearColision(Elemento e1,Elemento e2) {
		elementos.chequearColision(e1,e2);
	}
	
	
	/**
	 * Chequea la colision de un elemento con todos los otros elementos
	 * @param e1
	 */
	public void chequearColision(Elemento e1) {
		for(int i=0;i<elementos.size();i++) {
			if(e1!=elementos.getElemento(i)) {
				chequearColision(elementos.getElemento(i),e1);
			}
			
		}
	}
	
	

}
