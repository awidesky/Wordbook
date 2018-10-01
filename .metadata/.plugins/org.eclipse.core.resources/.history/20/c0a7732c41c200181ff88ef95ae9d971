package book;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Paths {

	public static String getcodepath() {
		
		String a = Wordbook.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String path = null;
		
		try {
			
			path = URLDecoder.decode(a, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("텍스트 인코딩 실패");
			
		}
		
		return path;
		
		
	} 
}
