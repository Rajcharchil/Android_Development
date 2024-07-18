
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DefaultCloseOperationDemo {
    JFrame frame;
    JFrame frame2;
    JFrame frame3;
    JFrame frame4;

    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    JButton btn8;
    
    public DefaultCloseOperationDemo(){
        frame = new JFrame("Exit Opr");
        frame2 = new JFrame("Dispose opr");
        frame3 = new JFrame("Hide Opr");
        frame4 = new JFrame("Do Nothing opr");

        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        frame2.setLayout(new GridLayout(2,1,20,10));
        frame3.setLayout(new BorderLayout());
        frame4.setLayout(new GridLayout(1,2,30,13));


        btn1 = new JButton("Click Me!");
        btn2 = new JButton("Click Me!");
        btn3 = new JButton("Click Me!");
        btn4 = new JButton("Click Me!");
        btn5 = new JButton("Click Me!");
        btn6 = new JButton("Click Me!");
        btn7 = new JButton("Click Me!");
        btn8 = new JButton("Click Me!");

        frame.add(btn1);
        frame.add(btn2);
        frame2.add(btn3);
        frame2.add(btn4);
        frame3.add(btn5,BorderLayout.NORTH);
        frame3.add(btn6,BorderLayout.SOUTH);
        frame4.add(btn7);
        frame4.add(btn8);


        btn1.setBounds(150,150,100,50);
        btn2.setBounds(150,150,75,50);
        btn3.setBounds(150,150,75,50);
        btn4.setBounds(150,150,75,50);
        btn5.setBounds(150,150,75,50);
        btn6.setBounds(150,150,75,50);
        btn7.setBounds(150,150,75,50);
        btn8.setBounds(150,150,75,50);

        // frame.getContentPane().setBackground(Color.black);
        // frame2.setBackground(Color.BLUE);
        // frame3.setBackground(Color.CYAN);
        // frame4.setBackground(Color.DARK_GRAY);

        frame.getContentPane().setBackground(Color.black);
        frame2.getContentPane().setBackground(Color.BLUE);
        frame3.getContentPane().setBackground(Color.CYAN);
        frame4.getContentPane().setBackground(Color.DARK_GRAY);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame4.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.setSize(400,400);
        frame2.setSize(400,400);
        frame3.setSize(400,400);
        frame4.setSize(400,400);

        frame.setVisible(true);
        frame2.setVisible(true);
        frame3.setVisible(true);
        frame4.setVisible(true);
    }


    public static void main(String args[]){
        new DefaultCloseOperationDemo();
    }

}
