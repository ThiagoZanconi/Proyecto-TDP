package adaptador;

import disparos.Disparo;
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
	protected static Elementos elementos;
	protected static final Adaptador adaptador=new Adaptador();
	
	private Adaptador() {
		elementos=elementos.getElementos();
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
	
	public void añadirDisparo(Disparo d) {
		elementos.añadirElemento(d);
	}
	
	
	

}
