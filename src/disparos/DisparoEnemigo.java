package disparos;
import visitor.VisitorDisparoEnemigo;

public class DisparoEnemigo extends Disparo{

	public DisparoEnemigo(int x, int y,int d,int a) {
		super(x,y,d,a);
		miVisitor=new VisitorDisparoEnemigo(this);
	}

}
