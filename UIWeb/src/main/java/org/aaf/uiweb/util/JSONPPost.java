package org.aaf.uiweb.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

	
public class JSONPPost {

	public static void sendJson(JSONObject json) {

//		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpClient httpClient = new DefaultHttpClient();
		try {
		    HttpPost request = new HttpPost(EndPoints.REGISTER_TEAM);
		    StringEntity params = new StringEntity(json.toString());
		    
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    httpClient.execute(request);
		// handle response here...
		} catch (Exception ex) {
			ex.printStackTrace();
		    // handle exception here
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
}