package disparos;
import visitor.VisitorDisparoEnemigo;

public class DisparoEnemigo extends Disparo{

	public DisparoEnemigo(int x, int y,int d,int a) {
		super(x,y,d,a);
		miVisitor=new VisitorDisparoEnemigo(this);
	}
	
	public void mover() {
		rectangulo.setBounds((int)rectangulo.getX()+velocidad,(int)rectangulo.getY(),(int)rectangulo.getWidth(),(int)rectangulo.getHeight());
		graficoActual.setBounds(graficoActual.getX()+velocidad,graficoActual.getY(),graficoActual.getWidth(),graficoActual.getHeight());
		distanciaRecorrida+=velocidad;
		if(distanciaRecorrida>alcance) {
			destruir();
		}
	}

}
