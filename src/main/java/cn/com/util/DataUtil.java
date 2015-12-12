package cn.com.util;

import java.util.ArrayList;
import java.util.List;

import cn.com.model.Record;
import cn.com.model.TransforRecord;

public class DataUtil {

	public static double avg_age_yes = 0, avg_duration_yes = 0, avg_campaign_yes = 0, avg_empVarRate_yes = 0, avg_consPriceIdx_yes = 0,avg_consConfIdx_yes = 0,avg_pdays_yes = 0;
	public static double std_bias_age_yes = 0, std_bias_duration_yes = 0, std_bias_campaign_yes = 0, std_bias_empVarRate_yes = 0, std_bias_consPriceIdx_yes = 0,std_bias_consConfIdx_yes = 0,std_bias_pdays_yes = 0;
	
	public static double avg_age_no = 0, avg_duration_no = 0, avg_campaign_no = 0, avg_empVarRate_no = 0, avg_consPriceIdx_no = 0,avg_consConfIdx_no = 0,avg_pdays_no = 0;
	public static double std_bias_age_no = 0, std_bias_duration_no = 0, std_bias_campaign_no = 0, std_bias_empVarRate_no = 0, std_bias_consPriceIdx_no = 0,std_bias_consConfIdx_no = 0,std_bias_pdays_no = 0;
	
