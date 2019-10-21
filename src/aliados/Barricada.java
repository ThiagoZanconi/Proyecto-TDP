package aliados;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparos.Disparo;
import juego.*;
import visitor.VisitorAliado;

public class Barricada extends Aliado {

	public Barricada(int x,int y) {
		super(0,0,0,5000);
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Barricada\\Barricada.png"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, 50, 50);
		
		rectangulo=new Rectangle(x,y,80,160);
		miVisitor=new VisitorAliado(this);
		miDisparo=new Disparo(x,y);
	}
	
	
	public void disparar(List<Disparo> l) {
		
	}

}
