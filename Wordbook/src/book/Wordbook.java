package book;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Eugene, Hong
 * @version 1.2.0
 * 
 * 
 * This project can be used for memorize English vocabulary easier.
 * 
 * 
 * */

public class Wordbook {

	public static String state; 
	
	public static void launch(Object[] args) {

		ArrayList<String> book = new ArrayList<String>();
		
		state = "읽어오는 중...";
		
		ArrayList<String> eng = Text.goget((File)args[0]);
		ArrayList<String> kor = Text.goget((File)args[1]);
		
		ArrayList<String> kor1 = new ArrayList<String>();
		ArrayList<String> eng1 = new ArrayList<String>();
		
		int total = eng.size();
		
		
			//랜덤하게 섞음
		while(total != 0){
			
			Random r = new Random();
			
			int num = r.nextInt(total);
			
			int whether = r.nextInt(2);
			
			if (whether == 0) book.add(eng.get(num));
			else book.add(kor.get(num));
			
			kor1.add(kor.get(num));
			eng1.add(eng.get(num));
			
			eng.remove(num);
			kor.remove(num);
			
			total--;
			
		}		
		
		
		state = "적는 중...";
		
		if ((boolean)args[2]) Text.putEng(eng1, "영어 단어장");
		if ((boolean)args[3]) Text.putKor(kor1, "한글 단어장");
		if ((boolean)args[4]) Text.putRan(book, "한글 + 영어 단어장");
		
		state = ("완료!");
		
	}

}
