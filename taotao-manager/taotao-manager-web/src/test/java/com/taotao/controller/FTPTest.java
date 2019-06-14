package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {
	@Test
	public void testFtpClient()throws Exception {
		//创建一个FtpClient对象
		FTPClient ftpClient=new FTPClient();
		//创建ftp连接
		ftpClient.connect("192.168.117.117",21);
		//登陆ftp服务器，使用用户名和密码
		ftpClient.login("ftpuser", "123456");
		//上传文件
		//读取本地文件
		FileInputStream inputStream=new FileInputStream(new File("F:\\照片\\2018\\2018年5月青岛\\IMG_1991.JPG"));
			//设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/images");
		//修改上传文件的格式
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		//第一个参数，服务器端文件名
		//第二个参数，上传文档的inputStream
			ftpClient.storeFile("hello1.jpg", inputStream);
		//关闭连接
			ftpClient.logout();
		
	}
	
	@Test
	public void testFtpUtil()throws Exception {
		FileInputStream fileInputStream=new FileInputStream(new File("F:\\照片\\2018\\2018年5月青岛\\IMG_1992.JPG"));
		FtpUtil.uploadFile("192.168.117.117",21, "ftpuser", "123456", "/home/ftpuser/images", "2019/04/26", "hello.jpg", fileInputStream);
		
	
	
	
	
	
	
	
	}
}
