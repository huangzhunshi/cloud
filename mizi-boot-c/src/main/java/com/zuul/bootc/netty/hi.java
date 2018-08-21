package com.zuul.bootc.netty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hi {
    private JButton button1;
    private JPanel panel1;
    private JTextField a121212TextField;

    public hi() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(a121212TextField.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("hi");
        frame.setContentPane(new hi().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
