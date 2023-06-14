package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Loading extends JFrame implements Runnable
{
    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int s;
    Thread th;

    public void setUploading()
    {
        this.setVisible(false);
        th.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading()
    {
        super("Loading");
        th  = new Thread((Runnable) this);

        setBounds(600,300,600,400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel libraryM = new JLabel("Erkan Kütüphane v8.8");
        libraryM.setForeground(new Color(225, 78, 78));
        libraryM.setFont(new Font("Trebucher MS",Font.BOLD,35));
        libraryM.setBounds(100,46,500,35);
        contentPane.add(libraryM);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma",Font.BOLD,12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130,135,300,25);
        contentPane.add((progressBar));

        JLabel lb2 = new JLabel("Lütfen Bekleyin.....");
        lb2.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,20));
        lb2.setForeground(new Color(160,82,45));
        lb2.setBounds(200,165,200,25);
        contentPane.add(lb2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0,0,590,390);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane.add(panel);

        setUploading();
    }
}
