package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public Forgot()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,200,650,500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Kullanıcı Adı:");
        l1.setFont(new Font("Tahoma",Font.BOLD,13));
        l1.setBounds(109,83,87,29);
        contentPane.add(l1);

        JLabel l2 = new JLabel("İsim : ");
        l2.setFont(new Font("Tahoma",Font.BOLD,13));
        l2.setBounds(109,122,75,21);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Güvenlik Sorun");
        l3.setFont(new Font("Tahoma", Font.BOLD, 13));
        l3.setBounds(109, 154, 156, 27);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Cevabın");
        l4.setFont(new Font("Tahoma", Font.BOLD, 13));
        l4.setBounds(109, 192, 104, 21);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Şifren");
        l5.setFont(new Font("Tahoma", Font.BOLD, 13));
        l5.setBounds(109, 224, 104, 21);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma",Font.BOLD,13));
        t1.setForeground(new Color(105,105,105));
        t1.setBounds(277,88,139,20);
        contentPane.add(t1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Tahoma", Font.BOLD, 13));
        t2.setForeground(new Color(165, 42, 42));
        t2.setColumns(10);
        t2.setBounds(277, 123, 139, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Tahoma", Font.BOLD, 12));
        t3.setForeground(new Color(72, 61, 139));
        t3.setColumns(10);
        t3.setBounds(277, 161, 221, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 13));
        t4.setForeground(new Color(205, 92, 92));
        t4.setColumns(10);
        t4.setBounds(277, 193, 139, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Tahoma", Font.BOLD, 13));
        t5.setForeground(new Color(50, 205, 50));
        t5.setColumns(10);
        t5.setBounds(277, 225, 139, 20);
        contentPane.add(t5);

        b1 = new JButton("Arama");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma",Font.BOLD,13));
        b1.setBounds(428,83,80,29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        contentPane.add(b1);

        b2 = new JButton("Geri Al");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(426, 188, 85, 29);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Geri");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setBounds(233, 270, 101, 29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(139,69,19),2),"Şifremi Unuttum",
                TitledBorder.LEADING,TitledBorder.TOP,null,new Color(178,34,34)));
        panel.setBounds(47,45,508,281);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
       try
       {
           conn con = new conn();
           if(e.getSource() == b1)
           {
               String sql = "select * from Kullanicilar where kullaniciAdi=?";
               PreparedStatement st = con.c.prepareStatement(sql);

               st.setString(1,t1.getText());
               ResultSet rs = st.executeQuery();

               while(rs.next())
               {
                   t3.setText(rs.getString("Soru"));
               }
           }
           if(e.getSource() == b2)
           {
               String sql = "select * from Kullanicilar where Cevap=?";
               PreparedStatement st = con.c.prepareStatement(sql);

               st.setString(1,t4.getText());
               ResultSet rs = st.executeQuery();

               while (rs.next())
               {
                   t5.setText(rs.getString("Sifre"));
               }
           }
           if(e.getSource() == b3)
           {
               this.setVisible(false);
               new Login_user().setVisible(true);
           }
       }catch(Exception a)
       {

       }
    }
}
