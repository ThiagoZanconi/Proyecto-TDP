package aliados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorAlcanceAliado;

public abstract class Aliado extends Personaje {
	protected boolean colisiono;
	protected int costoMonedas;
	protected JLabel colisionVenta;
	public Aliado(int f, int a,int v,int vp) {
		super(f,a,v,vp);
		visitorAlcance=new VisitorAlcanceAliado(this);
		colisiono=false;
	}
	
	public void setColisiono(boolean x) {
		colisiono=x;
	}
	
	public boolean getColisiono() {
		return colisiono;
	}
	
	public JLabel getColisionVenta() {
		return colisionVenta;
	}
	
	public int getCostoMonedas() {
		return costoMonedas;
	}
	
	public void aceptar(Visitor v) {
		v.visitarAliado(this);	
	}

	public void actividadSinColision() {
		adaptador.chequearColisionDeAtaques(this);
	}
	
	public void vender() {
		adaptador.huboVenta(costoMonedas);
		destruir();
	}
	
	public void destruir() {
		adaptador.eliminarElementoGrafico(colisionVenta);
		super.destruir();
	}
	
	class OyenteVenderAliado implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(adaptador.hayQueVender()) {
				vender();
			}
		}
	}
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) { 
			if(adaptador.hayQueVender()) {
				vender();
			}	
		}
		@Override
		public void mouseReleased(MouseEvent evento) {
	
		}
		@Override
		public void mouseEntered(MouseEvent evento) {

		}
		@Override
		public void mouseExited(MouseEvent evento) {

		}
		@Override
		public void mouseClicked(MouseEvent evento) {
			
		}
	};

}