package com.websystique.springmvc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public class ForwardGetRequest {
	public static void main(String[] args)throws Exception{
		ForwardGetRequest obj = new ForwardGetRequest();
		String URLs = "https://list.tmall.com/search_product.htm?q=" + "tea"; 
		obj.process1(URLs);
		
	}
	
    public static String process1(String url) throws Exception {
        // String token = StackStormToken.getToken();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        // con.setRequestProperty("X-Auth-Token", token);
        // con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "mozlla/5.0");
        con.setRequestProperty("Accept-Encoding", "gzip, deflate");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine + "\r\n");
            // response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        return response.toString();
    }

    public static String process(String id) throws Exception {
    	//id = URLEncoder.encode(id, "UTF-8");
    	String urlp = "https://list.tmall.com/search_product.htm?q=" + id; 
        //int ret=0;
    	StringBuffer response = new StringBuffer();
        String contentEncoding;
        HttpURLConnection url = null;
        //String htmladdr="http://www.zhcw.com/data-js/nowdata50.js";
        StringBuffer buffer = new StringBuffer("");
        try {
            URL url1 = new URL(id);
        	// URL url1 = new URL("https://list.tmall.com/search_product.htm?q=" + "包");

            url = (HttpURLConnection) url1.openConnection();
            url.setRequestProperty("Charsert", "UTF-8");
            url.setRequestProperty("User-Agent", "mozlla/5.0");
            url.setRequestProperty("Accept-Encoding", "gzip, deflate");
            url.setRequestProperty("Content-Type", "charset=UTF-8");
            url.connect();


            contentEncoding = url.getContentEncoding();

        } catch (Exception e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
            return "";
        }
        if (url != null) {
            InputStream stream;
            if ((null != contentEncoding)
                    && (-1 != contentEncoding.indexOf("gzip"))) {
                stream = new GZIPInputStream(
                        url.getInputStream());
            } else if ((null != contentEncoding)
                    && (-1 != contentEncoding.indexOf("deflate"))) {
                stream = new InflaterInputStream(
                        url.getInputStream());
            } else {
                stream = url.getInputStream();
            }

            //InputStream stream= url.getInputStream();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(stream));

            String temp;
            int count = 0;
        	int pos;
        	int pos1;
        	String str1 = "<em title=\"";
        	int len1 = str1.length();
        	String str21 = "<a href=\"//detail.tmall.com/item.htm?id=";
        	int len21 = str21.length();
        	String str22 = "title=\"";
        	int len22 = str22.length();      	
        	String str23 = "\" data-p=";
        	
        	String str31 = "<span>月成交 <em>";
        	int len31 = str31.length();   
        	String str32 = "</em>";
        	int len32 = str32.length();   
//        	int len23 = str22.length();
        	
        	String str41 = "</a></span>";

            while (null != (temp = reader.readLine())) {
            	pos = temp.lastIndexOf(str1);
            	if(-1 != pos) {
            		count++;
                    System.out.println(temp);
//                    response.append("-------------------------");
//                    response.append("序号：" + count );
//                    response.append("-------------------------"+ "\r\n");
                    response.append("序号：" + count );
                    response.append("价格：" + temp.substring(len1, temp.indexOf("\">")) + "\r\n");
                    continue;
            	}
            	pos = temp.indexOf(str21);
            	pos1 = temp.indexOf(str22) ;
            	if(-1 != pos && -1 != pos1 ) {
                    System.out.println(temp);
                    pos = temp.indexOf(str23);

                    response.append("名称：" + temp.substring(pos1+len22,pos) + "\r\n");
                    continue;
            	}
            	pos = temp.indexOf(str31);
            	if(-1 != pos) {
                    System.out.println(temp);
                    pos1 = temp.indexOf(str32);
                    response.append("月成交：" + temp.substring(len31, pos1) + "\r\n");
                    continue;
            	}
            	pos = temp.indexOf("<span>评价 <a href=\"//detail.tmall.com/item.htm");
            	if(-1 != pos) {
            		temp = temp.substring(0, temp.indexOf(str41));
                    System.out.println(temp);
                    response.append("月评价：" + temp.substring(temp.lastIndexOf('>')+1, temp.length()) + "\r\n");
            	}

                // break;
            }
            System.out.println("count:" + count);
            response.append(count + "\r\n");
            reader.close();
        }
        System.out.println("response:" +  response.toString());
        return response.toString();
    }
}
