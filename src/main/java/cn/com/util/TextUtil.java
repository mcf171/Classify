package cn.com.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import cn.com.model.Record;

public class TextUtil {

	public static List<Record> getAllInformation(String fileName){
		
		List<Record> lists = new ArrayList<Record>();
		
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br=new BufferedReader(fr);
	        String line="";
	        String[] arrs=null;
	        while ((line=br.readLine())!=null) {
	            arrs=line.split(",");
	            Record record = new Record();
	            record.setAge(Integer.parseInt(arrs[0]));
	            record.setJob(arrs[1]);
	            record.setMarital(arrs[2]);
	            
	        }
	        br.close();
	        fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return lists;
	}
}
