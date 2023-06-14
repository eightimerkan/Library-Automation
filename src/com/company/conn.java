package com.company;

import java.sql.*;

public class conn
{
    String url = "jdbc:sqlite:C:\\Users\\Dolguns\\IdeaProjects\\KutuphaneOtomasyonu\\sqlite\\Library.db";
    Connection c ;
    Statement s ;

    public conn()
    {
        try
        {
            c = DriverManager.getConnection(url);
            s = c.createStatement();
            System.out.println("Veri tabanına bağlandınız");
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
