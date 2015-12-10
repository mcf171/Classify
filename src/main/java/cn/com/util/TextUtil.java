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
		int count = 0;
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br=new BufferedReader(fr);
	        String line="";
	        String[] arrs=null;
	        line = br.readLine();
	        while ((line=br.readLine())!=null) {
	            arrs=line.split(";");
	            Record record = new Record();
	            for(String values : arrs){
	            	if(values.equals("unknown")){
	            		record.setDirty(true);
	            		count++;
	            	}
	            }
	            record.setAge(Integer.parseInt(arrs[0]));
	            record.setJob(arrs[1]);
	            record.setMarital(arrs[2]);
	            record.setEducation(arrs[3]);
	            record.setDefaultCredit(arrs[4]);
	            record.setHousing(arrs[5]);
	            record.setLoan(arrs[6]);
	            record.setContact(arrs[7]);
	            record.setMonth(arrs[8]);
	            record.setDayOfWeek(arrs[9]);
	            record.setDuration(Double.parseDouble(arrs[10]));
	            record.setCampaign(Double.parseDouble(arrs[11]));
	            record.setPdays(Double.parseDouble(arrs[12]));
	            record.setPrevious(Double.parseDouble(arrs[13]));
	            record.setPoutcome(arrs[14]);
	            record.setEmpVarRate(Double.parseDouble(arrs[15]));
	            record.setConsPriceIdx(Double.parseDouble(arrs[16]));
	            record.setConsConfIdx(Double.parseDouble(arrs[17]));
	            record.setEuribor3m(Double.parseDouble(arrs[18]));
	            record.setNrEmployed(Double.parseDouble(arrs[19]));
	            record.setLabel(arrs[20]);
	            lists.add(record);
	        }
	        System.out.println("dirty record number is :" + count);
	        br.close();
	        fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return lists;
	}
}
