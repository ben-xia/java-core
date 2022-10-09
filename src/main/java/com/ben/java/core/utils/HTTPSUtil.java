package com.ben.java.core.utils;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HTTPSUtil {
   public static final String default_charset = "UTF-8";
   public static final String REQ_METHOD_GET = "GET";
   public static final String REQ_METHOD_POST = "POST";

   public static String do_https_get(String req_url) throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException, UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
      return https_request(req_url, "GET", (String)null, (SSLSocketFactory)null, "UTF-8");
   }

   public static String do_https_get(String req_url, String out_str) throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException, UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
      return https_request(req_url, "GET", out_str, (SSLSocketFactory)null, "UTF-8");
   }

   public static String do_https_get(String req_url, String out_str, SSLSocketFactory ssf) throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException, UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
      return https_request(req_url, "GET", out_str, ssf, "UTF-8");
   }

   public static String do_https_post(String req_url) throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException, UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
      return https_request(req_url, "POST", (String)null, (SSLSocketFactory)null, "UTF-8");
   }

   public static String do_https_post(String req_url, String out_str) throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException, UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
      return https_request(req_url, "POST", out_str, (SSLSocketFactory)null, "UTF-8");
   }

   public static String do_https_post(String req_url, String out_str, SSLSocketFactory ssf) throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException, UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
      return https_request(req_url, "POST", out_str, ssf, "UTF-8");
   }

   public static String https_request(String url, String method, String out_str, SSLSocketFactory ssf, String charset) throws MalformedURLException, ConnectException, SocketTimeoutException, FileNotFoundException, UnknownHostException, UnknownServiceException, UnsupportedEncodingException, IOException {
      String ctype = "application/json;charset=" + charset;
      byte[] content = new byte[0];
      if (out_str != null) {
         content = out_str.getBytes(charset);
      }

//      int connectTimeout = Config.http_connect_timeout() * 1000;
//      int readTimeout = Config.http_read_timeout() * 1000;
      int connectTimeout = 60 * 1000;
      int readTimeout = 60 * 1000;
      return do_https(url, method, ctype, content, connectTimeout, readTimeout);
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

   public static String do_https(String url, String method, String ctype, byte[] content, int connectTimeout, int readTimeout) {
      String rsp = null;

      try {
         HttpsURLConnection conn = null;
         OutputStream out = null;
         SSLContext ctx = SSLContext.getInstance("TLS");
         ctx.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager(null)}, new SecureRandom());
         SSLContext.setDefault(ctx);
         conn = getConnection(new URL(url), method, ctype);
         conn.setHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
               return true;
            }
         });
         conn.setConnectTimeout(connectTimeout);
         conn.setReadTimeout(readTimeout);
         out = conn.getOutputStream();
         out.write(content);
         rsp = getResponseAsString(conn);
         out.close();
         conn.disconnect();
      } catch (Exception var10) {
         ;
      }

      return rsp;
   }

   private static HttpsURLConnection getConnection(URL url, String method, String ctype) throws IOException {
      HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
      conn.setRequestMethod(method);
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
      conn.setRequestProperty("User-Agent", "stargate");
      conn.setRequestProperty("Content-Type", ctype);
      return conn;
   }

   protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
      String charset = getResponseCharset(conn.getContentType());
      InputStream es = conn.getErrorStream();
      if (es == null) {
         return getStreamAsString(conn.getInputStream(), charset);
      } else {
         String msg = getStreamAsString(es, charset);
         if (msg != null && !msg.equals("")) {
            throw new IOException(msg);
         } else {
            throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
         }
      }
   }

   private static String getStreamAsString(InputStream stream, String charset) throws IOException {
      try {
         BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
         StringWriter writer = new StringWriter();
         char[] chars = new char[256];
         boolean var5 = false;

         int count;
         while((count = reader.read(chars)) > 0) {
            writer.write(chars, 0, count);
         }

         String var6 = writer.toString();
         return var6;
      } finally {
         if (stream != null) {
            stream.close();
         }

      }
   }

   private static String getResponseCharset(String ctype) {
      String charset = "UTF-8";
      if (ctype != null && !ctype.equals("")) {
         String[] params = ctype.split(";");
         String[] arr$ = params;
         int len$ = params.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            String param = arr$[i$];
            param = param.trim();
            if (param.startsWith("charset")) {
               String[] pair = param.split("=", 2);
               if (pair.length == 2 && pair[1] != null && !pair[1].equals("")) {
                  charset = pair[1].trim();
               }
               break;
            }
         }
      }

      return charset;
   }

   private static class DefaultTrustManager implements X509TrustManager {
      private DefaultTrustManager() {
      }

      public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
      }

      public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
      }

      public X509Certificate[] getAcceptedIssuers() {
         return null;
      }

      // $FF: synthetic method
      DefaultTrustManager(Object x0) {
         this();
      }
   }
}
