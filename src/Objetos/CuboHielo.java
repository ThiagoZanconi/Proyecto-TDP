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
		costoMonedas=250;
		graficoActual=new JLabel();
		graficoActual.setIcon(new ImageIcon("Sprites\\Objetos\\congelacion.gif"));
		graficoActual.setBounds(0,0,1000,1000);
		rectangulo=new Rectangle(0,-800,2000,2000);
		colisiono=false;
		HiloDuracionObjeto hilo=new HiloDuracionObjeto(this,1000);
		hilo.start();
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
