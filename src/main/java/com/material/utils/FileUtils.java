package com.material.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	public static String getFileNameAndSaveFile(MultipartFile File) {
		MultipartFile mfile = File;
		//上传源文件名字
		String Name =mfile.getOriginalFilename().replace(".jpg","");
		//文件名
		String fileName = new Date().getTime() + mfile.getOriginalFilename();
		System.out.println(fileName);
		//储存缓存文件地址
		String Path =Class.class.getClass().getResource("/").getPath()+ "static/images/";
		
		File file = new File(Path);
		//创建文件夹
		if(!file.isDirectory()){
			file.mkdir();
		}
		String filePath = Path+fileName;
		//移动文件夹到指定目录
		if(mfile.isEmpty()){
			
		}else{
			File mf = new File(filePath);
			try {
				mfile.transferTo(mf);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileName;
	}
}
