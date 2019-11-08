package Objetos;

import MagiasTemporalesStrategy.Strategy;
import juego.Personaje;
import visitor.Visitor;

public class MagiaTemporal extends Premio{

	protected Personaje miPersonaje;
	protected Strategy tipoDeMagia;
	protected boolean afectaUsuario;
	
	public MagiaTemporal(int v,Personaje personaje) {
		super(-1);
		miPersonaje=personaje;
		rectangulo.setBounds(miPersonaje.getRectangulo().x-1, miPersonaje.getRectangulo().y, miPersonaje.getRectangulo().width, miPersonaje.getRectangulo().height);
	}

	public void setStrategy(Strategy strategy,boolean afecta) {
		tipoDeMagia=strategy;
		afectaUsuario=afecta;
	}
	
	public boolean afectaUsuario() {
		return afectaUsuario;
	}
	
	public Personaje getPersonaje() {
		return miPersonaje;
	}
	
	public void performStrategy(Personaje p) {
		tipoDeMagia.estrategia(p);
	}
	
	@Override
	public void aceptar(Visitor v) {
		
		
	}

	@Override
	public void actividadSinColision() {
		// TODO Auto-generated method stub
		
	}
}
