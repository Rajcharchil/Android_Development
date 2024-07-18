import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("GridLayout Demo");
		frame.setLayout(new GridLayout(0,2,30,20));
		
		frame.add(new JButton("Button-1"));
		frame.add(new JButton("Button-2"));
		frame.add(new JButton("Button-3"));
		frame.add(new JButton("Button-4"));
		frame.add(new JButton("Button-5"));
		frame.add(new JButton("Button-6"));
		frame.add(new JButton("Button-7"));
		frame.add(new JButton("Button-8"));
		frame.add(new JButton("Button-9"));

		
		frame.setSize(600,500);
		frame.setVisible(true);
	}

}
