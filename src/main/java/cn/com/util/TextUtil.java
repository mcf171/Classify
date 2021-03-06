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
	        int divorced = 0 , married = 0, single = 0,unknown=0;
	        while ((line=br.readLine())!=null) {
	        	line = line.replace("\"", "");
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
	            if(arrs[2].equals("divorced"))
	            	divorced ++;
	            if(arrs[2].equals("married"))
	            	married ++;
	            if(arrs[2].equals("single"))
	            	single ++;
	            if(arrs[2].equals("unknown")){
	            	record.setMarital("married");
	            }
	            
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
	        System.out.println("dirty attribute number is :" + count);
	        br.close();
	        fr.close();
	        //System.out.println(divorced + "," + married + "," + single +"," + unknown);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int counts = 0;
        for(Record record : lists){
        	if(record.isDirty())
        		counts++;
        }
        System.out.println("dirty attribute record is :" + counts);
		
		return lists;
	}
	
	/**
	 * 读取指定开始和结束的record
	 * read the records form the startIndex to the endIndex in the file
	 * @param fileName
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static List<Record> getAllInformation(String fileName, int startIndex, int endIndex){
		
		List<Record> lists = new ArrayList<Record>();
		int count = 0;
		int index = 0;
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br=new BufferedReader(fr);
	        String line="";
	        String[] arrs=null;
	        line = br.readLine();
	        while ((line=br.readLine())!=null) {
	        	line = line.replace("\"", "");
	            arrs=line.split(";");
	            Record record = new Record();
	            for(String values : arrs){
	            	if(values.equals("unknown")){
	            		record.setDirty(true);
	            		count++;
	            	}
	            }
	            
	            if(index >= startIndex){
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
	            }else if(index > endIndex)
	            	break;
	            index ++;
	        }
	        System.out.println("dirty attribute number is :" + count);
	        br.close();
	        fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int counts = 0;
        for(Record record : lists){
        	if(record.isDirty())
        		counts++;
        }
        System.out.println("dirty attribute record is :" + counts);
		
		return lists;
	}
}
