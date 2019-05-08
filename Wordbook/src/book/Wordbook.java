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
		
		state = "�о���� ��...";
		
		ArrayList<String> eng = Text.goget((File)args[0]);
		ArrayList<String> kor = Text.goget((File)args[1]);
		
		ArrayList<String> kor1 = new ArrayList<String>();
		ArrayList<String> eng1 = new ArrayList<String>();
		
		int total = eng.size();
		
		if (total != kor.size()) {System.out.println("ũ�� �ٸ�!!");}
		
			//�����ϰ� ����
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
		
		
		state = "���� ��...";
		
		if ((boolean)args[3]) Text.putEng(eng1, (File)args[2], "���� �ܾ���");
		if ((boolean)args[4]) Text.putKor(kor1, (File)args[2], "�ѱ� �ܾ���");
		if ((boolean)args[5]) Text.putRan(book, (File)args[2], "�ѱ� + ���� �ܾ���");
		
		state = ("�Ϸ�!");
		
	}

}
