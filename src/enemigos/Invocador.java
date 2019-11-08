package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.HiloVelocidadAtaque;
import visitor.VisitorEnemigo;

public class Invocador extends Enemigo {

	public Invocador(int x, int y) {
		super(10,100,450,100);
		cantidadMonedas=400;
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Invocador\\InvocadorSummon.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x,y,1000,1000);
		alcanceDeAtaque=new Rectangle(x,y,80,70);
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorEnemigo(this);
	}
	
	public void actividadSinColision(){
		adaptador.chequearColisionDeAtaques(this);
		mover();
		invocar();
	}
	
	public void atacar() {
		
	}
	
	public void invocar() {
		if(puedeAtacar) {
			Enemigo x=adaptador.generarEnemigoAleatorio((int)rectangulo.getX() + 100,(int)rectangulo.getY());
			adaptador.añadirElemento(x);
			HiloVelocidadAtaque hilo=new HiloVelocidadAtaque(this);
			hilo.start();
		}
		
	}

}
