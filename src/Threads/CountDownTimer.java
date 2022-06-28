package Threads;

import javax.swing.*;
import java.awt.*;

public class CountDownTimer extends Thread{
    JTextField textField;
    JLabel label;
    JFrame frame;

    @Override
    public void run(){
        buildGUI();
    }

    void display(){
        for(int i = 30; i>=0; i--){
            try{
                Thread.sleep(1000);
                String s = Integer.toString(i);
                textField.setText(" " + s + " second to go....");
            }catch(Exception e){
                System.out.println(e);
            }
        }

        JOptionPane.showMessageDialog(frame,"Time up!!!");
        textField.setText("");
    }

    void buildGUI() {
        frame = new JFrame("Count Down Timer");
        JPanel panel = new JPanel();
        label = new JLabel("");
        textField = new JTextField(15);

        textField.setBackground(Color.green);
        panel.setBackground(Color.blue);
        frame.add(panel);
        panel.add(textField);
        panel.add(label);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        CountDownTimer obj = new CountDownTimer();
        obj.run();
        obj.display();
    }
}
