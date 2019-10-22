package aliados;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import disparos.Disparo;
import juego.*;
import visitor.VisitorAliado;
public class Guerrero extends Aliado {
	public Guerrero(int x,int y) {
		super(100,100,100,100);
		this.imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Guerrero\\GuerreroAttack.gif"));
		
		this.graficoActual = new JLabel();
		this.graficoActual.setIcon(imagenes[0].getIcon());
		this.graficoActual.setBounds(100, 100, 50, 50);
		alcanceDeAtaque=new Rectangle(x,y,120,80);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorAliado(this);
	}
	
	public void atacar() {
		
	}

}
