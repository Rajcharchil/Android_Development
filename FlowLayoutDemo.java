
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class FlowLayoutDemo {
    JFrame frame;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;

    public FlowLayoutDemo(){
        // frame = new JFrame();
        frame = new JFrame("FlowLayoutDemo");
        button1 = new JButton("Button1");
        button2 = new JButton("Button2");
        button3 = new JButton("Button3");
        button4 = new JButton("Button4");

        // frame.setLayout(new FlowLayout());
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        frame.setSize(400,400);
        // frame.setBounds(200,300,400,600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutDemo();
    }
}
