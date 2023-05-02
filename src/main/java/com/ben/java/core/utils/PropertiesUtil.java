package com.ben.java.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class PropertiesUtil {
   private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class.getName());
   public static final int BY_PROPERTIES = 1;
   public static final int BY_RESOURCEBUNDLE = 2;
   public static final int BY_PROPERTYRESOURCEBUNDLE = 3;
   public static final int BY_CLASS = 4;
   public static final int BY_CLASSLOADER = 5;
   public static final int BY_SYSTEM_CLASSLOADER = 6;

   public static Properties loadProperties(String name) {
      Properties p = null;

      try {
         p = loadProperties(name, 5);
         logger.debug("loadProperties(" + name + ").BY_CLASSLOADER    ok!");
         return p;
      } catch (Exception var8) {
         try {
            p = loadProperties(name, 1);
            logger.debug("loadProperties(" + name + ").BY_PROPERTIES    ok!");
            return p;
         } catch (Exception var7) {
            try {
               p = loadProperties(name, 2);
               logger.debug("loadProperties(" + name + ").BY_RESOURCEBUNDLE    ok!");
               return p;
            } catch (Exception var6) {
               try {
                  p = loadProperties(name, 3);
                  logger.debug("loadProperties(" + name + ").BY_PROPERTYRESOURCEBUNDLE    ok!");
                  return p;
               } catch (Exception var5) {
                  try {
                     p = loadProperties(name, 4);
                     logger.debug("loadProperties(" + name + ").BY_CLASS    ok!");
                     return p;
                  } catch (Exception var4) {
                     try {
                        p = loadProperties(name, 6);
                        logger.debug("loadProperties(" + name + ").BY_SYSTEM_CLASSLOADER    ok!");
                        return p;
                     } catch (Exception var3) {
                        if (p == null) {
                           logger.error("加载配置文件异常！文件名为：" + name);
                        }

                        return p;
                     }
                  }
               }
            }
         }
      }
   }
   /*
   *加载属性配置文件的六种方法
   *name:属性配置文件
   */
   public static Properties loadProperties(String name, int type) throws IOException {
      Properties p = new Properties();
      InputStream in = null;
      if (type == 1) {
         in = new BufferedInputStream(new FileInputStream(name));

         assert in != null;

         ((Properties)p).load((InputStream)in);
      } else if (type == 2) {
         ResourceBundle rb = ResourceBundle.getBundle(name, Locale.getDefault());

         assert rb != null;

         p = new ResourceBundleAdapter(rb);
      } else if (type == 3) {
         in = new BufferedInputStream(new FileInputStream(name));

         assert in != null;

         ResourceBundle rb = new PropertyResourceBundle((InputStream)in);
         p = new ResourceBundleAdapter(rb);
      } else if (type == 4) {
         assert PropertiesUtil.class.equals((new PropertiesUtil()).getClass());

         in = PropertiesUtil.class.getResourceAsStream(name);

         assert in != null;

         ((Properties)p).load((InputStream)in);
      } else if (type == 5) {
         assert PropertiesUtil.class.getClassLoader().equals((new PropertiesUtil()).getClass().getClassLoader());

         in = PropertiesUtil.class.getClassLoader().getResourceAsStream(name);

         assert in != null;

         ((Properties)p).load((InputStream)in);
      } else if (type == 6) {
         in = ClassLoader.getSystemResourceAsStream(name);

         assert in != null;

         ((Properties)p).load((InputStream)in);
      }

      if (in != null) {
         ((InputStream)in).close();
      }

      return (Properties)p;
   }

   public static void saveFile(String filename, Properties p, String description) throws IOException {
      try {
         File f = new File(filename);
         FileOutputStream out = new FileOutputStream(f);
         p.store(out, description);
         out.close();
      } catch (IOException var5) {
         throw new IOException("无法保存指定的配置文件:" + filename, var5);
      }
   }

   public static void main(String[] args) {
      try {
         String file = "D:\\log4j.properties";
         Properties p = loadProperties(file);
         p.list(System.out);
         logger.debug("----------------------------------------------- <<<");
         logger.debug("\tlog4j.appender.stdout=" + p.getProperty("log4j.appender.stdout"));
         p.remove("datasource.username");
         logger.debug("\tdatasource.username=" + p.getProperty("datasource.username"));
         logger.debug("----------------------------------------------- >>>");
         saveFile(file, p, "xxxxxxxxx");
      } catch (Exception var3) {
         logger.error(var3.getMessage(), var3);
      }

   }

   public static class ResourceBundleAdapter extends Properties {
      private ResourceBundle rb = null;

      public ResourceBundleAdapter(ResourceBundle rb) {
         assert rb instanceof PropertyResourceBundle;

         this.rb = rb;
         Enumeration e = rb.getKeys();

         while(e.hasMoreElements()) {
            Object o = e.nextElement();
            this.put(o, rb.getObject((String)o));
         }

      }

      public ResourceBundle getBundle(String baseName) {
         return ResourceBundle.getBundle(baseName);
      }

      public ResourceBundle getBundle(String baseName, Locale locale) {
         return ResourceBundle.getBundle(baseName, locale);
      }

      public ResourceBundle getBundle(String baseName, Locale locale, ClassLoader loader) {
         return ResourceBundle.getBundle(baseName, locale, loader);
      }

      public Enumeration getKeys() {
         return this.rb.getKeys();
      }

      public Locale getLocale() {
         return this.rb.getLocale();
      }

      public Object getObject(String key) {
         return this.rb.getObject(key);
      }

      public String getString(String key) {
         return this.rb.getString(key);
      }

      public String[] getStringArray(String key) {
         return this.rb.getStringArray(key);
      }

      protected Object handleGetObject(String key) {
         return ((PropertyResourceBundle)this.rb).handleGetObject(key);
      }
   }
}
