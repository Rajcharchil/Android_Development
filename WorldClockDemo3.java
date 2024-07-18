import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class WorldClockDemo3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	String countryName = "Africa";
	String zoneId = "Africa/Abidjan";
	ZonedDateTime zdt;
	JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldClockDemo3 frame = new WorldClockDemo3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WorldClockDemo3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1268, 749);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		zdt = ZonedDateTime.now(ZoneId.of(zoneId));

		Timer timer = new Timer(1000, this);

		JLabel lblNewLabel = new JLabel("Area/Country:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(32, 108, 200, 43);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel(countryName);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(225, 108, 240, 43);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(645, 25, 85, 43);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Time:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(645, 105, 85, 48);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("CurrentDate");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(740, 25, 306, 43);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("CurrentTime");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(740, 112, 306, 35);
		contentPane.add(lblNewLabel_5);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 190, 1273, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_7 = new JLabel("X");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(542, 69, 68, 43);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Y");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(542, 137, 93, 43);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_6 = new JLabel("WorldMap");
		lblNewLabel_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNewLabel_7.setText(e.getX() + "");
				lblNewLabel_8.setText(e.getY() + "");
			}
		});
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if ((x > 720) && (x < 1100) && (y > 30) && (y < 130)) {
					countryName = "Russia";
					zoneId = "Europe/Moscow";

				} else if ((x > 800) && (x < 840) && (y > 250) && (y < 300)) {
					countryName = "India";
					zoneId = "Asia/Calcutta";
				}
				comboBox.setSelectedItem(zoneId);
			}
		});
		 
//		lblNewLabel_6.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Arvind\\eclipse-workspace\\WorldClockDemo2\\worldmap.gif").getImage().getScaledInstance(1100, 700, Image.SCALE_FAST)));
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Arvind\\eclipse-workspace\\WorldClockDemo2\\worldmap.gif"));
		lblNewLabel_6.setBounds(32, 202, 1198, 500);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_4.setText(zdt.toLocalDate() + "");
		lblNewLabel_5.setText(zdt.toLocalTime() + "");

		Set<String> set = ZoneId.getAvailableZoneIds();
		TreeSet<String> treeSet = new TreeSet<>(set);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					zoneId = (String)e.getItem();
					String s1[] = zoneId.split("/");
					countryName = s1[0];
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBox.setBounds(32, 37, 372, 35);
		for (String s : treeSet)
			comboBox.addItem(s);
		contentPane.add(comboBox);

		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		zdt = ZonedDateTime.now(ZoneId.of(zoneId));
		lblNewLabel_4.setText(zdt.toLocalDate() + "");
		lblNewLabel_5.setText(zdt.toLocalTime() + "");
		lblNewLabel_1.setText(countryName);
	}
}

// JLabel lb = new JLabel(new ImageIcon("image.png"));
