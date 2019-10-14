package juego;

import java.util.LinkedList;
import java.util.List;

public class Elementos {
	protected List<Enemigo> enemigos;
	protected List<Aliado> aliados;
	protected List<Disparo> disparos;
	
	public Elementos() {
		enemigos=new LinkedList<Enemigo>();
		aliados=new LinkedList<Aliado>();
		disparos=new LinkedList<Disparo>();
	}
	
	public void añadirAliado(Aliado a) {
		aliados.add(aliados.size(), a);
	}
	
	public void añadirEnemigo(Enemigo e) {
		enemigos.add(enemigos.size(), e);
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
			
			
		}
		return toReturn;
	}
	
	
	
}
