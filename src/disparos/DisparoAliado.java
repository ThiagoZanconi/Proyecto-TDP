package disparos;

import visitor.VisitorDisparoAliado;

public class DisparoAliado extends Disparo{

	public DisparoAliado(int x, int y,int d) {
		super(x,y,d);
		miVisitor=new VisitorDisparoAliado(this);
	}

}
