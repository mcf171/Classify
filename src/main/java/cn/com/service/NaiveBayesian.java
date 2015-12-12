package cn.com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.model.Record;
import cn.com.model.TransforRecord;
import cn.com.util.CalculateLDA;
import cn.com.util.DataUtil;
import cn.com.util.TextUtil;

public class NaiveBayesian {
	
	public static String calculateTheLabel(Object[] attributes){
		
		String label = null;
		
		List<Record> recordLists = TextUtil.getAllInformation("bank-additional-full.csv");
		
		Object[][] values = new Object[41188][22];
		for(int i = 0 ; i < 41188; i ++){
			
			Record record = recordLists.get(i);
			values[i][0] = record.getAge();
			values[i][1] = record.getJob();
			values[i][2] = record.getMarital();
			values[i][3] = record.getEducation();
			values[i][4] = record.getDefaultCredit();
			values[i][5] = record.getHousing();
			values[i][6] = record.getLoan();
			values[i][7] = record.getContact();
			values[i][8] = record.getMonth();
			values[i][9] = record.getDayOfWeek();
			values[i][10] = record.getDuration();
			values[i][11] = record.getCampaign();
			values[i][12] = record.getPdays();
			values[i][13] = record.getPrevious();
			values[i][14] = record.getPoutcome();
			values[i][15] = record.getEmpVarRate();
			values[i][16] = record.getConsPriceIdx();
			values[i][17] = record.getConsConfIdx();
			values[i][18] = record.getEuribor3m();
			values[i][19] = record.getNrEmployed();
			values[i][20] = record.getLabel();
			values[i][21] = record.isDirty();
		}
		
		List<TransforRecord> transRecords = DataUtil.standardization(recordLists);
		
		int[] w = CalculateLDA.getAttribute(transRecords);
		
		transRecords = null;
		double p_age_yes = 0, p_duration_yes = 0, p_campaign_yes = 0, p_pdays_yes = 0, p_empVarRate_yes = 0, p_consPriceIdx_yes = 0, p_consConfIdx_yes = 0;
		double p_age_no = 0, p_duration_no = 0, p_campaign_no = 0, p_pdays_no = 0, p_empVarRate_no = 0, p_consPriceIdx_no = 0, p_consConfIdx_no = 0;
		
		
		p_age_yes = g((Double)attributes[0],DataUtil.avg_age_yes,Math.sqrt(DataUtil.std_bias_age_yes));
		p_duration_yes = g((Double)attributes[0],DataUtil.avg_duration_yes,Math.sqrt(DataUtil.std_bias_duration_yes));
		p_pdays_yes = g((Double)attributes[0],DataUtil.avg_pdays_yes,Math.sqrt(DataUtil.std_bias_pdays_yes));
		p_campaign_yes = g((Double)attributes[0],DataUtil.avg_campaign_yes,Math.sqrt(DataUtil.std_bias_campaign_yes));
		p_empVarRate_yes = g((Double)attributes[0],DataUtil.avg_empVarRate_yes,Math.sqrt(DataUtil.std_bias_empVarRate_yes));
		p_consPriceIdx_yes = g((Double)attributes[0],DataUtil.avg_consPriceIdx_yes,Math.sqrt(DataUtil.std_bias_consPriceIdx_yes));
		p_consConfIdx_yes = g((Double)attributes[0],DataUtil.avg_consConfIdx_yes,Math.sqrt(DataUtil.std_bias_consConfIdx_yes));
		
		p_age_no = g((Double)attributes[0],DataUtil.avg_age_no,Math.sqrt(DataUtil.std_bias_age_no));
		p_duration_no = g((Double)attributes[0],DataUtil.avg_duration_no,Math.sqrt(DataUtil.std_bias_duration_no));
		p_pdays_no = g((Double)attributes[0],DataUtil.avg_pdays_no,Math.sqrt(DataUtil.std_bias_pdays_no));
		p_campaign_no = g((Double)attributes[0],DataUtil.avg_campaign_no,Math.sqrt(DataUtil.std_bias_campaign_no));
		p_empVarRate_no = g((Double)attributes[0],DataUtil.avg_empVarRate_no,Math.sqrt(DataUtil.std_bias_empVarRate_no));
		p_consPriceIdx_no = g((Double)attributes[0],DataUtil.avg_consPriceIdx_no,Math.sqrt(DataUtil.std_bias_consPriceIdx_no));
		p_consConfIdx_no = g((Double)attributes[0],DataUtil.avg_consConfIdx_no,Math.sqrt(DataUtil.std_bias_consConfIdx_no));
		
		double p_putcome_yes = 0, p_marital_yes = 0, p_contact_yes = 0;
		double p_putcome_no = 0, p_marital_no = 0, p_contact_no = 0;
		double number_poutcome_yes = 0, number_marital_yes = 0, number_contact_yes = 0;
		double number_poutcome_no = 0, number_marital_no = 0, number_contact_no = 0;
		double numberOfYes = 0, numberOfNo = 0;
		for(int i = 0 ; i < 41188 ; i ++){
			
			if(((String)values[i][20]).equals("yes")){
				
				if(((String)values[i][2]).equals(((String)attributes[2])))
					number_marital_yes++;
				if(((String)values[i][7]).equals(((String)attributes[7])))
					number_contact_yes++;
				if(((String)values[i][14]).equals(((String)attributes[14])))
					number_poutcome_yes++;
				
				numberOfYes++;
				
			}else if(((String)values[i][20]).equals("no")){
				
				if(((String)values[i][2]).equals(((String)attributes[2])))
					number_marital_no++;
				if(((String)values[i][7]).equals(((String)attributes[7])))
					number_contact_no++;
				if(((String)values[i][14]).equals(((String)attributes[14])))
					number_poutcome_no++;
				
				numberOfNo++;
				
			}
			
		}
		
		if(0 == number_marital_yes){
			
			number_marital_yes ++;
			numberOfYes++;
		}
		if(0 == number_contact_yes){
			
			number_contact_yes++;
			numberOfYes++;
		}
		if(0 == number_poutcome_yes){
			
			number_poutcome_yes++;
			numberOfYes++;
		}
		
		if(0 == number_marital_no){
			
			number_marital_no ++;
			numberOfNo++;
		}
		if(0 == number_contact_no){
			
			number_contact_no++;
			numberOfNo++;
		}
		if(0 == number_poutcome_no){
			
			number_poutcome_no++;
			numberOfNo++;
		}
		
		p_putcome_yes = number_poutcome_yes/numberOfYes;
		p_contact_yes = number_contact_yes/numberOfYes;
		p_marital_yes = number_marital_yes/numberOfYes;
		
		p_putcome_no = number_poutcome_no/numberOfNo;
		p_contact_no = number_contact_no/numberOfNo;
		p_marital_no = number_marital_no/numberOfNo;
		
		double p_x_yes = p_age_yes*p_campaign_yes*p_consConfIdx_yes*p_consPriceIdx_yes*p_contact_yes*p_duration_yes*p_empVarRate_yes*p_marital_yes*p_pdays_yes*p_putcome_yes;
		double p_x_no = p_age_no*p_campaign_no*p_consConfIdx_no*p_consPriceIdx_no*p_contact_no*p_duration_no*p_empVarRate_no*p_marital_no*p_pdays_no*p_putcome_no;
		
		label = p_x_yes > p_x_no ? "yes" : "no";
		return label;
	}
	
	
	public static double g(double x, double u, double xita){
		
		double p = 0;
		double step_1 = Math.sqrt(2*Math.PI)*xita;
		double step_2 = -Math.pow((x-u), 2)/(2*Math.pow(xita, 2));
		double step_3 = Math.pow(Math.E, step_2);
		double step_4 = step_3/step_1;
		p = step_4;
		
		return p;
	}

}
