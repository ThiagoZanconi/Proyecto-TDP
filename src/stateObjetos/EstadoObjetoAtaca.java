package stateObjetos;

import Objetos.Objeto;
import gui.HiloVelocidadAtaqueObjeto;
import juego.Personaje;

public class EstadoObjetoAtaca extends EstadoObjeto {

	public EstadoObjetoAtaca(Objeto o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void atacar(int d,Personaje p) {
		p.recibirDaño(d);
		miObjeto.setEstadoObjeto(new EstadoObjetoNoAtaca(miObjeto));
		HiloVelocidadAtaqueObjeto hilo=new HiloVelocidadAtaqueObjeto(miObjeto);
		hilo.start();
	}

}
