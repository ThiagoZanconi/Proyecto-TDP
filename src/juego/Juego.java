package juego;
import enemigos.Enemigo;
import gui.*;

public final class Juego {
	
	protected static Tienda tienda;
	protected static GUI gui;
	protected static Elementos elementos;
	protected static final Juego juego=new Juego();
	protected static HiloAparicionEnemigos hiloAparicionEnemigos;
	protected static Hilo hiloGeneral;
	protected static Nivel nivel;
	
	private Juego() {
		elementos=Elementos.getElementos();
	}
	
	public static Juego getJuego() {
		return juego;
	}
	
	public void iniciarNivelUno() {
		gui=GUI.getGUI();
		nivel=new NivelUno(this);
		tienda=new Tienda(nivel);
		Elemento elementoDerrota=new ElementoDerrota();
		elementos.añadirElemento(elementoDerrota);
	}
	
	public void iniciarNivelDos() {
		
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public void generarEnemigoAleatorio() {
		Enemigo enemigo=nivel.generarEnemigoAleatorio();
		elementos.añadirElemento(enemigo);
		gui.getVentanaJuego().add(enemigo.getGrafico(),0);
	}
	
	public void actualizarMonedas(int cantidad) {
		tienda.actualizarMonedas(cantidad);
	}
	/**
	 * 
	 */
	public void mover() {
		for(int i=0;i<elementos.size();i++) {
			elementos.getElemento(i).actividadSinColision();
			for(int j=i+1;j<elementos.size();j++) {
				elementos.chequearColision(elementos.getElemento(i),elementos.getElemento(j));
			}	
		}
		elementos.eliminar();
		actualizarMonedas(1);
	}

}
