package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Home extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JButton b1,b2,b3,b4,b5,b6;

    public Home()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400,150,1000,800);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 12, 12), new Color(128, 128, 128)));
        menuBar.setBackground(Color.gray);
        menuBar.setBounds(0, 10, 1000, 35);
        contentPane.add(menuBar);

        JMenu mnExit = new JMenu("Çıkış");
        mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));

        JMenuItem mntmLogout = new JMenuItem("Çıkış Yap");
        mntmLogout.setBackground(new Color(211, 211, 211));
        mntmLogout.setForeground(new Color(105, 105, 105));
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Çıkış");
        mntmExit.setForeground(new Color(105, 105, 105));
        mntmExit.setBackground(new Color(211, 211, 211));
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);

        JMenu mnHelp = new JMenu("Yardım");
        mnHelp.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem mntmReadme = new JMenuItem("Oku Beni");
        mntmReadme.setBackground(new Color(211, 211, 211));
        mntmReadme.setForeground(new Color(105, 105, 105));
        mnHelp.add(mntmReadme);

        /*
        JMenuItem mntmAboutUs = new JMenuItem("Ben kimim");
        mntmAboutUs.setForeground(new Color(105, 105, 105));
        mntmAboutUs.setBackground(new Color(211, 211, 211));
        mntmAboutUs.addActionListener(this);
        mnHelp.add(mntmAboutUs);

         */

        /*
        JMenu mnRecord = new JMenu("Kayıt");
        mnRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem bookdetails = new JMenuItem("Kitap Detayı");
        bookdetails.addActionListener(this);
        bookdetails.setBackground(new Color(211, 211, 211));
        bookdetails.setForeground(Color.DARK_GRAY);
        mnRecord.add(bookdetails);

        JMenuItem studentdetails = new JMenuItem("Öğrenci Detayı");
        studentdetails.setBackground(new Color(211, 211, 211));
        studentdetails.setForeground(Color.DARK_GRAY);
        studentdetails.addActionListener(this);
        mnRecord.add(studentdetails);

        menuBar.add(mnRecord);
         */
        menuBar.add(mnHelp);
        menuBar.add(mnExit);

        JLabel l1 = new JLabel("Kütüphane Otomasyonu");
        l1.setForeground(new Color(204, 51, 102));
        l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        l1.setBounds(268, 30, 701, 80);
        contentPane.add(l1);


        JLabel l2 = new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1  = new ImageIcon("C:\\Users\\Dolguns\\IdeaProjects\\KutuphaneOtomasyonu\\Pictures\\addbook.png");
        Image i2 = i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i1);
        l2.setBounds(60, 140, 159, 152);
        contentPane.add(l2);

        JLabel l3 = new JLabel("");
        ImageIcon i4  = new ImageIcon(("C:\\\\Users\\\\Dolguns\\\\IdeaProjects\\\\KutuphaneOtomasyonu\\\\Pictures\\\\addstudent.png"));
        Image i5 = i4.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(300, 160, 134, 128);
        contentPane.add(l3);


        /*
        JLabel l4 = new JLabel("");
        ImageIcon i7  = new ImageIcon(("C:\\Users\\Dolguns\\IdeaProjects\\KutuphaneOtomasyonu\\Pictures\\addstudent.png"));
        Image i8 = i7.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setBounds(530, 140, 225, 152);
        contentPane.add(l4);
         */



        b1 = new JButton("Kitap Ekle");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 320, 159, 44);
        contentPane.add(b1);

        b2 = new JButton("Öğrenci Ekle");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(313, 320, 139, 44);
        contentPane.add(b2);

        /*
        b3 = new JButton("Öğrenci Ekle");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(562, 320, 167, 44);
        contentPane.add(b3);
         */

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Düzenlemeler", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(220, 20, 60)));
        panel.setBounds(20, 120, 750, 260);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        b4 = new JButton("Öğrenci Detayı");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(76, 620, 143, 41);
        contentPane.add(b4);


        b5 = new JButton("Kitap Ara");
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(310, 620, 159, 41);
        contentPane.add(b5);


        /*
        b6 = new JButton("Biz Kimiz ?");
        b6.addActionListener(this);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(562, 620, 159, 41);
        contentPane.add(b6);
         */


        JLabel l5 = new JLabel("");
        ImageIcon i10  = new ImageIcon(("C:\\Users\\Dolguns\\IdeaProjects\\KutuphaneOtomasyonu\\Pictures\\issuebook.jpg"));
        Image i11 = i10.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setBounds(60, 440, 159, 163);
        contentPane.add(l5);

        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(("C:\\Users\\Dolguns\\IdeaProjects\\KutuphaneOtomasyonu\\Pictures\\returnbook.png"));
        Image i14 = i13.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(332, 440, 139, 152);
        contentPane.add(l6);

        /*
        JLabel l7 = new JLabel("");
        ImageIcon i16  = new ImageIcon(("C:\\Users\\Dolguns\\IdeaProjects\\KutuphaneOtomasyonu\\Pictures\\aboutus.png"));
        Image i17 = i16.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        l7 = new JLabel(i18);
        l7.setBounds(562, 440, 157, 152);
        contentPane.add(l7);
         */

        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(205, 133, 63), 2), "Araştırma", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(233, 150, 122)));
        panel2.setBounds(20, 420, 750, 270);
        panel2.setBackground(Color.WHITE);
        contentPane.add(panel2);

        getContentPane().setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String msj = e.getActionCommand();
        if (msj.equals("Çıkış Yap"))
        {
            setVisible(false);
            new Login_user().setVisible(true);
        }
        else if (msj.equals("Oku Beni"))
        {

        }
        /*
        else if (msj.equals("Biz Kimiz"))
        {
            setVisible(false);
            //new aboutUs().setVisible(true);
        }

         */
        /*
        else if(msj.equals("Kitap Detayı"))
        {
            setVisible(false);
            new BookDetails().setVisible(true);
        }
        else if(msj.equals("Öğrenci Detayı"))
        {
            setVisible(false);
            new StudentDetails().setVisible(true);
        }
         */

        if(e.getSource() == b1)
        {
            this.setVisible(false);
            new AddBook().setVisible(true);
        }
        if(e.getSource() == b2)
        {
            this.setVisible(false);
            new AddStudent().setVisible(true);
        }
        if(e.getSource() == b4)
        {
            setVisible(false);
            new StudentDetails().setVisible(true);
        }
        if(e.getSource() == b5){
            setVisible(false);
            new BookDetails().setVisible(true);

        }
        /*
        if(e.getSource() == b6){
            this.setVisible(false);
           // new aboutUs().setVisible(true);

        }

         */
    }
}
