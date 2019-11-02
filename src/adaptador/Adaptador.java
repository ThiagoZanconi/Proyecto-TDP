package adaptador;

import enemigos.Enemigo;
import gui.GUI;
import juego.Elemento;
import juego.Elementos;
import juego.Juego;
import juego.Nivel;
import juego.Personaje;
/**
 * Se utiliza para comunicar a los elementos con la clase Elementos para que solo tengan acceso a las operaciones necesarias
 * @author Usuario Final
 *
 */
public final class Adaptador {
	protected static Juego juego;
	protected static GUI gui;
	protected static Elementos elementos;
	protected static final Adaptador adaptador=new Adaptador();
	protected Nivel nivel;
	
	private Adaptador() {
		elementos=Elementos.getElementos();
		gui=GUI.getGUI();
		juego=Juego.getJuego();
		nivel=juego.getNivel();
	}
	
	public static Adaptador getAdaptador() {
		return adaptador;
	}
	
	public void eliminarElemento(Elemento e) {
		elementos.eliminarElemento(e);
	}
	
	public void añadirElemento(Elemento e) {
		elementos.añadirElemento(e);
		gui.getVentanaJuego().add(e.getGrafico(),0);
	}
	
	public void chequearColisionDeAtaques(Personaje p) {
		elementos.chequearColisionDeAtaques(p);
	}
	
	public void chequearColision(Elemento e1,Elemento e2) {
		elementos.chequearColision(e1,e2);
	}	
	
	public Enemigo generarEnemigoAleatorio(int x,int y) {
		return nivel.generarEnemigoAleatorio(x,y);
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
	
	public void actualizarMonedas(int cantidad) {
		juego.actualizarMonedas(cantidad);
	}
	
	public void crearDisparoEnemigo(Enemigo e) {
		
	}

	public void terminarJuego() {
		nivel.detenerJuego();	
		//gui.menuPrincipal();
	}
	
}
