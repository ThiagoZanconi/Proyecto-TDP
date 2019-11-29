package visitor;

import Objetos.CampoDeProteccion;
import Objetos.Objeto;

public class VisitorCampoDeProteccion extends VisitorPremio {
	protected CampoDeProteccion miCampo;
	
	public VisitorCampoDeProteccion(CampoDeProteccion c) {
		miCampo=c;
	}

	@Override
	public void visitarObjeto(Objeto o) {
		// TODO Auto-generated method stub
		
	}

}
