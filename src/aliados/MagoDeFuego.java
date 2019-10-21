package aliados;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.*;
import visitor.VisitorAliado;

public class MagoDeFuego extends Aliado {

	public MagoDeFuego(int x,int y) {
		super(100,100,100,100);
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\MagoDeFuego\\MagoFIdle.gif"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, 50, 50);
		
		rectangulo=new Rectangle(x,y,50,20);
		miVisitor=new VisitorAliado(this);
		miDisparo=new Disparo(x,y);
	}
	
	public void disparar(List<Disparo> l) {
		
	}

}
