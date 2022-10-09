package com.ben.java.core.utils;

import java.io.*;
import java.net.*;

/**
 * @author ben xia
 * @date   2018年10月5日上午10:26:13
 */
public class HTTPUtil {
	public static final String default_charset = "UTF-8";
	public static final String REQ_METHOD_GET = "GET";
	public static final String REQ_METHOD_POST = "POST";

	public static String do_http_get(String req_url)
			throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException,
			UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
		return http_request(req_url, "GET", (String) null, "UTF-8");
	}

	public static String do_http_get(String req_url, String out_str)
			throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException,
			UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
		return http_request(req_url, "GET", out_str, "UTF-8");
	}

	public static String do_http_post(String req_url)
			throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException,
			UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
		return http_request(req_url, "POST", (String) null, "UTF-8");
	}

	public static String do_http_post(String req_url, String out_str)
			throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException,
			UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
		return http_request(req_url, "POST", out_str, "UTF-8");
	}

	/**
	 * http_request("路径", "请求方式", "请求参数", "字符编码")
	 */
	public static String http_request(String req_url, String req_method, String out_str, String charset)
			throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException,
			UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
		StringBuilder str_buid = new StringBuilder();
		if (charset == null || charset.trim().equals("")) {
			charset = "UTF-8";
		}

		URL url = new URL(req_url);
		HttpURLConnection http_conn = (HttpURLConnection) url.openConnection();
		http_conn.setDoOutput(true);
		http_conn.setDoInput(true);
		http_conn.setUseCaches(false);
		http_conn.setRequestMethod(req_method);
		// http_conn.setConnectTimeout(Config.http_connect_timeout() * 1000);
		// http_conn.setReadTimeout(Config.http_read_timeout() * 1000);
		http_conn.setConnectTimeout(60 * 1000);
		http_conn.setReadTimeout(60 * 1000);

		http_conn.setRequestProperty("Accept", "*/*");
		http_conn.setRequestProperty("Connection", "Keep-Alive");
		http_conn.setRequestProperty("Cache-Control", "no-cache");
//		http_conn.setRequestProperty("Content-Type", "text/plain");   
		http_conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  //Content-Type :内容编码方式
		
		http_conn.setRequestProperty("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Foxy/1; .NET CLR 2.0.50727; MEGAUPLOAD 1.0)");
		http_conn.connect();
		OutputStreamWriter is;
		if (null != out_str) {
			is = new OutputStreamWriter(http_conn.getOutputStream());
//			is.write(URLEncoder.encode(out_str, charset));
			is.write(out_str);
			
			// 此处必须关闭,否则servlet获取不到数据流
			is.flush();
			is.close();
		}

		InputStream ins = http_conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(ins, charset);
		BufferedReader br = new BufferedReader(isr);
		String str = null;

		while ((str = br.readLine()) != null) {
			str_buid.append(str);
		}

		br.close();
		isr.close();
		ins.close();
		ins = null;
		System.out.println(str_buid.toString());
		return str_buid.toString();
	}

	public static String process_url_link(String url) {
		if (url != null) {
			if (url.contains("?")) {
				if (url.indexOf("?") != url.length() - 1) {
					url = url + "&";
				}
			} else {
				url = url + "?";
			}
		}

		return url;
	}

	public static void main(String[] args)
			throws ConnectException, SocketTimeoutException, MalformedURLException, FileNotFoundException,
			UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
		do_http_post("http://127.0.0.1:8080/token/loginServlet", "&name=zhangsan&pwd=123456");

	}
}
