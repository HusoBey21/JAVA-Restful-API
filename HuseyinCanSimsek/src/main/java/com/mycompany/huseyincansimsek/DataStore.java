/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author huseyin
 */
package com.mycompany.huseyincansimsek;
import java.sql.*;
public class DataStore {
   	
	
	//this class is a singleton and should not be instantiated directly!
	private static DataStore instance = new DataStore();
	public static DataStore getInstance(){
		return instance;
	}

	//private constructor so people know to use the getInstance() function instead
	

	public void settKisi(kisi kisiler)
        {
             String url = "jdbc:mysql://localhost:3306/netbeans/netbeans";
        String login = "root";
        String pass = "denizli.2020";
        String query="INSERT INTO netbeans (Adi,KullaniciAdi,Eposta,Sifre,dogumTarihi) VALUES(?,?,?,?,?);";
        try
        {
            
            Connection con = DriverManager.getConnection(url,login,pass);
            PreparedStatement s = con.prepareStatement(query);
            s.setString(0, kisiler.getAd());
            s.setString(1, kisiler.getKullaniciAdi());
            s.setString(2,kisiler.getEposta());
            s.setString(3,kisiler.getSifre());
            s.setString(4,kisiler.getdogumYili());
            
           
            

        }catch (SQLException e) 
        {
             System.out.println(e.getMessage());
        }
	}
        
        public kisi getKisi(String a)
        {
             String url = "jdbc:mysql://localhost:3306/netbeans/netbeans";
        String login = "root";
        String pass = "denizli.2020";
        String query="SELECT Adi,Eposta,Sifre,dogumYili FROM netbeans WHERE KullaniciAdi="+a;
        kisi er=new kisi();
        try
        {
            
            Connection con = DriverManager.getConnection(url,login,pass);
            Statement stmn=con.createStatement();
            ResultSet rs=stmn.executeQuery(query);
           
           while(rs.next())
           {
               String Ad=rs.getString("Adi");
               String Eposta=rs.getString("Eposta");
               String Sifre=rs.getString("Sifre");
               String dogumYili=rs.getString("dogumYili");
               er.setAd(Ad);
               er.setKullaniciAdi(a);
               er.setEposta(Eposta);
               er.setSifre(Sifre);
               er.setdogumYili(dogumYili);
           }
            rs.close();
           
            

        }catch (SQLException e) 
        {
             System.out.println(e.getMessage());
        }
        return er;
	
        

        }
}

