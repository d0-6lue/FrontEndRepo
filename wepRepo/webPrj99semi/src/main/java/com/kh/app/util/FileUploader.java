package com.kh.app.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploader {
	
	//part 객체를 받아서 서버에 저장 , 저장한 파일명을 리턴

	public static String upload(Part f, String path) throws IOException {
		
		String originName = f.getSubmittedFileName();
		String ext = originName.substring(originName.lastIndexOf(".")); // 확장자
//		String changeName = "kh_" + System.nanoTime() + Math.random() + ext; // 중복되지 않는 이름
		String changeName = UUID.randomUUID().toString() + ext;
		
		// 파일 업로드 시작
		InputStream fis = f.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		
		File target = new File(path + changeName);
		FileOutputStream fos = new FileOutputStream(target);
		
		int size = 0;
		byte[] buff = new byte[1024];
		while((size = bis.read(buff)) != -1) {
			fos.write(buff ,0 , size);
		}
		
		bis.close();
		fis.close();
		fos.close();
		// 파일 업로드 종료
		
		
		return changeName;
	}
	
	
}
