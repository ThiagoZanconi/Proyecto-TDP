package Objetos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public abstract class Premio extends Objeto{

	protected JLabel colisionClick;
	
	public Premio(int x,int y){
		super();
		vida=-1;
		graficoActual=new JLabel();
		graficoActual.setBounds(x,y,1000,1000);
		colisionClick=new JLabel();
		colisionClick.setBounds(x,y+450,100,100);
		colisionClick.addMouseListener(click);
	}
	
	public abstract void clickeado();
	
	MouseListener click=new MouseListener() {
		@Override
		public void mousePressed(MouseEvent evento) { 
			clickeado();
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
