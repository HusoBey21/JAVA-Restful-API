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
import java.util.UUID;
public class onay {
    public onay ornek()
    {
        return this;
    }
    
    	 
	public String onaylanan(String kullaniciAdi){
		String token = UUID.randomUUID().toString();
		kisi a=new kisi();
                a.setKullaniciAdi(kullaniciAdi);
		return token;
	}
    
}
