package juego;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import visitor.Visitor;
import visitor.VisitorElementoDerrota;

public class ElementoDerrota extends Elemento {
	protected JFrame derrFrame;

	public ElementoDerrota() {
		super();
		vida=-1;
		rectangulo=new Rectangle();
		rectangulo.setBounds(1150,-450,50,800);
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
		
		adaptador.terminarJuego();
		
		JButton derrButton=new JButton(new ImageIcon("Sprites\\button_volver-al-menu.png"));
		derrButton.setBounds(115, 110, 170, 53);
		OyenteVolverMenu oyente=new OyenteVolverMenu();
		derrButton.addActionListener(oyente);
		
		derrFrame=new JFrame("Derrota");
		JPanel derrPanel=new JPanel();
		JLabel derr=new JLabel(new ImageIcon("Sprites\\derrota.png"));
		JLabel derr2=new JLabel(new ImageIcon("Sprites\\cred2.png"));
		
		derrFrame.setBounds(700,400,405,210);
		derrFrame.setVisible(true);
		derrFrame.setResizable(false);
		derrFrame.setContentPane(derrPanel);
		
		derrPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		derrPanel.setLayout(null);
		
		derrPanel.add(derr);
		derr.setBounds(0, 0, 402, 105);
		derr.setVisible(true);
		
		derr2.setBounds(0, -100, 402, 400);
		derr2.setVisible(true);
		derrPanel.add(derrButton);
		derrPanel.add(derr2);	
	}
	
	class OyenteVolverMenu implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			adaptador.volverMenuPrincipal();
			derrFrame.setVisible(false);
		}
	}

	public String esUn() {
		return "Final";
	}

}
