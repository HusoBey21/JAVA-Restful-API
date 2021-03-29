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
public class kullanici {
    private String kullaniciAdi;
    private String sifre;
    public kullanici(String kullaniciAdi,String sifre)
    {
        this.kullaniciAdi=kullaniciAdi;
        this.sifre=sifre;
    }
    public void setKullaniciAdi(String kullaniciAdi)
    {
        this.kullaniciAdi=kullaniciAdi;
        
    }
    public String getKullaniciAdi()
    {
        return this.kullaniciAdi;
    }
    public void setSifre(String sifre)
    {
        this.sifre=sifre;
    }
    public String getSifre()
    {
        return this.sifre;
    }
}
