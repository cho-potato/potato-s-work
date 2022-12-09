package io.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

// 지금까지 우리가 다뤄왔던 입출력은 파일에 국한되었으나 
// 실행 중인 프로그램으로 데이터를 입력받거나 출력하는 것은
// 파일 뿐만 아니라 다양한 대상으로 할 수 있다
// 이번 예제에서는 키보드를 대상으로 입력을 처리해보자 

public class KeyBoardApp2 {

	public static void main(String[] args) {
		InputStream is = System.in;
		PrintStream ps = System.out;
		
		int data = -1;
		try {
			while(true) {
			data = is.read(); // 1byte 읽기
			ps.println((char)data); // 평상시 사용해오던 System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
