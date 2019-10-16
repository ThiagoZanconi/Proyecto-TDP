package juego;

import java.util.LinkedList;
import java.util.List;

public class Elementos {
	protected List<Elemento> elementos;
	protected List<Enemigo> enemigos;
	protected List<Aliado> aliados;
	protected List<Disparo> disparos;
	
	public Elementos() {
		enemigos=new LinkedList<Enemigo>();
		aliados=new LinkedList<Aliado>();
		disparos=new LinkedList<Disparo>();
		elementos=new LinkedList<Elemento>();
	}
	
	public void a�adirElemento(Elemento e) {
		elementos.add(elementos.size(),e);
	}
	
	public void a�adirAliado(Aliado a) {
		aliados.add(aliados.size(), a);
	}
	
	public void a�adirEnemigo(Enemigo e) {
		enemigos.add(enemigos.size(), e);
	}
	
	public List<Elemento> getElementos(){
		return elementos;
	}
		
	public List<Enemigo> getEnemigos() {
		return enemigos;
	}
	
	public List<Aliado> getAliados() {
		return aliados;
	}
	
	public List<Disparo> getDisparos() {
		return disparos;
	}
	
	public boolean chequearColision(Elemento e) {
		boolean toReturn=false;
		for(int i=0;i<aliados.size();i++) {
			if(e.getRectangulo().intersects(aliados.get(i).getRectangulo())) {
				e.aceptar(aliados.get(i).getVisitor());
				toReturn=true;
			}
			
			
		}
		return toReturn;
	}
	
	
	
}
