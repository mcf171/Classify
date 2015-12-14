package cn.com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.model.Record;
import cn.com.service.Gain;

public class Preprocess {
	
	public void hierarchy(ArrayList<Record> datas) {
		for(int i =0; i<datas.size(); i++) {
			Record record = datas.get(i);
			int age = record.getAge();
			double duration = record.getDuration();
			double campaign  = record.getCampaign();
			double pdays = record.getPdays();
			double euribor3m = record.getEuribor3m();
			
			if(age < 0){
				record.setAge(0);
			}else if(age >= 0 || age < 10) {
				record.setAge(1);
			}else if(age >= 10 || age < 20) {
				record.setAge(2);
			}else if(age >= 20 || age < 30) {
				record.setAge(3);
			}else if(age >= 30 || age < 40 ){
				record.setAge(4);
			}else if(age >= 40 || age < 50) {
				record.setAge(5);
			}else if(age >= 50 || age < 60){
				record.setAge(6);
			}else if(age >= 60 || age < 70){
				record.setAge(7);
			}else if(age >= 70 || age < 80) {
				record.setAge(8);
			}else if(age >= 80 || age < 90) {
				record.setAge(9);
			}else{
				record.setAge(10);
			}
			
			if(duration == 0) {
				record.setDuration(0);
			}else if(duration >0 || duration < 300) {
				record.setDuration(1);
			}else if(duration >=300 || duration < 600) {
				record.setDuration(2);
			}else if(duration >=600 || duration < 900) {
				record.setDuration(3);
			}else if(duration >=900 || duration < 1200) {
				record.setDuration(4);
			}else if(duration >=1200 || duration < 1500) {
				record.setDuration(5);
			}else if(duration >=1500 || duration < 1800) {
				record.setDuration(6);
			}else if(duration >=1800 || duration < 2100) {
				record.setDuration(7);
			}else if(duration >=2100 || duration < 2400) {
				record.setDuration(8);
			}else if(duration >=2400 || duration < 2700) {
				record.setDuration(9);
			}else if(duration >=2700 || duration < 3000) {
				record.setDuration(10);
			}else if(duration >=3000 || duration < 3300) {
				record.setDuration(11);
			}else if(duration >=3300 || duration < 3600) {
				record.setDuration(12);
			}else{
				record.setDuration(13);
			}
			
			if(campaign  < 0) {
				record.setCampaign(0);
			}else if(campaign  >=0 || campaign  < 60) {
				record.setCampaign ((int)campaign/5 + 1);
			}else{
				record.setCampaign(13);
			}
			
			if(pdays  < 0) {
				record.setPdays(0);
			}else if(pdays  >=0 || pdays  < 30) {
				record.setPdays ((int)pdays/3 + 1);
			}else{
				record.setPdays(12);
			}
			
			if(euribor3m < 0) {
				record.setEuribor3m(0);
			}else if(campaign  >=0 || campaign  < 0.5) {
				record.setEuribor3m (1);
			}else if(duration >0.5 || duration < 1) {
				record.setEuribor3m(2);
			}else if(duration >=1 || duration < 1.5) {
				record.setEuribor3m(3);
			}else if(duration >=1.5 || duration < 2.0) {
				record.setEuribor3m(4);
			}else if(duration >=2.0 || duration < 2.5) {
				record.setEuribor3m(5);
			}else if(duration >=2.5 || duration < 3.0) {
				record.setEuribor3m(6);
			}else if(duration >=3.0 || duration < 3.5) {
				record.setEuribor3m(7);
			}else if(duration >=3.5 || duration < 4.0) {
				record.setEuribor3m(8);
			}else if(duration >=4.0 || duration < 4.5) {
				record.setEuribor3m(9);
			}else if(duration >=4.5 || duration < 5.0) {
				record.setEuribor3m(10);
			}else if(duration >=5.0 || duration < 5.5) {
				record.setEuribor3m(11);
			}else{
				record.setEuribor3m(12);
			}
			
		}
		
		
	}
	
	public ArrayList<String> attrChoice(ArrayList<Record> datas) {
		ArrayList<String> attrList = new ArrayList<String>();
		ArrayList<String> tempList = new ArrayList<String>();
		tempList.add("age");
		tempList.add("job");
		tempList.add("marital");
		tempList.add("education");
		tempList.add("defaultCredit");
		tempList.add("housing");
		tempList.add("loan");
		tempList.add("contact");
		tempList.add("month");
		tempList.add("dayOfWeek");
		tempList.add("duration");
		tempList.add("campaign");
		tempList.add("pdays");
		tempList.add("previous");
		tempList.add("poutcome");
		tempList.add("empVarRate");
		tempList.add("consPriceIdx");
		tempList.add("consConfIdx");
		tempList.add("euribor3m");
		tempList.add("nrEmployed");
		Gain gain = new Gain(datas,tempList);
		
		//----------------------查看各属性的数值范围-----------------------------------------
	/*	ArrayList arr = gain.getValuesOfAttr(datas, "nrEmployed");
		Collections.sort(arr);
		
		Collections.sort(arr, new Comparator() {
		      @Override
		      public int compare(Object o1, Object o2) {
		        return new Double((String) o1).compareTo(new Double((String) o2));
		      }
		    });
		for(int i=0 ; i<arr.size(); i++) {
			System.out.print(arr.get(i) + "  ");
			if( i % 10 == 0){
				System.out.println();
			}
		}*/
		//---------------------------------------------------------------------------
		
		//----------------------每次取最大信息增益值------------------------------------------
		/*for(int i=0 ; i<10; i++) {
			String bestAttr = gain.bestGainAttr();
			attrList.add(bestAttr);
			tempList.remove(bestAttr);
		}*/
		//-------------------------------------------------------------------------------
		
		//-------------------------直接取前十个-----------------------------------------------
		Map<String, Double> attrMap = new HashMap<String, Double>();
		for(int i=0; i<tempList.size(); i++) {
			double gainInfo = gain.getExpectionByAttr(tempList.get(i));
			attrMap.put(tempList.get(i), gainInfo);
		}
		
		List<Map.Entry<String, Double>> infoIds =new ArrayList<Map.Entry<String, Double>>(attrMap.entrySet());
		
		for (int i = 0; i < infoIds.size(); i++) {
		    String id = infoIds.get(i).getKey();
		}
		
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Double>>() {   
		    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {      
		        if ((o2.getValue() - o1.getValue())>0) {
		        	return 1;  		        	
		        }else if((o2.getValue() - o1.getValue())==0) {
		        	return 0;  		        	
		        }else{
		        	return -1;		        	
		        }
		    }
		});
		for (int i = 0; i < 10; i++) {
		    String id = infoIds.get(i).getKey();
		    attrList.add(id);
		}
		//--------------------------------------------------------------------------------------
		
		return attrList;
	}
	
	/*public static void main(String[] args) {
		List<Record> lists = TextUtil.getAllInformation("bank-additional-full.csv");
		Preprocess p =new Preprocess();
		p.hierarchy((ArrayList)lists);
		ArrayList t = new ArrayList();
		t = p.attrChoice((ArrayList)lists);
		for(int i=0; i<56; i++) {
			System.out.println(i + ":  " + i/5);
		}
	}*/
	
	
}


























