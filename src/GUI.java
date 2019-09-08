import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class GUI extends JFrame {
	protected JFrame menu,juego;
	protected JButton botonJugar;
	protected JLabel nombre;
	protected Mapa mapa;
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public GUI() {
		menu=new JFrame("Epic Tower Defense");
		menu.setVisible(true);
		menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menu.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		botonJugar=new JButton("Jugar");
		botonJugar.setBounds(135,150,130,50);
		menu.add(botonJugar);
		
		OyenteBotonJugar oyente=new OyenteBotonJugar();
		botonJugar.addActionListener(oyente);
		
		
	}
	
	class OyenteBotonJugar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			juego=new JFrame("Epic Tower Defense");
			juego.setExtendedState(JFrame.MAXIMIZED_BOTH);
			JLabel mapaImagen=new JLabel();
			mapaImagen.setIcon(new ImageIcon("D:\\Mis Documentos\\Repositorios GitHub\\Proyecto-TDP\\Sprites\\Mapas\\MapaModificado.png"));
			juego.add(mapaImagen);
			juego.setVisible(true);
			menu.setVisible(false);
			
			mapa=new Mapa();
		}
	}


	
	
	

}
