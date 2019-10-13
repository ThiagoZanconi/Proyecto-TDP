package aliados;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
public class Guerrero extends Aliado {
	public Guerrero() {
		super(100,100,100,100);
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\GuerreroAtacando.gif"));
		
		this.grafico = new JLabel();
		this.grafico.setIcon(imagenes[0].getIcon());
		this.grafico.setBounds(100, 100, tama�oAncho, tama�oLargo);
	}
	
	public JLabel getGrafico(){
		
		return this.grafico;
	}
	
	public int getAncho() {
		return tama�oAncho;
	}
	
	public int getLargo() {
		return tama�oLargo;
	}

}
