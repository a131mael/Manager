package org.aaf.uiweb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ConectionRest {
	
	private URL url;
	
	private final static int  HTTP_COD_SUCESSO = 200;
	
	
	public URL getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Object getObject(Class c){
		HttpURLConnection con = null;
		try{
			con = (HttpURLConnection) getUrl().openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
			JAXBContext jaxbContext = JAXBContext.newInstance(c);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			return jaxbUnmarshaller.unmarshal(br);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}finally {
			con.disconnect();
		}
		return con;
		
	}
	
}
