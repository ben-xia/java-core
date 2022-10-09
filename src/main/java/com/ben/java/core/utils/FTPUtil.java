package com.ben.java.core.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * JAVA中使用FTPClient实现文件上传下载,读取FTP上的文件并解析
 *
 * @author ben xia
 * @date 2018年9月13日下午11:27:20
 * @version
 */
public class FTPUtil {

	public FTPClient ftpClient;
	public ArrayList<String> arFiles;
	private String strencoding;
	private String ip;
	private String userName;
	private String userPwd;
	private int port;
	public String path;

	private static volatile  FTPUtil instance=null;

	public static FTPUtil getInstance(String ip,int port,String userName,String userPwd,String path){
		if (instance==null){
			synchronized (FTPUtil.class){
				if (instance==null){
					instance = new FTPUtil(ip, port, userName, userPwd, path);
				}

			}
		}
		return  instance;

	}

	/**
	 * init ftp servere
	 */
	private FTPUtil(String ip,int port,String userName,String userPwd,String path) {
		this.reSet(ip,port,userName,userPwd,path);
	}

	private void reSet(String ip,int port,String userName,String userPwd,String path) {
		// 以当前系统时间拼接文件名
		arFiles = new ArrayList<String>();
		strencoding = "UTF-8";
		this.connectServer(ip, port, userName, userPwd, path);
	}

