package juego;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visitor.Visitor;
import visitor.VisitorElementoDerrota;

public class ElementoDerrota extends Elemento {

	public ElementoDerrota() {
		super(-1);
		rectangulo=new Rectangle();
		rectangulo.setBounds(1110,-450,50,800);
		miVisitor=new VisitorElementoDerrota(this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarElementoDerrota(this);
	}

	@Override
	public void actividadSinColision() {
		
	}
	
	public void derrota() {
		//Abrir ventana Con cartel que muestre la derrota y un boton aceptar para volver al menu principal
		JFrame derrFrame=new JFrame("Derrota");
		JPanel derrPanel=new JPanel();
		JLabel derr=new JLabel(new ImageIcon("Sprites\\derrota.png"));
		derrFrame.setContentPane(derrPanel);
		derrFrame.setBounds(700,400,405,210);
		derrFrame.setVisible(true);
		derrFrame.setResizable(false);
		derrPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		derrPanel.setLayout(null);
		
		derrPanel.add(derr);
		derr.setVisible(true);
		
	}

}
