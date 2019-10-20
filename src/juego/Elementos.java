package juego;

import java.util.LinkedList;
import java.util.List;

public final class Elementos {
	protected static final Elementos self=new Elementos();
	protected static List<Elemento> elementos;
	
	private Elementos() {
		elementos=new LinkedList<Elemento>();
	}
	
	public static Elementos getElementos() {
		return self;
	}
	
	public int size() {
		return elementos.size();
	}
	
	public Elemento getElemento(int i) {
		return elementos.get(i);
	}
	
	public void añadirElemento(Elemento e) {
		elementos.add(elementos.size(),e);
	}
	
	public void chequearColision(Elemento e1,Elemento e2) {
		if(e1.getRectangulo().intersects(e2.getRectangulo())) {
			e2.aceptar(e1.getVisitor());
		}
	}
	
	public void eliminarElemento(Elemento e) {
		elementos.remove(e);
		e=null;
	}
	
	
	
}
