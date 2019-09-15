package aliados;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
public class Guerrero extends Aliado {
	public Guerrero() {
		super(100,100,100,100);
		this.imagenes[0] = new ImageIcon("//Sprites//Guerrero.png");
		this.grafico = new JLabel(imagenes[0]);
		this.grafico.setIcon(imagenes[0]);
		this.grafico.setBounds(100, 100, tama�oAncho, tama�oLargo);
	}
	
	public JLabel getGrafico(){
		
		return this.grafico;
	}
	
	public ImageIcon getImage() {
		return this.imagenes[0];
	}
	
	public int getAncho() {
		return tama�oAncho;
	}
	
	public int getLargo() {
		return tama�oLargo;
	}

}
