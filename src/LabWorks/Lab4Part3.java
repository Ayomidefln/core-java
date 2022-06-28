package LabWorks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Lab4Part3 extends JFrame {
    Locale eng = new Locale("en","EN");
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              Locale esp = new Locale("es","ES");
    Locale ita = new Locale("it","IT");

    PropertyResourceBundle engR = (PropertyResourceBundle)  ResourceBundle.getBundle("English",eng);
    PropertyResourceBundle espR = (PropertyResourceBundle)  ResourceBundle.getBundle("Spanish",esp);
    PropertyResourceBundle itaR = (PropertyResourceBundle)  ResourceBundle.getBundle("Italian",ita);

    JLabel label1 = new JLabel(engR.getString("e1"));
    JLabel label2 = new JLabel(engR.getString("e2"));
    JLabel label3 = new JLabel(engR.getString("e3"));

    JButton tButton1 = new JButton("Translate to Yoruba");
    JButton tButton2 = new JButton("Translate to Italian");

    public Lab4Part3(){
        setVisible(true);
        setTitle("Translator");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);

        add(label1);
        add(label2);
        add(label3);

        add(tButton1);
        add(tButton2);

        tButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText(espR.getString("s1"));
                label2.setText(espR.getString("s2"));
                label3.setText(espR.getString("s3"));
            }
        });

        tButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText(itaR.getString("i1"));
                label2.setText(itaR.getString("i2"));
                label3.setText(itaR.getString("i3"));
            }
        });
    }

    public static void main(String[] args) {
        Lab4Part3 run = new Lab4Part3();
    }
}
