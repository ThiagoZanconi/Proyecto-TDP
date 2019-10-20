package juego;

import java.util.LinkedList;
import java.util.List;

public final class Elementos {
	protected static final Elementos self=new Elementos();
	protected static List<Elemento> elementos;
	protected static List<Elemento> elementosAEliminar;
	
	private Elementos() {
		elementos=new LinkedList<Elemento>();
		elementosAEliminar=new LinkedList<Elemento>();
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
	
	public void eliminar() {
		for(int i=0;i<elementosAEliminar.size();i++) {
			Elemento aEliminar=elementosAEliminar.get(i);
			elementos.remove(aEliminar);
			elementosAEliminar.remove(aEliminar);
			aEliminar=null;
		}
		
	}
	
	public void eliminarElemento(Elemento e) {
		elementosAEliminar.add(elementosAEliminar.size(), e);
		
	}
	
	
	
}
