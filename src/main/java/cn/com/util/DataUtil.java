package cn.com.util;

import java.util.ArrayList;
import java.util.List;

import cn.com.model.Record;
import cn.com.model.TransforRecord;

public class DataUtil {

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
		
		for(Record record : list){
			
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
		
		for(Record record : list){
			

			TransforRecord transforRecord = new TransforRecord();
			
			transforRecord.setAge(record.getAge()-ageMin/ageMax - ageMin);
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
			transforRecord.setDuration(record.getDuration()-durationMin/durationMax -durationMin);
			transforRecord.setCampaign(record.getCampaign()-campaignMin/campaignMax-campaignMin);
			transforRecord.setPdays(record.getPdays()-pdaysMin/pdaysMax-pdaysMin);
			transforRecord.setPrevious(record.getPrevious()-previousMin/previousMax-previousMin);
			transforRecord.transforPoutcome(record.getPoutcome());
			transforRecord.setEmpVarRate(record.getEmpVarRate()-empVarRateMin/empVarRateMax-empVarRateMin);
			transforRecord.setConsPriceIdx(record.getConsPriceIdx()-consPriceIdxMin/consPriceIdxMax-consPriceIdxMin);
			transforRecord.setConsConfIdx(record.getConsConfIdx()-consConfIdxMax/consConfIdxMax-consConfIdxMin);
			transforRecord.setEuribor3m(record.getEuribor3m()-euribor3mMin/euribor3mMax-euribor3mMin);
			transforRecord.setNrEmployed(record.getNrEmployed()-nrEmployedMin/nrEmployedMax-nrEmployedMin);
			transforRecord.setLabel(record.getLabel());
			
			transforLists.add(transforRecord);
		}
		
		return transforLists;
	}
}
