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
		GUI iniciar=new GUI();
	}
	
	public GUI() {
		menu=new JFrame("Epic Tower Defense");
		menu.setVisible(true);
		menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}


	
	
	

}
