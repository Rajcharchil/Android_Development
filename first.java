
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * first
 */
public class first {

    public static void main(String[] args){
        JFrame frame = new JFrame("First");
        frame.setLayout(null);

        JButton btn1 = new JButton("Button1");
        //btn1.setBounds()
        btn1.setBackground(Color.black);
        btn1.setBounds(100, 100, 75, 40);

        frame.add(btn1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
    }
}