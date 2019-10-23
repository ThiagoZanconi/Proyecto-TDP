package disparos;
import visitor.VisitorDisparoEnemigo;

public class DisparoEnemigo extends Disparo{

	public DisparoEnemigo(int x, int y,int d) {
		super(x,y,d);
		miVisitor=new VisitorDisparoEnemigo(this);
	}

}
