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
		

		try(BufferedReader br = new BufferedReader(new FileReader(p));) {
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				
				al.add(line);
				
			}
		
		} catch(IOException e) {
			
			String fmessage = p.getName() + "을 가져오지 못했습니다!";
			Wordbook.state = fmessage;
			JOptionPane.showMessageDialog(null, fmessage + "\n" + e.getMessage(),"경고",JOptionPane.WARNING_MESSAGE);
			
		}
		
		return al;
		
	} //goget end
	
	
	public static void put(List<String> what, File path, String name) {
		
		File f1 = new File(path.getAbsolutePath() + "\\" + name + ".txt");

		try(BufferedWriter br1 = new BufferedWriter(new FileWriter(f1))) {
			
			if (!f1.exists()) f1.createNewFile();
			if (!f1.canWrite()) f1.setWritable(true);
		
			for (String word : what) {
			
				br1.write(word);
				br1.newLine();
				
			}
			
			br1.flush();
	
		} catch(IOException e) {
			
			String msg = name + "을 만드는 중 문제가 발생했습니다!";
			Wordbook.state = msg;
			JOptionPane.showMessageDialog(null, msg + "\n" + e.getMessage(),"경고",JOptionPane.WARNING_MESSAGE);
			
		} catch (NullPointerException e) {
			
			String msg = name + "을 만드는 중 문제가 발생했습니다!\n단어 파일을 다시 확인하세요, 단어 사이에 빈 줄이 있을 수 있습니다.";
			Wordbook.state = msg;
			JOptionPane.showMessageDialog(null, msg + "\n" + e.getMessage(),"경고",JOptionPane.WARNING_MESSAGE);
			
		}
		
		
	} //put end
	
	
} //class end
	
	
