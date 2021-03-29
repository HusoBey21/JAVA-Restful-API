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
public class kisi {
 
    private String ad;
    private String kullaniciad;
    private String eposta;
    private String sifre;
    private String dogumYili;
   public kisi()
   {
       
   }
    public kisi(String ad,String kullaniciad,String eposta,String sifre,String dogumYili)
    {
        this.ad=ad;
        this.kullaniciad=kullaniciad;
        this.eposta=eposta;
        this.sifre=sifre;
        this.dogumYili=dogumYili;
        
    }
    
    public void setAd(String ad)
    {
        this.ad=ad;
    }
    public String getAd()
    {
        return this.ad;
    }
    public void setKullaniciAdi(String kullaniciadi)
    {
        this.kullaniciad=kullaniciadi;
    }
    public String getKullaniciAdi()
    {
        return this.kullaniciad;
    }
    public void setEposta(String eposta)
    {
        this.eposta=eposta;
    }
    public String getEposta()
    {
        return this.eposta;
    }
    public void setSifre(String sifre)
    {
        this.sifre=sifre;
    }
    public String getSifre()
    {
        return this.sifre;
    }
    public void setdogumYili(String dogumYili)
    {
        this.dogumYili=dogumYili;
    }
    public String getdogumYili()
    {
        return this.dogumYili;
    }
          
}

