package enemigos;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.HiloVelocidadAtaque;
import visitor.VisitorEnemigo;

public class Invocador extends Enemigo {

	public Invocador(int x, int y) {
		super(x,y);
		fuerzaDeImpacto=10;
		alcance=100;
		vidaMaxima=450;
		vida=vidaMaxima;
		velocidadDeProyectil=100;
		cantidadMonedas=400;
		enMovimiento=true;
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon("Sprites\\Invocador\\InvocadorSummon.gif"));
		graficoActual = new JLabel();
		graficoActual.setIcon(imagenes[0].getIcon());
		graficoActual.setBounds(x,y,1000,1000);
		alcanceDeAtaque=new Rectangle(x,y,80,70);
		miVisitor=new VisitorEnemigo(this);
	}
	
	public void actividadSinColision(){
		adaptador.chequearColisionDeAtaques(this);
		mover();
		estado.atacar();
	}
	
	public void generarDisparo() {//En el caso del invocador no genera disparos, sino enemigos
		Enemigo x=adaptador.generarEnemigoAleatorio((int)rectangulo.getX() + 100,(int)rectangulo.getY());
		adaptador.añadirElemento(x);
		HiloVelocidadAtaque hilo=new HiloVelocidadAtaque(this);
		hilo.start();
	}

}
