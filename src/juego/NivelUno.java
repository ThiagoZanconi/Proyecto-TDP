package juego;

import aliadoFactory.AbstractAliadoFactory;
import aliadoFactory.BallestaFactory;
import aliadoFactory.BarricadaFactory;
import aliadoFactory.EscuderoFactory;
import aliadoFactory.GuerreroFactory;
import aliadoFactory.MagoDeFuegoFactory;
import aliadoFactory.MagoDeHieloFactory;

public class NivelUno {
	protected String aliadoACrear;
	
	public NivelUno() {
		aliadoACrear="Guerrero";
	}	
	
	public AbstractAliadoFactory instanciarBoton() {
		AbstractAliadoFactory toReturn=null;
		switch (aliadoACrear) {
		case "Guerrero":
			toReturn=new GuerreroFactory();
			toReturn.setText("Guerrero");
			aliadoACrear="Ballesta";
			break;
		case "Ballesta":
			toReturn=new BallestaFactory();
			toReturn.setText("Ballesta");
			aliadoACrear="MagoDeHielo";
			break;
		case "MagoDeHielo":
			toReturn=new MagoDeHieloFactory();
			toReturn.setText("MagoDeHielo");
			aliadoACrear="MagoDeFuego";
			break;
		case "MagoDeFuego":
			toReturn=new MagoDeFuegoFactory();
			toReturn.setText("MagoDeFuego");
			aliadoACrear="Escudero";
			break;
		case "Escudero":
			toReturn=new EscuderoFactory();
			toReturn.setText("Escudero");
			aliadoACrear="Barricada";
			break;	
		case "Barricada":
			toReturn=new BarricadaFactory();
			toReturn.setText("Barricada");
			aliadoACrear="Guerrero";
			break;	
		}	
		return toReturn;
	}
	

}
