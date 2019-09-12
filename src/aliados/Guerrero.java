package aliados;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
public class Guerrero extends Aliado {
	public Guerrero() {
		super(40,1,500);
		this.imagenes[0] = new ImageIcon(this.getClass().getResource("/sprites/Guerrero.png"));
		this.grafico = new JLabel(imagenes[0]);
		this.grafico.setBounds(100, 100, tamaņoAncho, tamaņoLargo);
	}
	
	public JLabel getGrafico(){
		
		return this.grafico;
	}
	
	public int getAncho() {
		return tamaņoAncho;
	}
	
	public int getLargo() {
		return tamaņoLargo;
	}

}
