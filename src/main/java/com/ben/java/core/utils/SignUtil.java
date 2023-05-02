package com.ben.java.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class SignUtil {
   private static final Logger logger = LoggerFactory.getLogger(SignUtil.class.getName());

   public static String getTimestamp() {
      return Long.toString((new Date()).getTime());
   }

   public static String getNonce() {
      Random random = new Random();
      StringBuilder nonce = new StringBuilder();
      nonce.append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10));
      return nonce.toString();
   }

   public static String getSignature(String aid, String api_id, String key, String timestamp, String nonce) {
      return getSignature(aid, (String)null, api_id, key, timestamp, nonce, (String)null);
   }

   public static String getSignature(String aid, String tid, String api_id, String key, String timestamp, String nonce, String data_sign) {
      return getSignature(aid, tid, api_id, key, timestamp, nonce, data_sign, (String)null, (String)null);
   }

   public static String getSignature(String aid, String tid, String api_id, String key, String timestamp, String nonce, String data_sign, String forward, String error_url) {
      if (aid == null) {
         aid = "";
      }

      if (tid == null) {
         tid = "";
      }

      if (api_id == null) {
         api_id = "";
      }

      if (key == null) {
         key = "";
      }

      if (timestamp == null) {
         timestamp = "";
      }

      if (nonce == null) {
         nonce = "";
      }

      if (data_sign == null) {
         data_sign = "";
      }

      if (forward == null) {
         forward = "";
      }

      if (error_url == null) {
         error_url = "";
      }

      String[] args = new String[]{aid, tid, api_id, key, timestamp, nonce, data_sign, forward, error_url};
      return getSignature(args);
   }

   public static String getSignature(String[] args) {
      if (args != null && args.length != 0) {
         Arrays.sort(args);
         StringBuilder content = new StringBuilder();

         for(int i = 0; i < args.length; ++i) {
            content.append(args[i]);
         }

         logger.debug("signature >>> " + content.toString());
         MessageDigest md = null;
         String tmp_str = null;

         try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            tmp_str = byteToStr(digest);
         } catch (NoSuchAlgorithmException var5) {
            var5.printStackTrace();
         }

         content = null;
         return tmp_str;
      } else {
         return null;
      }
   }

   public static boolean checkSignature(String aid, String api_id, String signature, String app_key, String timestamp, String nonce) {
      return checkSignature(aid, (String)null, api_id, signature, app_key, timestamp, nonce, (String)null);
   }

   public static boolean checkSignature(String aid, String tid, String api_id, String signature, String app_key, String timestamp, String nonce, String data) {
      String tmp_str = getSignature(aid, tid, api_id, app_key, timestamp, nonce, data);
      return tmp_str != null ? tmp_str.equals(signature.toUpperCase()) : false;
   }

   private static String byteToStr(byte[] byte_array) {
      String str_digest = "";

      for(int i = 0; i < byte_array.length; ++i) {
         str_digest = str_digest + byteToHexStr(byte_array[i]);
      }

      return str_digest;
   }

   private static String byteToHexStr(byte m_byte) {
      char[] digit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
      char[] temp_arr = new char[]{digit[m_byte >>> 4 & 15], digit[m_byte & 15]};
      String s = new String(temp_arr);
      return s;
   }
}
