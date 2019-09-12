package juego;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aliados.*;

public class Tienda {
	
	public Tienda() {
		
	}
	
	public ImageIcon crearGuerrero() {
		System.out.println("arreglo");
		Guerrero guerrero=new Guerrero();
		ImageIcon grafico=guerrero.getImage();
		//grafico.setBounds(50, 50,guerrero.getAncho()+500 ,guerrero.getLargo()+500);
		return grafico;
	}
	
	
		
	

}
