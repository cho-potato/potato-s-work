package download;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class PrograssBarTest2 extends JFrame {
	JProgressBar bar1, bar2;
	JButton bt;
	int n;
	BarThread2 t1, t2;

	public PrograssBarTest2() {
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bt = new JButton("DOWNLOAD");

		Dimension d = new Dimension(680, 80);
		bar1.setPreferredSize(d);
		bar2.setPreferredSize(d);
		bar1.setStringPainted(true);
		bar2.setStringPainted(true);
		bar1.setFont(new Font("Verdana", Font.BOLD, 30));
		bar2.setFont(new Font("Verdana", Font.BOLD, 30));

		setLayout(new FlowLayout());

		add(bar1);
		add(bar2);
		add(bt);

		setSize(700, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1 = new BarThread2(bar1, 1, 10);
				t2 = new BarThread2(bar2, 3, 10);
				t1.start();
				t2.start();
			}
		});
	}

	public static void main(String[] args) {
		new PrograssBarTest2();
	}
}
