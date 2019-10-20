package aliados;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import juego.*;
import visitor.VisitorAliado;
public class Ballesta extends Aliado {
	
	public Ballesta(int x,int y) {
		super(200,1000,500,150);
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Ballista_Turret.png"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, 50, 50);
		
		rectangulo=new Rectangle(x,y,100,50);
		miVisitor=new VisitorAliado(this);
		miDisparo=new Disparo(x,y);
		
	}
	
	public void disparar(List<Disparo> l,JFrame ventanaJuego) {
		
		l.add(l.size(), miDisparo);
		
		
	}

}
