import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
// public class BorderLayout extends JFrame {
    public class BorderLayoutDemo {
    public static void main(String[] args){

    JFrame frame;
    JButton button;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;

    // BorderLayoutDemo() {
        frame = new JFrame();
        button = new JButton("Click Me!");
        // Button Btn1 = new Button("Click Me!");
        // Button Btn2 = new Button("Click Me!");
        button1 = new JButton("1Click Me!");
        button2 = new JButton("2Click Me!");
        button3 = new JButton("3Click Me!");
        button4 = new JButton("4Click Me!");
        frame.setLayout(new BorderLayout());
        // setLayout(new java.awt.BorderLayout());

        
        // add(Btn,"EAST");
        // add(Btn1,"WEST");
        // add(Btn2,"CENTER");
        // frame.add(new JButton("WelCome"), BorderLayout.NORTH);
        frame.add(button,BorderLayout.EAST);
        frame.add(button1,BorderLayout.WEST);
        frame.add(button2,BorderLayout.NORTH);
        frame.add(button3,BorderLayout.SOUTH);
        frame.add(button4,BorderLayout.CENTER);
        frame.setSize(400,400);
        frame.setVisible(true);
        // frame.add(button,"EAST");
        // setSize(400,400);
        // setVisible(true);
    }

    // public static void main(String[] args){
        // new BorderLayoutDemo();
        // BorderLayoutDemo b1 = new BorderLayoutDemo();
    // }
}
