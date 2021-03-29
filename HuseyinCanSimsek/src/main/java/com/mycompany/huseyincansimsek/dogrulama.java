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
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class dogrulama {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String authHeader = request.getHeader("authorization");
		String encodedAuth = authHeader.substring(authHeader.indexOf(' ')+1);
		String decodedAuth = new String(Base64.getDecoder().decode(encodedAuth));
		String kullaniciAdi = decodedAuth.substring(0, decodedAuth.indexOf(':'));
		String sifre = decodedAuth.substring(decodedAuth.indexOf(':')+1);
		DataStore dr=new DataStore();
		kisi girisKisi=dr.getKisi(kullaniciAdi);
                
		
		//make sure user is in our data
		if(girisKisi == null){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		
		//make sure password is valid
		//use hashed passwords in real life!
		if(!sifre.equalsIgnoreCase(girisKisi.getSifre())){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
    }
		
}
