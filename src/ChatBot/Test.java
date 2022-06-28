package ChatBot;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    JLabel label = new JLabel();
    JTextArea chatArea = new JTextArea();
    JTextField chatBox = new JTextField();

    JButton send = new JButton();

    public Test(){

        setVisible(true);
        setTitle("Test Bot GUI");
        setSize(400,600);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(chatArea);
        add(chatBox);

        chatArea.setSize(400,500);
        chatArea.setLocation(0,0);

        chatBox.setSize(350,30);
        chatBox.setLocation(0,510);
    }

    public static void main(String[] args) {
        Test run = new Test();
    }

}
