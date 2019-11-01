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
	protected static NivelUno nivel;
	
	private Juego() {
		elementos=Elementos.getElementos();
	}
	
	public static Juego getJuego() {
		return juego;
	}
	
	public void iniciarJuego() {
		gui=GUI.getGUI();
		nivel=new NivelUno();
		tienda=new Tienda(nivel);
		hiloAparicionEnemigos=new HiloAparicionEnemigos(this);
		hiloGeneral=new Hilo(this);
		hiloGeneral.start();
		hiloAparicionEnemigos.start();
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public void generarEnemigoAleatorio() {
		Enemigo enemigo=nivel.generarEnemigoAleatorio();
		elementos.añadirElemento(enemigo);
		gui.getVentanaJuego().add(enemigo.getGrafico(),0);
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
	}

}
