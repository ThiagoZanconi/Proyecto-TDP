package juego;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aliados.*;

public class Tienda {
	public JLabel crearGuerrero() {
		Guerrero guerrero=new Guerrero();
		JLabel grafico=guerrero.getGrafico();
		grafico.setBounds(50, 50,guerrero.getAncho() ,guerrero.getLargo());
		return grafico;
	}
	
	
		
	

}
