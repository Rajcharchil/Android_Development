import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EventsDemo {
    JFrame frame;
    JButton button;

    public EventsDemo() {
        frame = new JFrame("Events Demo");
        button = new JButton("Click me!");

        frame.setLayout(new FlowLayout(1));
        button.setBounds(150,160,75,35);

        button.addActionListener(new Demo1());

        frame.add(button);
        frame.setSize(300,350);
        frame.setVisible(true);
    }
    public static void main(String args[]){
        new EventsDemo();
    }
}
class Demo1 implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("Button clicked");
    }
}
