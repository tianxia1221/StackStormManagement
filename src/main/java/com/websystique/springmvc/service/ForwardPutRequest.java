package com.websystique.springmvc.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ForwardPutRequest {
	public static String process(String url, String body ) throws Exception {
//		String url = "https://stackstorm/api/v1/executions";
//		// String body = "{\"action\": \"examples.orquesta-ask-basic\"}";
//
//		//String body = "{\"action\": \"examples.orquesta-ask-idm-workflow\"}";
//		String bodyFormat = "{\"action\": \"examples.orquesta-ask-idm-workflow\",\"parameters\": {\"user\": \"%s\"}}";
//		String body = String.format(bodyFormat, user);
		String token = StackStormToken.getToken();
		URL obj = new URL(url);
		HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();

		connection.setHostnameVerifier(new CustomizedHostnameVerifier());

		// 设置是否向connection输出，因为这个是post请求，参数要放在
		// http正文内，因此需要设为true
		connection.setDoOutput(true);
		// Read from the connection. Default is true.
		connection.setDoInput(true);
		// 默认是 GET方式
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("X-Auth-Token", token);
		// connection Post 请求不能使用缓存
		connection.setUseCaches(false);
		// 设置本次连接是否自动重定向
		connection.setInstanceFollowRedirects(true);
		connection.setRequestProperty("Content-Type", "application/json; utf-8");
		// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
		// 要注意的是connection.getOutputStream会隐含的进行connect。
		// connection.connect();

		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.writeBytes(body);
		// 流用完记得关
		out.flush();
		out.close();

		int responseCode = connection.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		// 获取响应
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine + "\r\n" );
		}
		reader.close();
		// 该干的都干完了,记得把连接断了
		connection.disconnect();

		System.out.println(response.toString());
		return response.toString();
	}
}
