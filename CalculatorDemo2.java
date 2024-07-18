import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorDemo2 {
	JFrame frame;
	JTextField textField;
	double firstNumber;
	double secondNumber;
	double result;
	char operator;
	public CalculatorDemo2() {
		frame = new JFrame("Calculator");
		Font font = new Font("ARIAL", Font.BOLD, 30);
		textField = new JTextField();

		JPanel buttonPanel = new JPanel(new GridLayout(0, 4, 20, 20));

		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton b0 = new JButton("0");
		JButton b10 = new JButton(".");
		JButton b11 = new JButton("+");
		JButton b12 = new JButton("-");
		JButton b13 = new JButton("*");
		JButton b14 = new JButton("/");
		JButton b15 = new JButton("%");
		JButton b16 = new JButton("X^2");
		JButton b17 = new JButton("1/X");
		JButton b18 = new JButton("C");
		JButton b19 = new JButton("=");

		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);
		b6.setFont(font);
		b7.setFont(font);
		b8.setFont(font);
		b9.setFont(font);
		b0.setFont(font);
		b10.setFont(font);
		b11.setFont(font);
		b12.setFont(font);
		b13.setFont(font);
		b14.setFont(font);
		b15.setFont(font);
		b16.setFont(font);
		b17.setFont(font);
		b18.setFont(font);
		b19.setFont(font);
		textField.setFont(font);
		textField.setEditable(false);

		b0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				textField.setText(s + 0);
			}
		});

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});

		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});

		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});

		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});

		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		b8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});

		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		b10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().contains("."))
					textField.setText(textField.getText() + ".");
			}
		});
		
		b11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = '+';
			}
		});
		b12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = '-';
			}
		});
		b13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = '*';
			}
		});
		b14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = '/';
			}
		});
		b15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = '%';
			}
		});
		b16.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText(Math.pow(Double.parseDouble(textField.getText()),2.0)+"");
			}	
		});
		b17.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double d = Double.parseDouble(textField.getText());
				textField.setText((1/d)+"");
			}
		});
		b18.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNumber = 0;
				secondNumber = 0;
				result = 0;
				textField.setText("");
			}
		});
		b19.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				secondNumber = Double.parseDouble(textField.getText());
				
				switch(operator) {
				case '+':
					result = firstNumber + secondNumber;
					break;
				case '-':
					result = firstNumber - secondNumber;
					break;
				case '*':
					result = firstNumber * secondNumber;
					break;
				case '/':
					result = firstNumber / secondNumber;
					break;
				case '%':
					result = firstNumber % secondNumber;
					break;
				}
			textField.setText(result+"");
			}
		});
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(b4);
		buttonPanel.add(b5);
		buttonPanel.add(b6);
		buttonPanel.add(b7);
		buttonPanel.add(b8);
		buttonPanel.add(b9);
		buttonPanel.add(b0);
		buttonPanel.add(b10);
		buttonPanel.add(b11);
		buttonPanel.add(b12);
		buttonPanel.add(b13);
		buttonPanel.add(b14);
		buttonPanel.add(b15);
		buttonPanel.add(b16);
		buttonPanel.add(b17);
		buttonPanel.add(b18);
		buttonPanel.add(b19);

		frame.add(textField, BorderLayout.NORTH);
		frame.add(buttonPanel);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new CalculatorDemo2();
	}

}
