package book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Text {

	public static ArrayList<String> goget(File p) {
		
		ArrayList<String> al = new ArrayList<String>();
		BufferedReader br = null;

		try {
			
			br = new BufferedReader(new FileReader(p));
			String line = null;
			
			do {
			
				line = br.readLine();
				al.add(line);
			
			} while (line != null);
		
			br.close();
			
		} catch(IOException e) {
			
			String fmessage = p.getName() + "�� �������� ���߽��ϴ�!";
			Wordbook.state = fmessage;
			JOptionPane.showMessageDialog(null, fmessage + "\n" + e.getMessage(),"���",JOptionPane.WARNING_MESSAGE);
			
		}
		
		return al;
		
	} //goget end
	
	
	public static void put(List<String> what, File path, String name) {
		
		String o = path.getAbsolutePath() + "\\" + name + ".txt";
		File f1 = new File(o);
		BufferedWriter br1;

		try {
			
			br1 = new BufferedWriter(new FileWriter(f1));
			
			if (!f1.exists()) f1.createNewFile();
			if (!f1.canWrite()) f1.setWritable(true);
		
			for (String word : what) {
			
				br1.write(word);
				br1.newLine();
				br1.flush();
				
			}
	
			br1.close();
			
		} catch(IOException e) {
			
			String msg = name + "�� ����� �� ������ �߻��߽��ϴ�!";
			Wordbook.state = msg;
			JOptionPane.showMessageDialog(null, msg + "\n" + e.getMessage(),"���",JOptionPane.WARNING_MESSAGE);
			
		}
		
		
	} //put end
	
	
} //class end
	
	
