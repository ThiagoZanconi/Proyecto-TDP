package visitor;

import Objetos.CampoDeProteccion;
import Objetos.Objeto;
import aliados.Aliado;
import enemigos.Enemigo;

public class VisitorCampoDeProteccion extends VisitorPremio {
	protected CampoDeProteccion miCampo;
	
	public VisitorCampoDeProteccion(CampoDeProteccion c) {
		miCampo=c;
	}

	@Override
	public void visitarObjeto(Objeto o) {
		miCampo.aceptar(o.getVisitor());
		
	}
	
	@Override
	public void visitarEnemigo(Enemigo e) {
		if(miCampo.getEntidadDueño()) {
			e.destruir();
			miCampo.destruir();
		}

	}

	@Override
	public void visitarAliado(Aliado a) {
		if(!miCampo.getEntidadDueño()) {
			a.destruir();
			miCampo.destruir();
		}
		
	}

}
