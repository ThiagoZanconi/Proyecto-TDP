package adaptador;

import javax.swing.JLabel;

import gui.GUI;
import juego.Elemento;
import juego.Elementos;
import juego.Personaje;
/**
 * Se utiliza para comunicar a los elementos con la clase Elementos para que solo tengan acceso a las operaciones necesarias
 * @author Usuario Final
 *
 */
public final class Adaptador {
	protected static GUI gui;
	protected static Elementos elementos;
	protected static final Adaptador adaptador=new Adaptador();
	
	private Adaptador() {
		elementos=elementos.getElementos();
		gui=gui.getGUI();
	}
	
	public static Adaptador getAdaptador() {
		return adaptador;
	}
	
	public void eliminarElemento(Elemento e) {
		elementos.eliminarElemento(e);
	}
	
	public void chequearColisionDeAtaques(Personaje p) {
		elementos.chequearColisionDeAtaques(p);
	}
	
	public void añadirElemento(Elemento e) {
		elementos.añadirElemento(e);
		agregarElementoGrafico(e.getGrafico());
	}
	
	protected void agregarElementoGrafico(JLabel j) {
		gui.agregarElementoGrafico(j);	
	}
	
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
