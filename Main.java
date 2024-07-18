import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main implements ActionListener, KeyListener, MouseListener {
	static Main mainApp;
	JFrame jf;
	int WIDTH = 600;
	int HEIGHT = 600;
	int flag = 0;
	int score = 0;
	Renderer panel;
	Rectangle car;
	ArrayList<Rectangle> cars;
	Random rand;
	boolean started, gameover;
	Image myCar, oppCar;
	Clip clip;
	int speed;
	Main() {
		jf = new JFrame("Car Game Demo");
		panel = new Renderer();
		Timer timer = new Timer(20, this);
		rand = new Random();

		car = new Rectangle((WIDTH / 2) - 25, HEIGHT - 150, 50, 80);
		cars = new ArrayList<>();

		myCar = Toolkit.getDefaultToolkit().getImage("images\\car.png");
		oppCar = Toolkit.getDefaultToolkit().getImage("images\\car2.png");

		jf.add(panel);
		jf.addKeyListener(this);
		jf.addMouseListener(this);
		jf.setSize(WIDTH, HEIGHT);
		jf.setResizable(false);
		jf.setVisible(true);
		timer.start();
		playSound("sixDays.wav");
	}

	public void repaint(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.green.darker());
		g.fillRect(0, 0, WIDTH / 4, HEIGHT);
		g.fillRect((WIDTH / 4) * 3, 0, WIDTH / 4, HEIGHT);

		g.setColor(Color.red.darker().darker());
		g.fillRect((WIDTH / 4) - 20, 0, 20, HEIGHT);
		g.fillRect((WIDTH / 4) * 3, 0, 20, HEIGHT);

//		g.setColor(Color.red);
//		g.fillRect(car.x, car.y, car.width, car.height);
		g.drawImage(myCar, car.x, car.y, car.width, car.height, null);

		for (Rectangle rect : cars) {
			paintCars(g, rect);
		}
		if (gameover) {
			started = false;
			cars.clear();
		}
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		if (!started) {
			g.drawString("Click here to start!", 215, 100);
		}
		if (gameover) {
			g.drawString("Game over! Your score is : " + score, 170, 200);
			clip.stop();
			clip.close();
		}
		if (started && !gameover) {
			g.drawString("Score : " + score, 10, 300);
		}
	}

	public void paintCars(Graphics g, Rectangle rect) {
		g.setColor(Color.blue);
//		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.drawImage(oppCar, rect.x, rect.y, rect.width, rect.height, null);
	}

	public void addCars(boolean b) {
		int xi = rand.nextInt(100);
		int width = 50;
		int height = 80;
		if (b) {
			cars.add(new Rectangle((WIDTH / 4) + xi, -cars.size() * 150, width, height));
			cars.add(new Rectangle((WIDTH / 4) + xi + 120, -(cars.size() - 1) * 150, width, height));
		} else {
			cars.add(new Rectangle((WIDTH / 4) + xi, -(cars.size() - 1) * 150 - 150, width, height));
			cars.add(new Rectangle((WIDTH / 4) + xi + 120, -(cars.size() - 2) * 150 - 150, width, height));
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				mainApp = new Main();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		speed = 3;
		if((score > 5) &&(score < 10))
			speed = 5;
		else if((score >= 10) &&(score < 15))
			speed = 8;
		else if ((score >= 15) &&(score < 20))
			speed = 10;
		else if (score >= 20)
			speed = 12;
		if (started) {
			for (Rectangle rect : cars) {
				rect.y += speed;
			}
			for (int i = 0; i < cars.size(); i++) {
				Rectangle rect = cars.get(i);
				if (rect.y + 150 > car.y + 200) {
					score++;
					cars.remove(i);
					flag++;
					if ((flag % 2) == 0)
						addCars(false);
				}
			}
		}
		for (Rectangle rect : cars) {
			if (rect.intersects(car))
				gameover = true;
		}
		panel.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (car.x > 150)
				car.x -= 6;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (car.x < 395)
				car.x += 6;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		started = true;
		gameover = false;
		score = 0;
		addCars(true);
		addCars(true);
		addCars(true);
		clip.stop();
		clip.close();
		playSound("carRunning.wav");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		started = true;
		gameover = false;
		score = 0;
		addCars(true);
		addCars(true);
		addCars(true);
		clip.stop();
		clip.close();
		playSound("carRunning.wav");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void playSound(String fileName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
