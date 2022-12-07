package page;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Menu2 extends JLabel {
	int index;
	AppMain2 appMain2; 

	public Menu2(AppMain2 appMain2, ImageIcon icon, int width, int height, int index) {
		this.appMain2 = appMain2;
		this.setIcon(icon); 
		this.setPreferredSize(new Dimension(width, height)); 
		this.index = index;
		this.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				appMain2.showHide(index);
			}
		});
	}
}