	/**
	 * @param ip
	 * @param port
	 * @param userName
	 * @param userPwd
	 * @param path
	 *            文件目录
	 * @throws SocketException
	 * @throws IOException
	 *             function:连接到服务器
	 */
	private void connectServer(String ip, int port, String userName, String userPwd, String path) {
		ftpClient = new FTPClient();
		try {
			// 与FTP服务器建立连接
			ftpClient.connect(ip, port);
			// 登录到FTP服务器
			ftpClient.login(userName, userPwd);

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 递归遍历出目录下面所有文件
	 *
	 * @param pathName
	 *            需要遍历的目录，必须以"/"开始和结束
	 * @throws IOException
	 */
	public void List(String pathName) throws IOException {
		if (path != null && path.length() > 0 && pathName.startsWith("/") && pathName.endsWith("/")) {
			String directory = pathName;
			// 更换目录到当前目录
			ftpClient.changeWorkingDirectory(directory);
			FTPFile[] files = ftpClient.listFiles();
			for (FTPFile file : files) {
				if (file.isFile()) {
					arFiles.add(directory + file.getName());
				} else if (file.isDirectory()) {
					List(directory + file.getName() + "/");
				}
			}
		}
	}

	/**
	 * 递归遍历目录下面指定的文件名
	 *
	 * @param pathName
	 *            需要遍历的目录，必须以"/"开始和结束
	 * @param ext
	 *            文件的扩展名
	 * @throws IOException
	 */
	public void List(String pathName, String ext) throws IOException {
		if (pathName.startsWith("/") && pathName.endsWith("/")) {
			String directory = pathName;
			// 更换目录到当前目录
			ftpClient.changeWorkingDirectory(directory);
			FTPFile[] files = ftpClient.listFiles();
			for (FTPFile file : files) {
				if (file.isFile()) {
					if (file.getName().endsWith(ext)) {
						arFiles.add(directory + file.getName());
					}
				} else if (file.isDirectory()) {
					List(directory + file.getName() + "/", ext); // 递归
				}
			}
		}
	}

	/**
	 * 向FTP服务器上传文件
	 *
	 * @param basePath
	 *            FTP基础路径
	 * @param filePath
	 *            FTP文件存放路径
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            输入流
	 * @return 成功返回true，否则返回false
	 */
	public  boolean uploadFile(String basePath,String filePath, String filename, InputStream input) {
		boolean success = false;
		try {
			int reply;
			reply = this.ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {    //FTP模式
				this.ftpClient.disconnect();
				return success;
			}
			// 切换到上传目录
			if (!this.ftpClient.changeWorkingDirectory(basePath + filePath)) {
				// 如果目录不存在创建目录
				String[] dirs = filePath.split("/");
				String tempPath = basePath;
				for (String dir : dirs) {
					if (null == dir || "".equals(dir))
						continue;
					tempPath += "/" + dir;
					if (!this.ftpClient.changeWorkingDirectory(tempPath)) {
						if (!this.ftpClient.makeDirectory(tempPath)) {
							return success;
						} else {
							this.ftpClient.changeWorkingDirectory(tempPath);
						}
					}
				}
			}
			// 设置上传文件的类型为二进制类型
			this.ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			// 上传文件
			if (!this.ftpClient.storeFile(filename, input)) {
				return success;
			}

			input.close();
			this.ftpClient.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 从FTP服务器下载指定文件
	 *
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 * @throws ParseException
	 */
	public  boolean downFile(String remotePath,String fileName, String localPath) throws ParseException {
		boolean success = false;
		try {
			int reply;
			reply = this.ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				this.ftpClient.disconnect();
				return success;
			}
			this.ftpClient.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			FTPFile[] fs = this.ftpClient.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {  //也可改成下载全部的文件
					File localFile = new File(localPath + File.separator + ff.getName());

					OutputStream is = new FileOutputStream(localFile);
					this.ftpClient.retrieveFile(ff.getName(), is);    //ff.getName()
//                    readFile2String(ff.getName());
					is.close();
				}
			}

			this.ftpClient.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 读取指定的文件
	 *
	 * @param fileName
	 *            文件名
	 * @return
	 * @throws ParseException
	 */
	public String readFile2String(String fileName) throws ParseException {
		InputStream ins = null;
		StringBuilder builder = null;
		try {
			// 从服务器上读取指定的文件
			ins = ftpClient.retrieveFileStream(fileName); // retrieve:恢复,取回
			BufferedReader reader = new BufferedReader(new InputStreamReader(ins, strencoding));
			String line;
			builder = new StringBuilder(150); // 缓冲区
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			reader.close();

			if (ins != null) {
				ins.close();
			}

			// 主动调用一次getReply()把接下来的226消费掉. 这样做是可以解决这个返回null问题
			ftpClient.getReply();

			// 根据文件名删除文件
//			ftpClient.deleteFile(fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(builder.toString());
		return builder.toString();

	}

	/**
	 * 返回btye[]
	 * @param fileName
	 * @return
	 */
	public byte[] readFile2ByteArray(String fileName){
		InputStream ins = null;
		StringBuilder builder = null;
		try {
			// 从服务器上读取指定的文件
			ins = ftpClient.retrieveFileStream(fileName); // retrieve:恢复,取回
			BufferedReader reader = new BufferedReader(new InputStreamReader(ins, strencoding));
			String line;
			builder = new StringBuilder(150); // 缓冲区
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			reader.close();

			if (ins != null) {
				ins.close();
			}

			// 主动调用一次getReply()把接下来的226消费掉. 这样做是可以解决这个返回null问题
			ftpClient.getReply();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(builder.toString());
		return builder.toString().getBytes();

	};



	/**
	 * 根据文件名删除文件
	 *
	 * @param fileName
	 */
	public void deleteFile(String fileName) {
		try {
			ftpClient.deleteFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws IOException
	 *             function:登录退出,并关闭连接
	 */
	public void closeServer() {
		if (ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
//        FTPUtil ftp = new FTPUtil();
//		try {
//			ftp.List("/upload/");
//			ftp.closeServer();
//			Iterator<String> it = ftp.arFiles.iterator();
//			while (it.hasNext()) {
//				System.out.println(it.next());
//			}
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//		try {
//			ftp.uploadFile("/upload", "/20180921", "xxx.xml", new FileInputStream(new File("D:\\GZEportExchange\\in\\backup\\20180907\\KJ881112_C011111100396626_2018090711301583588.xml")));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

//        ftp.downFile("/upload/20180921", "xxx.xml", "F:/GZEportExchange/out");

	}
}
