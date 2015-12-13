package cn.com.util;

import java.util.List;

import Jama.Matrix;
import cn.com.model.TransforRecord;

public class CalculateLDA {

	public static int[] getAttribute(List<TransforRecord> listRecords){
		
		double []u1 = new double[20];
		double []u2 = new double[20];
		
		int yesLabel = 0, noLabel = 0;
		for(TransforRecord transforRecord : listRecords){
			
			if(transforRecord.getLabel().equals("yes")){
				
				u1[0] += transforRecord.getAge();
				u1[1] += transforRecord.getJob();
				u1[2] += transforRecord.getMarital();
				u1[3] += transforRecord.getEducation();
				u1[4] += transforRecord.getDefaultCredit();
				u1[5] += transforRecord.getHousing();
				u1[6] += transforRecord.getLoan();
				u1[7] += transforRecord.getContact();
				u1[8] += transforRecord.getMonth();
				u1[9] += transforRecord.getDayOfWeek();
				u1[10] += transforRecord.getDuration();
				u1[11] += transforRecord.getCampaign();
				u1[12] += transforRecord.getPdays();
				u1[13] += transforRecord.getPrevious();
				u1[14] += transforRecord.getPoutcome();
				u1[15] += transforRecord.getEmpVarRate();
				u1[16] += transforRecord.getConsPriceIdx();
				u1[17] += transforRecord.getConsConfIdx();
				u1[18] += transforRecord.getEuribor3m();
				u1[19] += transforRecord.getNrEmployed();
				yesLabel ++;
 			}else if(transforRecord.getLabel().equals("no")){
				
				u2[0] += transforRecord.getAge();
				u2[1] += transforRecord.getJob();
				u2[2] += transforRecord.getMarital();
				u2[3] += transforRecord.getEducation();
				u2[4] += transforRecord.getDefaultCredit();
				u2[5] += transforRecord.getHousing();
				u2[6] += transforRecord.getLoan();
				u2[7] += transforRecord.getContact();
				u2[8] += transforRecord.getMonth();
				u2[9] += transforRecord.getDayOfWeek();
				u2[10] += transforRecord.getDuration();
				u2[11] += transforRecord.getCampaign();
				u2[12] += transforRecord.getPdays();
				u2[13] += transforRecord.getPrevious();
				u2[14] += transforRecord.getPoutcome();
				u2[15] += transforRecord.getEmpVarRate();
				u2[16] += transforRecord.getConsPriceIdx();
				u2[17] += transforRecord.getConsConfIdx();
				u2[18] += transforRecord.getEuribor3m();
				u2[19] += transforRecord.getNrEmployed();
				noLabel ++;
 			}
		}
		
		for(int i = 0 ; i < 20; i ++){
			
			u1[i] /= yesLabel;
			u2[i] /= noLabel;
		}
		
		Matrix m_s1 = new Matrix(20, 20);
		Matrix m_s2 = new Matrix(20, 20);
		
		for(TransforRecord transforRecord : listRecords){
			
			double[] bias1 = new double[20];
			double[] bias2 = new double[20];
			
			if(transforRecord.getLabel().equals("yes")){
				
				bias1[0] = transforRecord.getAge()-u1[0];
				bias1[1] = transforRecord.getJob()-u1[1];
				bias1[2] = transforRecord.getMarital()-u1[2];
				bias1[3] = transforRecord.getEducation()-u1[3];
				bias1[4] = transforRecord.getDefaultCredit()-u1[4];
				bias1[5] = transforRecord.getHousing()-u1[5];
				bias1[6] = transforRecord.getLoan()-u1[6];
				bias1[7] = transforRecord.getContact()-u1[7];
				bias1[8] = transforRecord.getMonth()-u1[8];
				bias1[9] = transforRecord.getDayOfWeek()-u1[9];
				bias1[10] = transforRecord.getDuration()-u1[10];
				bias1[11] = transforRecord.getCampaign()-u1[11];
				bias1[12] = transforRecord.getPdays()-u1[12];
				bias1[13] = transforRecord.getPrevious()-u1[13];
				bias1[14] = transforRecord.getPoutcome()-u1[14];
				bias1[15] = transforRecord.getEmpVarRate()-u1[15];
				bias1[16] = transforRecord.getConsPriceIdx()-u1[16];
				bias1[17] = transforRecord.getConsConfIdx()-u1[17];
				bias1[18] = transforRecord.getEuribor3m()-u1[18];
				bias1[19] = transforRecord.getNrEmployed()-u1[19];
				Matrix m_bias1 = new Matrix(bias1,20);
				m_s1.plusEquals(m_bias1.times(m_bias1.transpose()));
				
			}else if(transforRecord.getLabel().equals("no")){
				
				bias2[0] = transforRecord.getAge()-u2[0];
				bias2[1] = transforRecord.getJob()-u2[1];
				bias2[2] = transforRecord.getMarital()-u2[2];
				bias2[3] = transforRecord.getEducation()-u2[3];
				bias2[4] = transforRecord.getDefaultCredit()-u2[4];
				bias2[5] = transforRecord.getHousing()-u2[5];
				bias2[6] = transforRecord.getLoan()-u2[6];
				bias2[7] = transforRecord.getContact()-u2[7];
				bias2[8] = transforRecord.getMonth()-u2[8];
				bias2[9] = transforRecord.getDayOfWeek()-u2[9];
				bias2[10] = transforRecord.getDuration()-u2[10];
				bias2[11] = transforRecord.getCampaign()-u2[11];
				bias2[12] = transforRecord.getPdays()-u2[12];
				bias2[13] = transforRecord.getPrevious()-u2[13];
				bias2[14] = transforRecord.getPoutcome()-u2[14];
				bias2[15] = transforRecord.getEmpVarRate()-u2[15];
				bias2[16] = transforRecord.getConsPriceIdx()-u2[16];
				bias2[17] = transforRecord.getConsConfIdx()-u2[17];
				bias2[18] = transforRecord.getEuribor3m()-u2[18];
				bias2[19] = transforRecord.getNrEmployed()-u2[19];
				Matrix m_bias2 = new Matrix(bias2,20);

				m_s2.plusEquals(m_bias2.times(m_bias2.transpose()));
			}
		}
		Matrix m_u1 = new Matrix(u1,20);
		Matrix m_u2 = new Matrix(u2,20);
		
		System.out.println("u1 is " + m_u1.getRowDimension() + " x " + m_u1.getColumnDimension());
		System.out.println("u2 is " + m_u2.getRowDimension() + " x " + m_u2.getColumnDimension());
		System.out.println("s1 is " + m_s1.getRowDimension() + " x " + m_s1.getColumnDimension());
		System.out.println("s1 is " + m_s2.getRowDimension() + " x " + m_s2.getColumnDimension());
		
		Matrix m_w = m_s1.plusEquals(m_s2).inverse().times(m_u1.minusEquals(m_u2));
		System.out.println("w is " + m_w.getRowDimension() + " x " + m_w.getColumnDimension());
		
		double[][] w = m_w.getArray();
		int[] indexs = new int[10];
		for(int i = 0; i< 20 ; i ++)
			w[i][0] = Math.abs(w[i][0]);
		int maxIndex = 0;
		for(int i = 0; i< 10 ; i ++){
			
			for(int j = 0 ; j < 20 ; j++)
				if(w[j][0] > w[maxIndex][0])
					maxIndex = j;
				
			indexs[i] = maxIndex;
			w[maxIndex][0] = 0;
		}
		
		return indexs;
	}
}
