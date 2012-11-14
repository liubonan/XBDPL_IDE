package helper;

import java.io.File;
import java.io.IOException;

public class Filename {
	
	private final String randomString = "abcdefghijklmnopqrstuvwxyz0123456789";
	public Filename(){
		
	}
	
	public String getFilename(){
		StringBuffer s = null;
		boolean flag = true;

		while (flag) {
			s = new StringBuffer();
			for (int i = 0; i < 10; i++) {
				int temp = 0;				
				temp=(int) (Math.random() * 36);				
				s.append(randomString.charAt(temp));
			}
			
			File init = new File("/tmp/XBDPL");
			if(!init.exists()){
				try {
					Runtime.getRuntime().exec("mkdir XBDPL", null, new File("/tmp/"));
					Runtime.getRuntime().exec("chmod 777 XBDPL", null, new File("/tmp/"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			

			flag = false;
			File f = new File("/tmp/XBDPL/");
			File[] fList = f.listFiles();

			for (int i = 0; i < fList.length; i++) {
				if (fList[i].isDirectory()) {
					if (fList[i].getName().equals(s.toString())) {
						flag = true;
					}
				}
			}
		}		
		return s.toString();
	}
	
	

}
