package gui;

public class Hilo extends Thread{
	private GUI gui;
	
	public Hilo(GUI gui) {
		this.gui=gui;
		
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gui.mover();
		}
	}
}
