package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Objetos.Obstaculo;
import adaptador.Adaptador;
import enemigos.Enemigo;
import gui.*;

public final class Juego {
	
	protected static final Juego juego=new Juego();
	protected static Tienda tienda;
	protected static GUI gui;
	protected static Elementos elementos;
	protected static Nivel nivel;
	protected JFrame victoriaFrame;
	
	private Juego() {
	
	}
	
	public static Juego getJuego() {
		return juego;
	}
	
	public void iniciarNivelUno() {
		elementos=new Elementos();
		gui=GUI.getGUI();
		nivel=new NivelUno(this);
		tienda=new Tienda(nivel);
		nivel.iniciar();
		Elemento elementoDerrota=new ElementoDerrota();
		elementos.añadirElemento(elementoDerrota);
		Adaptador adaptador=Adaptador.getAdaptador();
		adaptador.instanciarAtributos(elementos,nivel,tienda);
	}
	
	public void iniciarNivelDos() {
		elementos=new Elementos();
		gui=GUI.getGUI();
		nivel=new NivelDos(this);
		tienda=new Tienda(nivel);
		nivel.iniciar();
		Elemento elementoDerrota=new ElementoDerrota();
		elementos.añadirElemento(elementoDerrota);
		Adaptador adaptador=Adaptador.getAdaptador();
		adaptador.instanciarAtributos(elementos,nivel,tienda);
	}
	
	public void generarObstaculoAleatorio() {
		Random r=new Random();
		int probabilidad=r.nextInt(100);
		if(probabilidad<12) {
			Obstaculo obstaculo=nivel.generarObstaculoAleatorio();
			elementos.añadirElemento(obstaculo);
			gui.getVentanaJuego().add(obstaculo.getGrafico(),0);
		}
	}
	
	public void generarEnemigoAleatorio() {
		Enemigo enemigo=nivel.generarEnemigoAleatorio();
		elementos.añadirElemento(enemigo);
		gui.getVentanaJuego().add(enemigo.getGrafico(),0);
	}
	
	public void actualizarMonedas(int cantidad) {
		tienda.actualizarMonedas(cantidad);
	}
	/**
	 * 
	 */
	public void mover() {
		for(int i=0;i<elementos.size();i++) {
			elementos.getElemento(i).actividadSinColision();
			for(int j=i+1;j<elementos.size();j++) {
				elementos.chequearColision(elementos.getElemento(i),elementos.getElemento(j));
			}	
		}
		elementos.eliminar();
		actualizarMonedas(0);
	}
	
	public void victoria() {
		nivel.detenerJuego();
		JButton victButton=new JButton(new ImageIcon("Sprites\\button_volver-al-menu.png"));
		victButton.setBounds(115, 110, 170, 53);
		OyenteVolverMenu oyente=new OyenteVolverMenu();
		victButton.addActionListener(oyente);
		
		victoriaFrame=new JFrame("Victoria");
		JPanel victPanel=new JPanel();
		JLabel vict=new JLabel(new ImageIcon("Sprites\\victoria.png"));
		JLabel vict2=new JLabel(new ImageIcon("Sprites\\cred2.png"));
		
		victoriaFrame.setBounds(700,400,405,210);
		victoriaFrame.setVisible(true);
		victoriaFrame.setResizable(false);
		victoriaFrame.setContentPane(victPanel);
		
		victPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		victPanel.setLayout(null);
		
		victPanel.add(vict);
		vict.setBounds(0, 0, 402, 105);
		vict.setVisible(true);
	
		vict2.setBounds(0, -100, 402, 400);
		vict2.setVisible(true);
		victPanel.add(victButton);
		victPanel.add(vict2);	
	}
	
	class OyenteVolverMenu implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			gui.getVentanaJuego().setVisible(false);
			gui.menuPrincipal();
			victoriaFrame.setVisible(false);
		}
	}

}
