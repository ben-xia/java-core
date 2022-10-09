package com.ben.java.core.utils;

import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;

/**
 * 使用JAVA实现在SFTP服务器上上传,下载,列出目录下的文件
 * 
 * @author ben xia
 * @date 2018年9月13日下午11:46:39
 * @version
 */
public class SFTPUtils {

	private ChannelSftp sftp;

	private Session session;

	/** SFTP 登录用户名 */
	private String username;

	/** SFTP 登录密码 */
	private String password;

	/** 私钥 */
	private String privateKey;

	/** SFTP 服务器地址IP地址 */
	private String host;

	/** SFTP 端口 */
	private int port;

	/**
	 * 构造基于密码认证的sftp对象
	 */
	public SFTPUtils(String username, String password, String host, int port) {
		this.username = username;
		this.password = password;
		this.host = host;
		this.port = port;
	}

	/**
	 * 构造基于秘钥认证的sftp对象
	 */
	public SFTPUtils(String username, String host, int port, String privateKey) {
		this.username = username;
		this.host = host;
		this.port = port;
		this.privateKey = privateKey;
	}

	public SFTPUtils() {
	}

	/**
	 * 连接sftp服务器
	 */
	public void login() {
		try {
			JSch jsch = new JSch();
			if (privateKey != null) {
				jsch.addIdentity(privateKey);// 设置私钥
			}
			// 拿到Session
			session = jsch.getSession(username, host, port);

			if (password != null) {
				session.setPassword(password);
			}
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			// 为Session对象设置properties
			session.setConfig(config);
			// 通过Session建立链接
			session.connect();
			// 打开SFTP通道
			Channel channel = session.openChannel("sftp");
			// 建立SFTP通道的连接
			channel.connect();

			sftp = (ChannelSftp) channel;

		} catch (JSchException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭连接 server
	 */
	public void logout() {
		if (sftp != null) {
			if (sftp.isConnected()) {
				sftp.disconnect();
			}
		}
		if (session != null) {
			if (session.isConnected()) {
				session.disconnect();
			}
		}
	}

	/**
	 * 列出目录下的文件
	 * 
	 * @param directory
	 *            要列出的目录
	 * @param
	 */
	public List<String> listFiles(String directory) throws SftpException {
		List<String> list = new ArrayList<String>();
		Vector ls = sftp.ls(directory);
		for (Object object : ls) {
			String filename = ((LsEntry) object).getFilename();

			if (".".equals(filename) || "..".equals(filename))
				continue;
			list.add(filename);
		}

		return list;

	}

	/**
	 * 将输入流的数据上传到sftp作为文件。文件完整路径=basePath+directory
	 * 
	 * @param basePath
	 *            服务器的基础路径
	 * @param directory
	 *            上传到该目录
	 * @param sftpFileName
	 *            sftp端文件名
	 * @param input
	 *            输入流
	 */
	public void upload(String basePath, String directory, String sftpFileName, InputStream input) throws SftpException {
		try {
			// 切换目录
			sftp.cd(basePath + directory);
			//下面的切换目录是错误的,debug始终会进入catch块中
			// sftp.cd(basePath)
			// sftp.cd(directory);
		} catch (SftpException e) {
			// 目录不存在，则创建文件夹
			String[] dirs = directory.split("/");
			String tempPath = basePath;
			for (String dir : dirs) {
				if (null == dir || "".equals(dir))
					continue;
				tempPath += "/" + dir;
				try {
					sftp.cd(tempPath);
				} catch (SftpException ex) {
					sftp.mkdir(tempPath);
					sftp.cd(tempPath);
				}
			}
		}
		sftp.put(input, sftpFileName); // 上传文件
	}

	/**
	 * 上传目录下的所有文件(批量上传)
	 * 
	 * @param basePath   FTP基础目录
	 * @param directory  FTP上传的具体目录
	 * @throws Exception
	 */
	public boolean uploadByDirectory(String basePath, String directory, String localDir)
			throws Exception {
		boolean success;
		File dir = new File(localDir);
		if (dir.isDirectory()) {
			File[] listFiles = dir.listFiles();
			if (listFiles != null && listFiles.length > 0) {
				for (File file : listFiles) {
					upload(basePath, directory, file.getName(), new FileInputStream(file));
				}
			}
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	/**
	 * 下载文件。
	 * 
	 * @param directory
	 *            FTP下载目录
	 * @param downloadFile
	 *            下载的文件
	 * @param saveFile
	 *            下载到本地的完整路径名
	 */
	public void download(String directory, String downloadFile, String saveFile)
			throws SftpException, FileNotFoundException {
		if (directory != null && !"".equals(directory)) {
			sftp.cd(directory);
		}
		File file = new File(saveFile);
		sftp.get(downloadFile, new FileOutputStream(file));
	}

	/**
	 * 批量下载目录下的文件
	 * 
	 * @param directory
	 *            FTP目录
	 * @param saveDirectory
	 *            本地保存目录
	 * @throws Exception
	 */
	public void downloadByDirectory(String directory, String saveDirectory) throws Exception {
		String downloadFile = "";
//		if (directory != null && !"".equals(directory)) {
//			sftp.cd(directory);
//		}
		List<String> downloadFileList = this.listFiles(directory);
		Iterator<String> it = downloadFileList.iterator();
		while (it.hasNext()) {
			downloadFile = it.next().toString();
			if (downloadFile.toString().indexOf(".") < 0)
				continue;
			this.download(directory, downloadFile,
					saveDirectory.endsWith("/") ? saveDirectory + downloadFile : saveDirectory + "/" + downloadFile);
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param directory
	 *            下载目录
	 * @param downloadFile
	 *            下载的文件名
	 * @return 字节数组
	 */
	public byte[] download(String directory, String downloadFile) throws SftpException, IOException {
		if (directory != null && !"".equals(directory)) {
			sftp.cd(directory);
		}
		InputStream is = sftp.get(downloadFile);

		byte[] fileData = IOUtils.toByteArray(is);

		String str = new String(fileData, "UTF-8");
		System.err.println(str);
		return fileData;
	}

	/**
	 * 删除文件
	 * 
	 * @param directory
	 *            要删除文件所在目录
	 * @param deleteFile
	 *            要删除的文件
	 */
	public void delete(String directory, String deleteFile) throws SftpException {
		sftp.cd(directory);
		sftp.rm(deleteFile);
	}

	/**
	 * 文件重命名
	 * 
	 * @param directory
	 * @param oldFileNm
	 * @param newFileNm
	 * @throws Exception
	 */
	public void rename(String directory, String oldFileNm, String newFileNm) throws Exception {
		sftp.cd(directory);
		sftp.rename(oldFileNm, newFileNm);
	}

	public static void main(String[] args) throws Exception {
		SFTPUtils sftp = new SFTPUtils("sftp", "sftp", "192.168.116.134", 22);
		sftp.login();
		File file = new File("F:\\tools\\16.API\\images\\timg.png");
		InputStream is = new FileInputStream(file);

		// sftp.upload("/upload", "/mysftp", "test_sftp.jpg", is);

		// 列出目录下的文件
//		List<String> listFiles = sftp.listFiles("/upload/");
//		for (String s : listFiles) {
//			System.out.println(s);
//		}

		// sftp.download("/upload/mysftp", "test_sftp.jpg", "F:/download/ftp.jpg");
		//
		// sftp.delete("/upload/mysftp", "test_sftp.jpg");
		
//		sftp.uploadByDirectory("/upload", "/mysftp/", "F:/xml/");
//		sftp.downloadByDirectory("/upload/mysftp",  "F:/xml");
//		sftp.download("/upload/mysftp", "Servlet.txt");

		sftp.rename("/upload/mysftp", "Servlet.txt", "javaee.txt");
		
		
		sftp.logout();
	}
}