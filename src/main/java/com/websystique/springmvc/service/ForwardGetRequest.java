package com.websystique.springmvc.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForwardGetRequest {
	public static String process(String url) throws Exception {
		String token = StackStormToken.getToken();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("X-Auth-Token", token);
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine + "\r\n" );
			//response.append(inputLine);
		}
		in.close();
		
		System.out.println(response.toString());
		return response.toString();
	}
}
