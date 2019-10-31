package juego;

import aliadoFactory.AbstractAliadoFactory;
import aliadoFactory.BallestaFactory;
import aliadoFactory.BarricadaFactory;
import aliadoFactory.EscuderoFactory;
import aliadoFactory.GuerreroFactory;
import aliadoFactory.MagoDeFuegoFactory;
import aliadoFactory.MagoDeHieloFactory;

public class Nivel {
	
	
	
	public Nivel() {
		
	}
	
	public void instanciarBotones(AbstractAliadoFactory[] botones) {
		botones[0]=new GuerreroFactory();
		botones[0].setText("Guerrero");
		
		botones[1]=new BallestaFactory();
		botones[1].setText("Ballesta");
		
		botones[2]=new MagoDeHieloFactory();
		botones[2].setText("MagoDeHielo");
		
		botones[3]=new MagoDeFuegoFactory();
		botones[3].setText("MagoDeFuego");
		
		botones[4]=new EscuderoFactory();
		botones[4].setText("Escudero");
		
		botones[5]=new BarricadaFactory();
		botones[5].setText("Barricada");
	}
	
	public AbstractAliadoFactory instanciarBoton() {
		AbstractAliadoFactory x=new GuerreroFactory();
		x.setText("Guerrero");
		return x;
	}
	

}
