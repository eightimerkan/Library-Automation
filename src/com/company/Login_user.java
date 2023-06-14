package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener
{
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1,b2,b3;

    public Login_user()
    {

       // setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);


        panel = new JPanel();
        panel.setBackground(new Color(0, 255, 13));
        setContentPane(panel);
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        JLabel l1 = new JLabel("Kullanıcı Adı : ");
        l1.setBounds(124,89,95,24);
        panel.add(l1);

        JLabel l2 = new JLabel("Şifre : ");
        l2.setBounds(124,124,95,24);
        panel.add(l2);

        /*
        JLabel l3 = new JLabel("Kütüphane Otomasyonu :");
        l3.setBounds(124,50,95,24);
        panel.add(l3);
        */

        textField = new JTextField();
        textField.setBounds(210,93,157,20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210,128,157,20);
        panel.add(passwordField);


        b1 = new JButton("Giriş");
        b1.addActionListener(this);

        b1.setForeground(new Color(46,139,87));
        b1.setBackground(new Color(250,250,210));
        b1.setBounds(149,181,113,39);
        panel.add(b1);

        b2 = new JButton("Kayıt ol");
        b2.addActionListener(this);

        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(255, 235, 205));
        b2.setBounds(289, 181, 113, 39);
        panel.add(b2);

        b3 = new JButton("Şifremi Unuttum");
        b3.addActionListener(this);

        b3.setForeground(new Color(205, 92, 92));
        b3.setBackground(new Color(253, 245, 230));
        b3.setBounds(199, 231, 179, 39);
        panel.add(b3);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(18, 255, 0));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            Boolean status = false;
            try
            {
                conn con = new conn();
                String sql = "select * from Kullanicilar where kullaniciAdi=? and Sifre=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if(rs.next())
                {
                    this.setVisible(false);
                    new Loading().setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Nice");
                }
                else JOptionPane.showMessageDialog(null, "Invalid Login...!.");
            }catch(Exception e2)
            {
                e2.printStackTrace();
            }
        }
        if(e.getSource() == b2)
        {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }
        if(e.getSource() == b3)
        {
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }
    }
}
