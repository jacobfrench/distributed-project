/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedproject.p2p;

/**
 *
 * @author me
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HttpClientP2P {
	private URL url;
	private int httpStatus;

	public HttpClientP2P() {
	}

	public String getHttpResponseCode() {
		return "Http Status " + httpStatus;
	}

	public void setHttpResponseCode(int responseCode) {
		this.httpStatus = responseCode;
	}

	public JSONArray get(String dest) throws IOException, JSONException {
		url = new URL(dest);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		setHttpResponseCode(con.getResponseCode());

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		String jsonText = content.toString();

		JSONArray json = new JSONArray(jsonText);
                
                
		return json;

	}

	public void post(String dest, String alias, String ip) throws IOException {
		byte[] out = String.format("{\"alias\":\"%s\",\"ip\":\"%s\"}", alias, ip).getBytes(StandardCharsets.UTF_8);
		int length = out.length;

		URL url = new URL(dest);
		URLConnection con = url.openConnection();
		con.setDoOutput(true);
		HttpURLConnection http = (HttpURLConnection) con;
		http.setRequestMethod("POST");

		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		http.connect();
		try (OutputStream os = http.getOutputStream()) {
			os.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
        
        public void delete(String ip) throws IOException {
		String requestUrl = "http://45.33.39.105:9000/delete/peer/"+ip.replace("/", "");
		System.out.println(requestUrl);
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
		connection.setDoInput(true);
		connection.setInstanceFollowRedirects(false); 
		connection.setRequestMethod("DELETE"); 
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		connection.setRequestProperty("charset", "utf-8");
		connection.setUseCaches (false);
		System.out.println("Response code: " + connection.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line, responseText = "";
		while ((line = br.readLine()) != null) {
		    System.out.println("LINE: "+line);
		    responseText += line;
		}
		br.close();
		connection.disconnect();

	}
}