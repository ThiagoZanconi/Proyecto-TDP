package adaptador;

import javax.swing.JLabel;

import enemigos.Enemigo;
import gui.GUI;
import juego.Elemento;
import juego.Elementos;
import juego.Juego;
import juego.Nivel;
import juego.Personaje;
import juego.Tienda;
import stateTiendaPremios.EstadoTienda;
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
	protected Tienda tienda;
	
	private Adaptador() {
		gui=GUI.getGUI();
		juego=Juego.getJuego();
	}
	
	public static Adaptador getAdaptador() {
		return adaptador;
	}
	
	public void instanciarAtributos(Elementos e,Nivel n,Tienda t) {
		nivel=n;
		elementos=e;
		tienda=t;
	}
	
	public void eliminarElemento(Elemento e) {
		elementos.eliminarElemento(e);
	}
	
	public void añadirElemento(Elemento e) {
		elementos.añadirElemento(e);
		añadirElementoGrafico(e.getGrafico());
	}
	
	public void añadirElementoGrafico(JLabel j) {
		gui.getVentanaJuego().add(j,0);
	}
	
	public void eliminarElementoGrafico(JLabel j) {
		gui.getVentanaJuego().remove(j);
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
		tienda.actualizarMonedas(cantidad);
	}
	
	public int[] traducirCoordenadas(int x,int y) {
		return tienda.traducirCoordenadas(x, y);
	}
	
	public boolean hayQueVender() {
		return tienda.getVender();
	}
	
	public boolean getAñadirCampo() {
		return tienda.getAñadirCampo();
	}
	
	public void añadirCampo(boolean b) {
		tienda.crearCampo(b);
	}
	
	public void setCrearPremio(boolean b) {
		tienda.setCrearPremio(b);
		
	}
	
	public void huboVenta(int c) {
		actualizarMonedas(c);
		tienda.setVender(false);
	}
	
	public void setEstadoTienda(EstadoTienda e) {
		tienda.setEstado(e);
	}
	
	public void terminarJuego() {
		nivel.detenerJuego();
	}
	
	public void volverMenuPrincipal() {
		gui.getVentanaJuego().setVisible(false);
		gui.menuPrincipal();
	}
	
}
