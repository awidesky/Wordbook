package book;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Text {

	public static ArrayList<String> goget(File p) throws Exception {
		
		/**
		 * 
		 * read all lines from a txt file(parameter)
		 * 
		 * */
		
		ArrayList<String> al = new ArrayList<>();
		
		try {
			
			//BufferedReader br = new BufferedReader(new FileReader(p));
			al = (ArrayList<String>) Files.readAllLines(p.toPath(), Charset.defaultCharset());
			
			/*
			 * String line = null;
			 * 
			 * while((line = br.readLine()) != null) {
			 * 
			 * al.add(line);
			 * 
			 * }
			 */
		
		} catch(Exception e) {
			
			String fmessage = p.getName() + "�쓣 媛��졇�삤吏� 紐삵뻽�뒿�땲�떎!";
			JOptionPane.showMessageDialog(null, fmessage + "\n" + e.getMessage(),"寃쎄퀬",JOptionPane.WARNING_MESSAGE);
			
			throw new Exception("Process canceled");
			
		} 
		return al;
		
	} //goget end
	
	
	public static void put(List<String> what, File path, String name) throws Exception {
		
		/*
		 * make a txt file which contains text of given List to given path
		 * 
		 * */
		
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
			
			String msg = name + "�쓣 留뚮뱶�뒗 以� 臾몄젣媛� 諛쒖깮�뻽�뒿�땲�떎!";
			JOptionPane.showMessageDialog(null, msg + "\n" + e.getMessage(),"寃쎄퀬",JOptionPane.WARNING_MESSAGE);
			
			throw new Exception("Process canceled");
			
		} catch (NullPointerException e) {
			
			String msg = name + "�쓣 留뚮뱶�뒗 以� 臾몄젣媛� 諛쒖깮�뻽�뒿�땲�떎!\n�떒�뼱 �뙆�씪�쓣 �떎�떆 �솗�씤�븯�꽭�슂, �떒�뼱 �궗�씠�뿉 鍮� 以꾩씠 �엳�쓣 �닔 �엳�뒿�땲�떎.";
			JOptionPane.showMessageDialog(null, msg + "\n" + e.getMessage(),"寃쎄퀬",JOptionPane.WARNING_MESSAGE);
			
			throw new Exception("Process canceled");
			
		} catch (Exception e) {
			
			String msg = name + "�쓣 留뚮뱶�뒗 以� 臾몄젣媛� 諛쒖깮�뻽�뒿�땲�떎!\n�떒�뼱 �뙆�씪�쓣 �떎�떆 �솗�씤�븯�꽭�슂, �떒�뼱 �궗�씠�뿉 鍮� 以꾩씠 �엳�쓣 �닔 �엳�뒿�땲�떎.";
			JOptionPane.showMessageDialog(null, msg + "\n" + e.toString(),"寃쎄퀬",JOptionPane.WARNING_MESSAGE);
			
			throw new Exception("Process canceled");
			
		}
		
		
	} //put end
	
	
} //class end
	
	
