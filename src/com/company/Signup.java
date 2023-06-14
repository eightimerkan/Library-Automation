package com.company;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JButton b1,b2;
    private JComboBox comboBox;

    public Signup()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(600,250,606,406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Kullanıcı Adı : ");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblUsername.setBounds(99,86,92,26);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Şifre :");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 123, 92, 26);
        contentPane.add(lblPassword);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Kullanıcı Adın?", "Favori Rakamın?",
                "Çocukluk Kahramanın?", "En yakın arkadaşın ?" }));
        comboBox.setBounds(265, 160, 148, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Güvenlik Sorun :");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 160, 92, 26);
        contentPane.add(lblSecurityQuestion);

        JLabel lblAnswer = new JLabel("Cevabın :");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 202, 140, 26);
        contentPane.add(lblAnswer);

        textField = new JTextField();
        textField.setBounds(265, 91, 148, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField1 = new JTextField();
        textField1.setColumns(10);
        textField1.setBounds(265, 128, 148, 20);
        contentPane.add(textField1);

        textField2 = new JTextField();
        textField2.setColumns(10);
        textField2.setBounds(265, 202, 148, 20);
        contentPane.add(textField2);

        b1 = new JButton("Oluştur");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma",Font.BOLD,13));
        b1.setBounds(140,289,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Geri");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Hesap Oluştur",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 46, 476, 296);
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
                String sql = "insert into Kullanicilar(kullaniciAdi,Sifre,Soru,Cevap) values(?,?,?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1,textField.getText());
                st.setString(2,textField1.getText());
                st.setString(3, (String) comboBox.getSelectedItem());
                st.setString(4,textField2.getText());

                int i = st.executeUpdate();
                if(i > 0)
                {
                    JOptionPane.showMessageDialog(null,"Kayıt Başarıyla Oluşturuldu");
                }
                else
                    JOptionPane.showMessageDialog(null,"Olmadı");
                textField.setText("");
                textField1.setText("");
                textField2.setText("");
            }
            if(e.getSource() == b2)
            {
                this.setVisible(false);
                new Login_user().setVisible(true);
            }
        } catch(Exception e2)
        {
        }
    }
}
