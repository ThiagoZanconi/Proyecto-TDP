package juego;

import java.util.LinkedList;
import java.util.List;

public class Elementos {
	protected List<Elemento> elementos;
	
	public Elementos() {
		elementos=new LinkedList<Elemento>();
			
	}
		
	public List<Elemento> getElementos() {
		return elementos;
	}
	
	
}
