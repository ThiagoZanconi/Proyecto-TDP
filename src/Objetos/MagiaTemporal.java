package Objetos;

import MagiasTemporalesStrategy.Strategy;
import juego.Personaje;
import visitor.Visitor;

public class MagiaTemporal extends Premio{

	protected Personaje miPersonaje;
	protected Strategy tipoDeMagia;
	
	public MagiaTemporal(int v,Personaje personaje) {
		super(-1);
		miPersonaje=personaje;
		rectangulo.setBounds(miPersonaje.getRectangulo().x-1, miPersonaje.getRectangulo().y, miPersonaje.getRectangulo().width, miPersonaje.getRectangulo().height);
	}

	public void setStrategy(Strategy strategy) {
		tipoDeMagia=strategy;
	}
	
	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actividadSinColision() {
		// TODO Auto-generated method stub
		
	}
}
