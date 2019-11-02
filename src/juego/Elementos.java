package juego;

import java.util.LinkedList;
import java.util.List;
/**
 * Clase que contiene a todos los elementos del mapa y se encarga de llevar a cabo las colisiones entre los mismos
 * @author Usuario Final
 *
 */

public class Elementos {
	protected List<Elemento> elementos;
	protected List<Elemento> elementosAEliminar;
	
	public Elementos() {
		elementos=new LinkedList<Elemento>();
		elementosAEliminar=new LinkedList<Elemento>();
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
	
	public void chequearColisionDeAtaques(Personaje p) {
		for(int i=0;i<elementos.size();i++) {
			if(p!=elementos.get(i)) {
				if(p.getAlcanceDeAtaque().intersects(elementos.get(i).getRectangulo())) {
					elementos.get(i).aceptar(p.getVisitorAlcance());
				}
			}
		}
	}
	
	
	
}
