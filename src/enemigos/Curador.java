package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparos.Disparo;
import disparos.DisparoRango;
import visitor.VisitorEnemigo;
public class Curador extends Enemigo {

	public Curador(int x, int y) {
		super(x,y);
		fuerzaDeImpacto=10;
		alcance=100;
		vidaMaxima=650;
		vida=vidaMaxima;
		velocidadDeProyectil=100;
		cantidadMonedas=150;
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Curador\\CuradorWalk.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x, y, 1000, 1000);
		alcanceDeAtaque=new Rectangle(x,y,700,70);
		miVisitor=new VisitorEnemigo(this);
	}
	
	//Falta Implementar Ataque de curador
	public void generarDisparo() {
		Disparo x=new DisparoRango((int)rectangulo.getX(),(int)rectangulo.getY(),this.getFuerzaDeImpacto(),(int)alcanceDeAtaque.getWidth());
		adaptador.añadirElemento(x);
	}
}
