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
		
	public List<Enemigo> getEnemigos() {
		return enemigos;
	}
	
	public List<Aliado> getAliados() {
		return aliados;
	}
	
	public List<Disparo> getDisparos() {
		return disparos;
	}
	
	public void chequearColisiones() {
		
	}
	
	
	
}
