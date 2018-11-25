package book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Text {

	public static ArrayList<String> goget(File p) {
		
		ArrayList<String> al = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(p));
		} catch (FileNotFoundException e) {
			System.err.println("텍스트 파일 " + p.getPath() + "(이)가 존재하지않습니다.");
		}
		
		while (true) {
			
			String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				System.err.println(p.getPath() + "(을)를 읽어올 수 없습니다.");
			}
			
			if (line == null) break;
			
			al.add(line);
			
		}
		
		try {
			br.close();
		} catch (IOException e) {
			System.err.println("BufferedReader를 close 하는 동안 문제가 발생했습니다");
		}
		
		return al;
	} //goget end
	
	
	public static void putEng(ArrayList<String> what, String name) {
		
		String o = Paths.getcodepath() + "\\" + name + ".txt";
		
		File f1 = new File(o);
		
		BufferedWriter br1 = null;

		try {
			br1 = new BufferedWriter(new FileWriter(f1));
		} catch (IOException e) {
			System.err.println("영어 단어장을 만드는 준비를 하는 도중 문제가 발생했습니다.");
		}
		
		if (!f1.exists())
			try {
				f1.createNewFile();
			} catch (IOException e) {
				System.err.println("영어 단어장을 만드는 도중 문제가 발생했습니다.");
			}
		if (!f1.canWrite()) f1.setWritable(true);
		
		for (int i = 0; i < what.size(); i++) {
			
			try {
				br1.write((String)what.get(i));
				br1.newLine();
				br1.flush();
			} catch (IOException e) {
				System.err.println("뜻 단어장에 적어넣는 도중 문제가 발생했습니다.");
			}
				
				
		}
	
		try {
			br1.close();
		} catch (IOException e) {
			System.err.println("BufferedWriter를 close 하는 동안 문제가 발생했습니다");
		}
		
	} //putEng end
	
	
	public static void putKor(ArrayList<String> what, String name) {
		
		String p1 = Paths.getcodepath() + "\\" + name + ".txt";
		
		File f2 = new File(p1);
		
		BufferedWriter br2 = null;

		try {
			br2 = new BufferedWriter(new FileWriter(f2));
		} catch (IOException e) {
			System.err.println("뜻 단어장을 만드는 준비를 하는 도중 문제가 발생했습니다.");
		}
		

		if (!f2.exists())
			try {
				f2.createNewFile();
			} catch (IOException e) {
				System.err.println("뜻 단어장을 만드는 도중 문제가 발생했습니다.");
			}
		if (!f2.canWrite()) f2.setWritable(true);
		
		for (int i = 0; i < what.size(); i++) {
			
			try {
				br2.write((String)what.get(i));
				br2.newLine();
				br2.flush();
			} catch (IOException e) {
				System.err.println("뜻 단어장에 적어넣는 도중 문제가 발생했습니다.");
			}
				
				
		}
	
		try {
			br2.close();
		} catch (IOException e) {
			System.err.println("BufferedWriter를 close 하는 동안 문제가 발생했습니다");
		}

	} //putKor end
		
	
	

	public static void putRan(ArrayList<String> what, String name) {
	
		String p = Paths.getcodepath() + "\\" + name + ".txt";
		
		File f = new File(p);
		
		BufferedWriter br = null;
	
		try {
			br = new BufferedWriter(new FileWriter(f));
		} catch (IOException e) {
			System.err.println("영어+뜻 단어장을 만드는 준비를 하는 도중 문제가 발생했습니다.");
		}
		
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.err.println("영어+뜻 단어장을 만드는 도중 문제가 발생했습니다.");
			}
		if (!f.canWrite()) f.setWritable(true);
		
		for (int i = 0; i < what.size(); i++) {
			
			try {
				br.write((String)what.get(i));
				br.newLine();
				br.flush();
			} catch (IOException e) {
				System.err.println("영어+뜻 단어장에 적어넣는 도중 문제가 발생했습니다.");
			} 
			
		}

		try {
			br.close();
		} catch (IOException e) {
			System.err.println("BufferedWriter를 close 하는 동안 문제가 발생했습니다");
		}
			
	} //putRan
	
	
} //class end
	
	
