package Objetos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

import gui.HiloDuracionObjeto;
import visitor.Visitor;
import visitor.VisitorRelojRealentizador;

public class RelojRealentizador extends MagiaTemporal{

	public RelojRealentizador(int x, int y) {
		super(x, y);
		vida=-1;
		daño=0;
		graficoActual.setIcon(new ImageIcon("Sprites\\Premios\\Ralentiza.gif"));
		graficoActual.setBounds(550,-100,1000,1000);
		rectangulo=new Rectangle(0,-800,2000,2000);
		miVisitor=new VisitorRelojRealentizador(this);
		HiloDuracionObjeto hilo=new HiloDuracionObjeto(this,4500);
		hilo.start();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarPremio(this);
	}

	@Override
	public void actividadSinColision() {
		// TODO Auto-generated method stub
	}
	

}
