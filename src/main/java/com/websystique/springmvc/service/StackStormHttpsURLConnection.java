package com.websystique.springmvc.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import javax.security.cert.X509Certificate;

import org.json.JSONArray;
import org.json.JSONObject;

public class StackStormHttpsURLConnection {

	// private final String USER_AGENT = "Mozilla/5.0";
	private String token;
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	//private StackStormHttpsURLConnection http;

	public static void main(String[] args) throws Exception {
		StackStormHttpsURLConnection http = new StackStormHttpsURLConnection();

		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(new CustomizedHostnameVerifier());

		http.getTokenByPostMethod();
		
		http.getWorkflows();
		
	}

	public void init() throws Exception {

		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(new CustomizedHostnameVerifier());

		getTokenByPostMethod();
		
	}

	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	private void getTokenByPostMethod() throws Exception {
		String url = "https://stackstorm/auth/v1/tokens";
		String authString = "st2admin:Ch@ngeMe";

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		String encoded = Base64.getEncoder().encodeToString(authString.getBytes(StandardCharsets.UTF_8));
		con.setRequestProperty("Authorization", "Basic " + encoded);
		con.setRequestProperty("Accept", "application/json");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		JSONObject jsonObject = new JSONObject(response.toString());
		token = (String) jsonObject.get("token");

		System.out.println(response.toString());
	}

	// HTTP GET request
	public String getWorkflows() throws Exception {

		//String url = "https://stackstorm/api/v1/actions?include_attributes=ref,pack,name,description,runner_type";
		String url = "https://stackstorm/api/v1/actions?include_attributes=ref,pack,name,description,runner_type&pack=examples";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		// con.setRequestProperty("User-Agent", USER_AGENT);
		
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
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		return response.toString();

	}
}

class CustomizedHostnameVerifier implements HostnameVerifier {

	@Override
	public boolean verify(String urlHostName, SSLSession session) {
		System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
		return true;
	}
}

class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
	public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	}

	public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
		return true;
	}

	public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
		return true;
	}

	public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
			throws java.security.cert.CertificateException {
		return;
	}

	public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
			throws java.security.cert.CertificateException {
		return;
	}
}
