package disparos;

import visitor.VisitorDisparoAliado;

public class DisparoAliado extends Disparo{

	public DisparoAliado(int x, int y,int d,int a) {
		super(x,y,d,a);
		miVisitor=new VisitorDisparoAliado(this);
	}

}
