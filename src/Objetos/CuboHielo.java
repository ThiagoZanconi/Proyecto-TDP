package Objetos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import gui.HiloDuracionObjeto;
import visitor.Visitor;
import visitor.VisitorCuboHielo;

public class CuboHielo extends ObjetoTemporal{
	
	public CuboHielo(int x,int y) {
		super();
		miVisitor=new VisitorCuboHielo(this);
		vida=-1;
		costoMonedas=350;
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Objetos\\congelacion.gif"));
		graficoActual.setBounds(400,-100,1000,1000);
		rectangulo=new Rectangle(0,-800,2000,2000);
		colisiono=false;
		HiloDuracionObjeto hilo=new HiloDuracionObjeto(this,2000);
		hilo.start();
	}
	
	public boolean getColisiono() {
		return false;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarObjeto(this);
		
	}

	@Override
	public void actividadSinColision() {
		// TODO Auto-generated method stub
		
	}
	

}
