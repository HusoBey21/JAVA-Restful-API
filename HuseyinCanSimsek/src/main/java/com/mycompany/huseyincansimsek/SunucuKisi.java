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
    public void al(HttpServletRequest istek,HttpServletResponse yanit) throws IOException,ServletException
    {
        String istekURL=istek.getRequestURI();
      
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
            yanit.getOutputStream().println(gonder);
            
        }
        else
        {
            yanit.getOutputStream().println("{}");
        }
        
        
       
    }
    public void ver(HttpServletRequest istek,HttpServletResponse yanit) throws IOException,ServletException
    {
        String ad=istek.getParameter("Adı");
        String kullaniciAdi=istek.getParameter("Kullanıcı Adı");
        String eposta=istek.getParameter("E Posta");
        String sifre=istek.getParameter("Şifre");
        String dogumYili=istek.getParameter("Doğum Yılı");
        DataStore a =new DataStore();
       a.settKisi(new kisi(ad,kullaniciAdi,eposta,sifre,dogumYili));
    }
}
