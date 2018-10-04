package book;

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
 * to run this program in command, not using normal way(lunch by GUI made in VB .net), use this command : java -jar wordbook.jar option1 option2 option3 option4 option5 option6 option7 option8
 * option1 = name of file which contains Korean words.
 * option2 = name of file which contains English words.
 * option3 = name of file which will made by this program and contains randomized English words. If you do not want to make this file, type null.
 * option4 = name of file which will made by this program and contains randomized Korean words. If you do not want to make this file, type null.
 * option5 = name of file which will made by this program and contains randomized random(some are Korean, others are English) words. If you do not want to make this file, type null.
 * option6 = If you want to make randomized English words file, type O. if not, type X.
 * option7 = If you want to make randomized Korean words file, type O. if not, type X.
 * option8 = If you want to make randomized random(some are Korean, others are English) words file, type O. if not, type X.
 * 
 * Examples : java -jar wordbook.jar kor eng mykor myeng myran O O O
 * This will read words of kor.txt, eng.txt and make mykor.txt, myeng.txt, myran.txt
 *
 * 
 * */

public class Wordbook {

	public static void main(String[] args) {
		
		
		String path = Paths.getcodepath();
		
		
		// Check if option is Successfully gotten
		if (args.length != 8) {
		
			System.err.println("옵션을 입력하세요");
			System.exit(1);
			
		}
		

		String ko = path + "\\" + args[0] + ".txt";
		String en = path + "\\" + args[1] + ".txt";

		ArrayList<String> book = new ArrayList<String>();
		
		System.out.println("읽어오는 중...");
		
		ArrayList<String> eng = Text.goget(en);
		ArrayList<String> kor = Text.goget(ko);
		
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
		
		
		System.out.println("적는 중...");
		
		if (args[5].equals("O")) Text.putEng(eng1, args[2]);
		if (args[6].equals("O")) Text.putKor(kor1, args[3]);
		if (args[7].equals("O")) Text.putRan(book, args[4]);
		
		System.out.println("완료!");
		
	}

}
