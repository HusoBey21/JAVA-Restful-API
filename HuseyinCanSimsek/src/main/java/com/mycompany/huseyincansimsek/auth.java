/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.huseyincansimsek;

/**
 *
 * @author huseyin
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONObject;

public class auth {
    public static void main(String[] args) throws IOException
    {
        
        Scanner tarayici=new Scanner(System.in);
        System.out.println("Kayit Sistemine Hosgeldiniz");
        String getset=tarayici.nextLine();
        if("get".equalsIgnoreCase(getset)){
        System.out.println("Adinizi Giriniz");
        String ad=tarayici.nextLine();
        System.out.println("Kullanici Adinizi Giriniz");
        String kullaniciAdi=tarayici.nextLine();
        System.out.println("E posta Giriniz");
        String eposta=tarayici.nextLine();
        System.out.println("Sifre Giriniz");
        String sifre=tarayici.nextLine();
        System.out.println("Dogum Yili Giriniz");
        String dogumYili=tarayici.nextLine();
        kisi e=new kisi();
        e.setAd(ad);
        e.setKullaniciAdi(kullaniciAdi);
        e.setEposta(eposta);
        e.setSifre(sifre);
        e.setdogumYili(dogumYili);
        }
        else if("set".equalsIgnoreCase(getset))
        {
            String ad=tarayici.nextLine();
            String kullaniciAdi=tarayici.nextLine();
            String eposta=tarayici.nextLine();
            String sifre=tarayici.nextLine();
            String dogumYili=tarayici.nextLine();
            kisi e=new kisi();
            e.setAd(ad);
            e.setKullaniciAdi(kullaniciAdi);
            e.setEposta(eposta);
            e.setSifre(sifre);
            e.setdogumYili(dogumYili);
        }
        
        
        
        
    }
    public static String getPersonData(String ad) throws IOException{

		HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/HuseyinCanSimsek" + ad).openConnection();
		
		connection.setRequestMethod("GET");

		int yanitKodu = connection.getResponseCode();
		if(yanitKodu == 200){
			String yanit = "";
			Scanner tarayici = new Scanner(connection.getInputStream());
			while(tarayici.hasNextLine()){
				yanit += tarayici.nextLine();
				yanit += "\n";
			}
			tarayici.close();

			return yanit;
		}
		
		// an error happened
		return null;
	}
    public static void setPersonData(String ad, String kullaniciAdi, String Eposta,String Sifre,String dogumYili) throws IOException{
		HttpURLConnection baglanti = (HttpURLConnection) new URL("http://localhost:3000" + ad).openConnection();

		baglanti.setRequestMethod("POST");
		
		String gonderiVerisi = "adi=" + URLEncoder.encode(ad);
		gonderiVerisi += "kullaniciAdi=" + URLEncoder.encode(kullaniciAdi);
		gonderiVerisi += "Eposta=" + URLEncoder.encode(Eposta);
                gonderiVerisi += "Sifre=" + URLEncoder.encode(Sifre);
                gonderiVerisi += "dogumYili=" + URLEncoder.encode(dogumYili);
                
		
		baglanti.setDoOutput(true);
	    OutputStreamWriter wr = new OutputStreamWriter(baglanti.getOutputStream());
	    wr.write(gonderiVerisi);
	    wr.flush();
		
		int yanitKodu = baglanti.getResponseCode();
		if(yanitKodu== 200){
			System.out.println("Gondeim başarılı oldu.");
		}
		else if(yanitKodu == 401){
			System.out.println("Yanlış Şifre.");
                }

}
}
