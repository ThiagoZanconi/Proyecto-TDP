package juego;

import java.awt.Rectangle;
import Objetos.CampoDeProteccion;
import statePersonajes.Estado;
import statePersonajes.EstadoAtacando;
import visitor.VisitorAlcance;

public abstract class Personaje extends Elemento{
	protected int fuerzaDeImpacto;
	protected int alcance;
	protected int velocidadDeProyectil;
	protected Rectangle alcanceDeAtaque;
	protected VisitorAlcance visitorAlcance;
	protected int vidaMaxima;
	protected Estado estado;
	protected CampoDeProteccion campo;
	
	protected Personaje(int x,int y) {
		super();
		estado=new EstadoAtacando(this);
		campo=null;
	}
	
	public abstract void generarDisparo();
	
	public void destruirCampo() {
		if(campo!=null) {
			campo.destruir();
		}
	}
	
	public void campoDestruido() {
		campo=null;
	}
	
	public void añadirCampo(CampoDeProteccion x) {
		campo=x;
		x.setDueño(this);
	}
	
	public void atacar() {
		estado.atacar();
	}
	
	public void setEstado(Estado e) {
		estado=e;
	}
	
	public Rectangle getAlcanceDeAtaque() {
		return alcanceDeAtaque;
	}
	
	public VisitorAlcance getVisitorAlcance() {
		return visitorAlcance;
	}

	public int getFuerzaDeImpacto() {
		return fuerzaDeImpacto;
	}
	
	public void recibirDaño(int daño) {
		vida=vida-daño;
		if(vida<=0) {
			destruirCampo();
			destruir();
		}
	}
}
