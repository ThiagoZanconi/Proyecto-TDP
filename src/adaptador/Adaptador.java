package adaptador;

import javax.swing.JLabel;

import disparos.Disparo;
import gui.GUI;
import juego.Elemento;
import juego.Elementos;
import juego.Juego;
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
	
	public void a�adirDisparo(Disparo d) {
		elementos.a�adirElemento(d);
	}
	
	protected void a�adirElementoGrafico(JLabel j) {
		
	}
	
	
	

}
