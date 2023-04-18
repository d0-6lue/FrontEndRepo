package com.kh.app.utill;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploader {

	public static String upload(Part p, String path) throws IOException {
		
		String originName = p.getSubmittedFileName();
		String ext = originName.substring(originName.lastIndexOf(".")); // 확장자
//		String changeNAme = "app100_" + System.nanoTime() + Math.random() + ext; // 중복되지 않는 파일명으로 변경
		String changeName = UUID.randomUUID().toString() + ext; // 중복되지 않는 파일명으로 변경

		
		InputStream fis = p.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		
		File target = new File(path + changeName);
		FileOutputStream fos = new FileOutputStream(target);
		
		
		int size = 0;
		byte[] buff = new byte[1024];
		while( (size = bis.read(buff)) != -1 ) {
			fos.write(buff, 0, size);
		}
		
		
		bis.close();
		fis.close();
		fos.close();
		
		
		return changeName;
	}
	
	/*
	https://bamdule.tistory.com/179
	https://lannstark.tistory.com/34
	https://lannstark.tistory.com/50
	
 	[Steam]
 	 프로그램은 외부에서 데이터를 읽거나 외부로 데이터를 출력하는 작업이 빈번하게 일어납니다.
	 이때 데이터는 어떠한 통로를 통해서 데이터가 이동되는데, 이 통로를 Stream 이라고 합니다.

	 자바에는 이러한 기능을 수행하기 위해 InputStream와 OutputStream이 존재하며 단일 방향으로 연속적으로 흘러갑니다.
	 InputStream과 OutputStream은 추상 클래스이며 추상 메소드를 오버라이딩해서 다양한 역할을 수행할 수 있습니다. 
	 (예 : 파일, 네트워크, 메모리 입출력)

	 자바에서 기본적으로 제공하는 I/O 기능은 java.io 패키지에서 제공됩니다. 
	 InputStream은 외부에서 데이터를 읽는 역할을 수행하고, OutputStream은 외부로 데이터를 출력하는 역할을 수행합니다.  
	*/
	
	/*
	[InputStream]
	 바이트 기반 입력 스트림의 최상위 추상클래스입니다. (모든 바이트 기반 입력 스트림은 이 클래스를 상속받습니다.)
	 파일 데이터를 읽거나 네트워크 소켓을 통해 데이터를 읽거나 키보드에서 입력한 데이터를 읽을 때 사용합니다. 
	 InputStream은 읽기에 대한 다양한 추상 메소드를 정의해 두었습니다.
	 그리고 InputStream의 추상메소드를 오버라이딩하여 목적에 따라 데이터를 입력 받을 수 있습니다.  
	
	
	[public abstract int read() throws IOException;]
	 입력 스트림에서 1 바이트 씩 읽고 읽은 바이트를 반환합니다. 
	 데이터를 모두 읽었다면 -1을 반환합니다.  
	 
	 
	[
	 byte[] buffer = new byte[buffLen];
	 while( (size = InputStream.read(buffer)) != -1) { ... }
	]
	 입력 스트림에서 byte buffer[] 만큼 읽고 읽은 데이터 수를 반환합니다.
	 여러 바이트 씩 읽기 때문에 한 바이트 씩 읽는 것 보다 더 빠릅니다.
  
	 데이터를 모두 읽었다면 -1을 반환합니다. 

	 read() 메소드와 다른 점은 read() 메소드의 반환 값이 읽은 데이터가 아니라 읽은 데이터 수 라는 점입니다.
	 읽은 데이터는 매개변수로 넘긴 buffer에 저장됩니다. 
	 
	 
	[
	 int len = 4;
	 int readCnt = 0;
	 int offset = 0;
	 byte[] buffer = new byte[1024];
	 
	 while( (readCnt = inputStream.read( buffer , offset , len) ) != -1 ) {
	 	offset += readCnt;
	 	
	 	...
	 	
	 }
	]
	 입력 스트림에서 buffer[off] 부터 len개 만큼 buffer에 저장합니다.
	 read 메소드는 읽은 데이터의 개수를 반환하고 더 이상 읽을 데이터가 없다면 -1을 반환합니다.
	 만약 len개를 읽지 못하면 실제로 읽은 데이터 수를 반환합니다.

	 위 소스는 데이터를 4개씩 읽으며, 다시 읽을 때 배열의 처음 위치가 아닌 offset 위치 즉, buffer[offset] 부터 읽습니다.
	 offset은 읽은 데이터 수(readCnt) 만큼 증가합니다. 간혹 len만큼 증가하게 하는 경우가 있는데, 읽을 데이터의 수가 꼭 len 값으로 나누어 떨어지지 않기 때문에 offset은 읽은 데이터의 수(readCnt)만큼 증가 해주어야합니다.
	 보통 네트워크 통신할 때 많이 사용합니다.
	
	
	[public long skip(long n) throws IOException]
	 읽을 데이터 중 n 바이트를 스킵하고 실제로 스킵한 바이트 개수가 반환됩니다.
	
	
	[int available() throws IOException]
	 읽을 데이터(바이트)가 얼마나 남아있는지 반환됩니다.
	
	
	[public synchronized void mark(int readlimit) {} ]
	 되돌아갈 특정 위치를 마킹하는 메소드 입니다.
	 readlimit은 현재 위치를 마킹하고 최대 몇개의 byte를 더 읽을 수 있는지를 의미합니다.
	
	
	[
	 public synchronized void reset() throws IOException {
	 	 throw new IOException("mark/reset not supported");
	 }
	]
	 마킹한 지점으로 되돌아가는 메소드입니다.
	 기본적으로 지원되지 않으며, InputStream 추상클래스를 상속받은 클래스에서 오버라이딩해주어야 사용가능합니다.
	
	
	[public boolean markSupported() {
		return false;
	 }
	]
	 mark 메소드의 지원 유무를 확인하는 메소드입니다. 기본적으로 지원하지 않으므로 false를 반환합니다.
	 
	*/
	
	/*
	[OutputStream]
	 바이트 기반 출력 스트림의 최상위 추상클래스입니다.
	 모든 바이트 기반 출력 스트림 클래스는 이 클래스를 상속 받아 기능을 재정의 합니다.
	
	
	[
	 public abstract void write(int b) throws IOException;
	 
	 public void write(byte b[]) throws IOException {
	 	write(b, 0, b.length);
	 }
	 ------------------------------------------------------------------------
	 public void write01() throws IOException {
	 	byte[] bytes = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	 	
	 	File file = new File("D://write_test.txt");
	 	OutputStream outputStream = new FileOutputStream(file);
	 	
	 	for(byte b : bytes) {
	 		outputStream.write(b);
	 	}
	 	
	 	outputStream.close();
	 }
	]
	 바이트 배열을 write_text.txt 파일에 write하는 예제입니다. OutputStream을 상속받은 FileOutputStream을 생성하고, 
	 한 바이트 씩 write하거나 여러 바이트씩 write 할 수 있습니다. ( outputStream.write(bytes); )
	
	
	[public void write(byte b[], int offset, int len) throws IOException ]
	 byte 배열 b를 offset부터 len만큼 write합니다.
	
	
	[public void flush() throws IOException {} ]
	 버퍼를 지원하는 경우 버퍼에 존재하는 데이터를 목적지까지 보냅니다.
	 
	 
	[public void close() throws IOException {} ]
	 OutputStream을 종료합니다.
	*/
	
}
