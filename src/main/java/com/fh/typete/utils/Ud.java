package com.fh.typete.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Ud {

	// Endpoint以杭州为例，其它Region请按实际情况填写。
	private static String endpoint = "yhbyunv@1714710677738717.onaliyun.com";
	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
	private static String accessKeyId = "LTAI4FzY6oNmWkXY9eCuFCzG";
	private static String accessKeySecret = "lzYk6o6zWSSHUBWgxFsdSeAqxJfTBm";
	private static String bucket="thbyunv";

	public static void ud(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!StringUtils.isEmpty(filePath)){
			String realPath = request.getServletContext().getRealPath("");
			File f= new File(realPath+filePath);
			//判断图片是否存在
			if(f.exists()){
				//设置MIME类型
				//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据
				//application/octet-stream以流的形式下载 下载任意格式
				response.setContentType("application/octet-stream");			
				//或者为response.setContentType("application/x-msdownload");
				
				//设置头信息,设置文件下载时的默认文件名，同时解决中文名乱码问题
				response.addHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes(), "ISO-8859-1"));
				
				InputStream inputStream=new FileInputStream(f);
				ServletOutputStream outputStream=response.getOutputStream();
				byte[] bs=new byte[1024];
				while((inputStream.read(bs)>0)){
					outputStream.write(bs);
				}
				outputStream.close();
				inputStream.close();	
			}
			
		}
		
	}

	public static Map<String, String> ul(MultipartFile image, HttpServletRequest request, String folerName) {
		Map<String, String> map=new HashMap<String, String>();
		//设置上传路径
		String path = request.getServletContext().getRealPath(folerName);
		//创建图片文件夹
		File f=new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		String realFilename = image.getOriginalFilename();
		//去最后一个点的下标
		int lastIndexOf = realFilename.lastIndexOf(".");
		//根据下标截取到后缀名名称
		String hz = realFilename.substring(lastIndexOf);
		//生成一个32位的名称
		String uuid = UUID.randomUUID().toString();
		//拼接
		String jm=uuid+hz;
		//路径和文件名称放到file中
		File fi=new File(path+"/"+jm);
		try {
			image.transferTo(fi);
			map.put("filePath", folerName+"/"+jm);
			map.put("fileName",realFilename);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	public static String uplfile(InputStream is,String fileName){
		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
		PutObjectResult por = ossClient.putObject(bucket, fileName, is);
		ossClient.shutdown();
		return "https://"+bucket+"."+endpoint+"/"+fileName;
	}
}


		

