package cn.com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cn.com.model.Record;
import cn.com.service.NaiveBayesian;
import cn.com.util.TextUtil;

public class KFoldCrossValidation {

	
	public static void main(String args[]){
		
	
		
		int step = 4118;
		double erroRate = 0;
		//提取所有的数据
		List<Record> allRecord = TextUtil.getAllInformation("bank-additional-full.csv");
		//k次迭代进行交叉检测
		for(int i = 0 ; i < 10 ; i ++){
			
			System.out.println("iterator time is :" + (i+1));
			
			//获取测试集合
			List<Record> testList = new ArrayList<Record>(allRecord);
			//获取训练集合
			List<Record> trainList = new ArrayList<Record>();
			Collections.copy(testList, allRecord);
			for(int j = 0 ; j < step; j ++){
				
				Random random = new Random();
		        int s = random.nextInt(testList.size())%(testList.size()-0+1) + 0;
		        
		        trainList.add(testList.get(s));
		        testList.remove(s);
			}
			//调用贝叶斯方法
			erroRate += NaiveBayesian.NaiveBayesianPredicte(trainList, testList);
			
		}
		erroRate /=10;
		System.out.println("total errorRate is : " + erroRate*100 + "%");
		
		
		
	}
}
