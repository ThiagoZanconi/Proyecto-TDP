package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorCampoDeProteccion;

public class CampoDeProteccion extends MagiaTemporal {
	protected boolean entidadDueño;                  //false=enemigo, true=aliado
	protected Personaje miDueño;

	public CampoDeProteccion(int x,int y) {
		super(x,y);
		daño=0;
		graficoActual.setIcon(new ImageIcon("Sprites\\Premios\\campo.png"));
		rectangulo=new Rectangle(x,y,80,70);
		miVisitor=new VisitorCampoDeProteccion(this);
	}
	
	public void setEntidadDueño(boolean b) {
		entidadDueño=b;
	}
	
	public void setDueño(Personaje p) {
		miDueño=p;
	}

	public boolean getEntidadDueño() {
		return entidadDueño;
	}
	
	public void destruir() {
		miDueño.campoDestruido();
		super.destruir();
	}
	
	public void mover(int x) {    //Se utiliza cuando un enemigo que posee este campo se mueve             
		rectangulo.setBounds((int)rectangulo.getX()+x,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
		graficoActual.setBounds(graficoActual.getX()+x,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
	}
	
	@Override
	public void aceptar(Visitor v) {
		v.visitarPremio(this);
		
	}

	@Override
	public void actividadSinColision() {
		
		
	}

}
