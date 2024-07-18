import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelDemo {

    JFrame frame;
    JButton button;
    JButton button1;
    // JButton button2;
    JButton button3;
    JButton button4;
    JPanel panel;
    JButton panelBtn1;
    JButton panelBtn2;


    public JPanelDemo(){

        frame = new JFrame();
        button = new JButton("Click Me!");
        // Button Btn1 = new Button("Click Me!");
        // Button Btn2 = new Button("Click Me!");
        button1 = new JButton("1Click Me!");
        // button2 = new JButton("2Click Me!");
        button3 = new JButton("3Click Me!");
        button4 = new JButton("4Click Me!");
        panelBtn1 = new JButton("Button1");
        panelBtn2 = new JButton("Button2");
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.add(panelBtn1);
        panel.add(panelBtn2);
        
        frame.add(panel,BorderLayout.NORTH);

        frame.add(button,BorderLayout.EAST);
        frame.add(button1,BorderLayout.WEST);
        // frame.add(button2,BorderLayout.NORTH);
        frame.add(button3,BorderLayout.SOUTH);
        frame.add(button4,BorderLayout.CENTER);
        frame.setSize(400,400);
        frame.setVisible(true);
        // frame.add(button,"EAST");
        // setSize(400,400);
        // setVisible(true);
    }

    public static void main(String[] args){
        new JPanelDemo();
    }
    
}
