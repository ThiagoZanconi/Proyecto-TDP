package adaptador;

import juego.Elemento;
import juego.Elementos;

public class Adaptador {
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
	
	
	

}
