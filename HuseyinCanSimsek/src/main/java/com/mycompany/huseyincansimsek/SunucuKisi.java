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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class SunucuKisi extends HttpServlet{
    public void doGet (HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        String istekURL=request.getRequestURI();
      
        String ad=istekURL.substring("/Adı/".length());
        DataStore sd=new DataStore();
        kisi kisiler=sd.getKisi(ad);
        if(kisiler !=null)
        {
            String gonder="\n";
            gonder +="Adı: " + JSONObject.quote(kisiler.getAd()) + ",\n";
            gonder +="KullaniciAdi: " + JSONObject.quote(kisiler.getKullaniciAdi()) + ",\n";
            gonder +="Eposta: " + JSONObject.quote(kisiler.getEposta()) + ",\n";
            gonder += "Sifre:" + JSONObject.quote(kisiler.getSifre()) + ",\n";
            gonder += "dogumYili:" + JSONObject.quote(kisiler.getdogumYili() + ",\n");
            response.getOutputStream().println(gonder);
            
        }
        else
        {
            response.getOutputStream().println("{}");
        }
        
        
       
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        String ad=request.getParameter("Adı");
        String kullaniciAdi=request.getParameter("Kullanıcı Adı");
        String eposta=request.getParameter("E Posta");
        String sifre=request.getParameter("Şifre");
        String dogumYili=request.getParameter("Doğum Yılı");
        DataStore a =new DataStore();
       a.settKisi(new kisi(ad,kullaniciAdi,eposta,sifre,dogumYili));
    }
}
