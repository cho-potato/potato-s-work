package download;

import javax.swing.JProgressBar;

public class BarThread2 extends Thread {
	JProgressBar jProgressBar;
	int n;
	int velX;
	int time;
	boolean flag = true;
	
	public BarThread2(JProgressBar jProgressBar, int velX, int time) {
		this.jProgressBar = jProgressBar;
		this.velX = velX;
		this.time = time;
	}

	public void printValue() {
		n+= velX;
		jProgressBar.setValue(n);
		if(n>=100) {
			flag = false;			
		}
	}

	public void run() {
		while (flag) {
			printValue();
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
