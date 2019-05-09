package book;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

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
		
		/* code for debugging
		 * 
		 * Iterator<String> it = eng.iterator(); Iterator<String> iu = kor.iterator();
		 * 
		 * while(it.hasNext()) System.out.println(it.next()); while(iu.hasNext())
		 * System.out.println(iu.next());
		 */
		
		
		
		int total = eng.size();
		
		if (total != kor.size()) {
			
			JOptionPane.showMessageDialog(null, "영어단어와 한글 뜻의 개수가 다릅니다. 각 파일들을 다시 확인하세요.","경고",JOptionPane.WARNING_MESSAGE);
			return;
			
		}
		
			//랜덤하게 섞음
		while(total != 0){
			
			Random r = new Random();
			
			int num = r.nextInt(total);
			
			int whether = r.nextInt(2); //랜덤 영어장에 영어를 넣을지 한글을 넣을지 결정
			
			if (whether == 0) book.add(eng.get(num));
			else book.add(kor.get(num));
			
			kor1.add(kor.get(num));
			eng1.add(eng.get(num));
			
			eng.remove(num);
			kor.remove(num);
			
			total--;
			
		}		
		
		
		state = "적는 중...";
		
		if ((boolean)args[3]) Text.putEng(eng1, (File)args[2], "영어 단어장");
		if ((boolean)args[4]) Text.putKor(kor1, (File)args[2], "한글 단어장");
		if ((boolean)args[5]) Text.putRan(book, (File)args[2], "한글 + 영어 단어장");
		
		state = ("완료!");
		
	}

}
