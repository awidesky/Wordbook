package book;

import java.io.File;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * 
 * @author Eugene, Hong
 * @version 1.2.0
 * 
 * 
 * This project is used for memorize English vocabulary easier.
 * 
 * 
 * */

public class Wordbook {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(()->{
			
			new GUI();
			
		});
	}
	
	public static void launch(Object[] args) throws Exception {

		/*
		 * @param (file)input_eng, (file)input_kor, (file)output_path, (Boolean)cbx_eng.isSelected(), (Boolean)cbx_kor.isSelected(), (Boolean)cbx_ran.isSelected()
		 * 
		 * 
		 * */
		
		
		List<String> eng = Text.goget((File)args[0]);
		List<String> kor = Text.goget((File)args[1]);
		
		List<String> kor1 = new ArrayList<>();
		List<String> eng1 = new ArrayList<>();
		List<String> ran = new ArrayList<>();
		
		/*
		 * codes for debugging
		 * 
		 * Iterator<String> it = eng.iterator(); Iterator<String> iu = kor.iterator();
		 * 
		 * while(it.hasNext()) System.out.println(it.next()); System.out.println();
		 * while(iu.hasNext()) System.out.println(iu.next());
		 */ 
		 
		
		
		int total = eng.size();
		
		if (total != kor.size()) {
			
			JOptionPane.showMessageDialog(null, "����� �ѱ� �ܾ��� ������ �ٸ��ų� �߸��� ������ �����߽��ϴ�. �� ���ϵ��� �ٽ� Ȯ���ϼ���.","���",JOptionPane.WARNING_MESSAGE);
			return;
			
		}
		
		//�����ϰ� ����
		while(total != 0){
			
			Random r = new Random();
			
			int num = r.nextInt(total);
			
			if (r.nextBoolean()) { ran.add(eng.get(num)); }
			else 				 { ran.add(kor.get(num)); }
			
			kor1.add(kor.get(num));
			eng1.add(eng.get(num));
			
			eng.remove(num);
			kor.remove(num);
			
			total--;
			
		}		
		
		
		if ((boolean)args[3]) Text.put(eng1, (File)args[2], "���� �ܾ���");
		if ((boolean)args[4]) Text.put(kor1, (File)args[2], "�ѱ� �ܾ���");
		if ((boolean)args[5]) Text.put(ran, (File)args[2], "�ѱ� + ���� �ܾ���");
		
		JOptionPane.showMessageDialog(null, "���� �Ϸ�!","�Ϸ�!",JOptionPane.INFORMATION_MESSAGE);
		
	}

}