	public static List<TransforRecord> standardization(List<Record> list)
	{
		double ageMin = list.get(0).getAge(),ageMax = list.get(0).getAge();
		double durationMin = list.get(0).getDuration(),durationMax = list.get(0).getDuration();
		double campaignMin = list.get(0).getCampaign(),campaignMax = list.get(0).getCampaign();
		double pdaysMin = list.get(0).getPdays(),pdaysMax = list.get(0).getPdays();
		double previousMin = list.get(0).getPrevious(),previousMax = list.get(0).getPrevious();
		double empVarRateMin = list.get(0).getEmpVarRate(),empVarRateMax = list.get(0).getEmpVarRate();
		double consPriceIdxMin = list.get(0).getConsPriceIdx(),consPriceIdxMax = list.get(0).getConsPriceIdx();
		double consConfIdxMin = list.get(0).getConsConfIdx(),consConfIdxMax = list.get(0).getConsConfIdx();
		double euribor3mMin = list.get(0).getEuribor3m(),euribor3mMax = list.get(0).getEuribor3m();
		double nrEmployedMin = list.get(0).getNrEmployed(),nrEmployedMax = list.get(0).getNrEmployed();
		
		List<TransforRecord> transforLists = new ArrayList<TransforRecord>();
		int numberOfYes = 0, numberOfNo = 0;
		double sum_age_yes = 0, sum_duration_yes = 0, sum_campaign_yes = 0, sum_empVarRate_yes = 0, sum_consPriceIdx_yes = 0,sum_consConfIdx_yes = 0,sum_pdays_yes = 0;
		double sum_age_no = 0, sum_duration_no = 0, sum_campaign_no = 0, sum_empVarRate_no = 0, sum_consPriceIdx_no = 0,sum_consConfIdx_no = 0,sum_pdays_no = 0;
		for(Record record : list){
			
			if(record.getLabel().equals("yes")){
				
				sum_age_yes += record.getAge();
				sum_duration_yes += record.getDuration();
				sum_campaign_yes += record.getCampaign();
				sum_empVarRate_yes += record.getEmpVarRate();
				sum_consPriceIdx_yes += record.getConsPriceIdx();
				sum_consConfIdx_yes += record.getConsConfIdx();
				sum_pdays_yes += record.getPdays();
				numberOfYes ++;
			}else if(record.getLabel().equals("no")){
				
				sum_age_no += record.getAge();
				sum_duration_no += record.getDuration();
				sum_campaign_no += record.getCampaign();
				sum_empVarRate_no += record.getEmpVarRate();
				sum_consPriceIdx_no += record.getConsPriceIdx();
				sum_consConfIdx_no += record.getConsConfIdx();
				sum_pdays_no += record.getPdays();
				numberOfNo++;
			}
			
			
			if(record.getAge() < ageMin)
				ageMin = record.getAge();
			else if(record.getAge() > ageMax)
				ageMax = record.getAge();
			
			if(record.getDuration() < durationMin)
				durationMin = record.getDuration();
			else if(record.getDuration() > durationMax)
				durationMax = record.getDuration();
				
			if(record.getCampaign() < campaignMin)
				campaignMin = record.getCampaign();
			else if(record.getCampaign() > campaignMax)
				campaignMax = record.getCampaign();
			
			if(record.getPdays() < pdaysMin)
				pdaysMin = record.getPdays();
			else if(record.getPdays() > pdaysMax)
				pdaysMax = record.getPdays();
			
			if(record.getPrevious() < previousMin)
				previousMin = record.getPrevious();
			else if(record.getPrevious() > previousMax)
				previousMax = record.getPrevious();
								
			if(record.getEmpVarRate() < empVarRateMin)
				empVarRateMin = record.getEmpVarRate();
			else if(record.getEmpVarRate() > empVarRateMax)
				empVarRateMax = record.getEmpVarRate();
			
			if(record.getConsPriceIdx() < consPriceIdxMin)
				consPriceIdxMin = record.getConsPriceIdx();
			else if(record.getConsPriceIdx() > consPriceIdxMax)
				consPriceIdxMax = record.getConsPriceIdx();
			
			if(record.getConsConfIdx() < consConfIdxMin)
				consConfIdxMin = record.getConsConfIdx();
			else if(record.getConsConfIdx() > consConfIdxMax)
				consConfIdxMax = record.getConsConfIdx();
				
			if(record.getEuribor3m() < euribor3mMin)
				euribor3mMin = record.getEuribor3m();
			else if(record.getEuribor3m() > euribor3mMax)
				euribor3mMax = record.getEuribor3m();
			
			if(record.getNrEmployed() < nrEmployedMin)
				nrEmployedMin = record.getNrEmployed();
			else if(record.getNrEmployed() > nrEmployedMax)
				nrEmployedMax = record.getNrEmployed();
			
			
			
		}
		
		avg_age_no = sum_age_no/numberOfNo;
		avg_campaign_no = sum_campaign_no/numberOfNo;
		avg_consConfIdx_no = sum_consConfIdx_no/numberOfNo;
		avg_consPriceIdx_no = sum_consPriceIdx_no/numberOfNo;
		avg_duration_no = sum_duration_no/numberOfNo;
		avg_empVarRate_no = sum_empVarRate_no/numberOfNo;
		avg_pdays_no = sum_pdays_no/numberOfNo;
		
		avg_age_yes = sum_age_yes/numberOfYes;
		avg_campaign_yes = sum_campaign_yes/numberOfYes;
		avg_consConfIdx_yes = sum_consConfIdx_yes/numberOfYes;
		avg_duration_yes = sum_duration_yes/numberOfYes;
		avg_empVarRate_yes = sum_empVarRate_yes/numberOfYes;
		avg_pdays_yes = sum_pdays_yes/numberOfYes;
		
		int count = 0;
		for(Record record : list){
			
			
			if(record.getLabel().equals("yes")){
				
				std_bias_age_yes += Math.pow(record.getAge() - avg_age_yes, 2);
				std_bias_campaign_yes += Math.pow(record.getCampaign() - avg_campaign_yes, 2);
				std_bias_consConfIdx_yes += Math.pow(record.getConsConfIdx() - avg_consConfIdx_yes, 2);
				std_bias_consPriceIdx_yes += Math.pow(record.getConsPriceIdx() - avg_consPriceIdx_yes, 2);
				std_bias_duration_yes += Math.pow(record.getDuration() - avg_duration_yes, 2);
				std_bias_empVarRate_yes += Math.pow(record.getEmpVarRate() - avg_empVarRate_yes, 2);
				std_bias_pdays_yes += Math.pow(record.getPdays() - avg_pdays_yes, 2);
				
			}else if(record.getLabel().equals("no")){
				
				std_bias_age_no += Math.pow(record.getAge() - avg_age_no, 2);
				std_bias_campaign_no += Math.pow(record.getCampaign() - avg_campaign_no, 2);
				std_bias_consConfIdx_no += Math.pow(record.getConsConfIdx() - avg_consConfIdx_no, 2);
				std_bias_consPriceIdx_no += Math.pow(record.getConsPriceIdx() - avg_consPriceIdx_no, 2);
				std_bias_duration_no += Math.pow(record.getDuration() - avg_duration_no, 2);
				std_bias_empVarRate_no += Math.pow(record.getEmpVarRate() - avg_empVarRate_no, 2);
				std_bias_pdays_no += Math.pow(record.getPdays() - avg_pdays_no, 2);
			}
			
			TransforRecord transforRecord = new TransforRecord();
			
			transforRecord.setAge((record.getAge()-ageMin)/(ageMax - ageMin));
			transforRecord.setDirty(record.isDirty());
			
			transforRecord.transforJob(record.getJob());
			transforRecord.transforMarital(record.getMarital());
			transforRecord.transforEducation(record.getEducation());
			transforRecord.transforDefaultCredit(record.getDefaultCredit());
			transforRecord.transforHousing(record.getHousing());
			transforRecord.transforLoan(record.getLoan());
			transforRecord.transforContact(record.getContact());
			transforRecord.transforMonth(record.getMonth());
			transforRecord.transforDayOfWeek(record.getDayOfWeek());
			transforRecord.setDuration((record.getDuration()-durationMin)/(durationMax -durationMin));
			transforRecord.setCampaign((record.getCampaign()-campaignMin)/(campaignMax-campaignMin));
			transforRecord.setPdays((record.getPdays()-pdaysMin)/(pdaysMax-pdaysMin));
			transforRecord.setPrevious((record.getPrevious()-previousMin)/(previousMax-previousMin));
			transforRecord.transforPoutcome(record.getPoutcome());
			transforRecord.setEmpVarRate((record.getEmpVarRate()-empVarRateMin)/(empVarRateMax-empVarRateMin));
			transforRecord.setConsPriceIdx((record.getConsPriceIdx()-consPriceIdxMin)/(consPriceIdxMax-consPriceIdxMin));
			transforRecord.setConsConfIdx((record.getConsConfIdx()-consConfIdxMin)/(consConfIdxMax-consConfIdxMin));
			transforRecord.setEuribor3m((record.getEuribor3m()-euribor3mMin)/(euribor3mMax-euribor3mMin));
			transforRecord.setNrEmployed((record.getNrEmployed()-nrEmployedMin)/(nrEmployedMax-nrEmployedMin));
			
			transforRecord.setLabel(record.getLabel());
			if(transforRecord.isDirty()){
				count++;
			}
			transforLists.add(transforRecord);
		}
		System.out.println("dirty record count:" + count );
		return transforLists;
	}
}