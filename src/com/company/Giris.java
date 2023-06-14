package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Giris extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1;

    public Giris()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366,390);
        setLayout(null);
        setLocation(300,300);

        l1 = new JLabel("Kütüphane Otomasyonu");
        b1 = new JButton("Geç");

        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);



        ImageIcon i1  = new ImageIcon(("C:\\Users\\Dolguns\\IdeaProjects\\KutuphaneOtomasyonu\\Pictures\\background.jpeg"));
        Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        b1.setBounds(1050,250,200,60);
        l1.setBounds(0, 0, 1366, 390);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        new Login_user().setVisible(true);
        this.setVisible(false);
    }
}
