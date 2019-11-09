package Objetos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import MagiasTemporalesStrategy.Strategy;
import juego.Personaje;
import visitor.Visitor;
import visitor.VisitorMagiaTemporal;

public class MagiaTemporal extends Premio{

	protected Personaje miPersonaje;
	protected Strategy tipoDeMagia;
	protected boolean afectaUsuario;
	
	public MagiaTemporal(int v,Personaje personaje) {
		super(v);
		miVisitor=new VisitorMagiaTemporal(this);
		miPersonaje=personaje;
		rectangulo=new Rectangle(miPersonaje.getRectangulo().x+1, miPersonaje.getRectangulo().y, miPersonaje.getRectangulo().width, miPersonaje.getRectangulo().height);
		graficoActual=new JLabel();
	}

	public void setStrategy(Strategy strategy,boolean afecta) {
		imagenes[0] = new JLabel();
		imagenes[0].setIcon(new ImageIcon(strategy.obtenerSprite()));
		graficoActual.setIcon(imagenes[0].getIcon());
		tipoDeMagia=strategy;
		afectaUsuario=afecta;
	}
	
	public boolean afectaUsuario() {
		return afectaUsuario;
	}
	
	public Personaje getPersonaje() {
		return miPersonaje;
	}
	
	public void performStrategy(Personaje p) {
		tipoDeMagia.estrategia(p);
	}
	
	public void actualizarRectangulo(int x,int y, int width, int height) {
		rectangulo.setBounds(x,y,width,height);
		graficoActual.setBounds(x,y,1000,1000);
	}
	
	@Override
	public void aceptar(Visitor v) {
		
		
	}

	public boolean usar(Personaje p) {
		if(p!=miPersonaje && !afectaUsuario) {
			return true;
		}else if(p==miPersonaje && afectaUsuario) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void actividadSinColision() {
		actualizarRectangulo(miPersonaje.getRectangulo().x+1, miPersonaje.getRectangulo().y, miPersonaje.getRectangulo().width, miPersonaje.getRectangulo().height);
		if(!miPersonaje.getGrafico().isVisible()) {
			this.destruir();
		}
	}
}
