package cn.com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cn.com.model.Record;
import cn.com.model.TreeNode;
import cn.com.service.DecisionTree;
import cn.com.service.NaiveBayesian;
import cn.com.util.Preprocess;
import cn.com.util.TextUtil;

public class KFoldCrossValidation {

	
	public static void main(String args[]){
		
	
		
		int step = 4118;
		double erroRate = 0;
		double errorRateDT = 0.0;
		ArrayList<Record> allRecord = (ArrayList<Record>) TextUtil.getAllInformation("bank-additional-full.csv");
		for(int i = 0 ; i < 10 ; i ++){
			
			System.out.println("iterator time is :" + (i+1));
			
			
			List<Record> testList = new ArrayList<Record>(allRecord);
			List<Record> trainList = new ArrayList<Record>();
			Collections.copy(testList, allRecord);
			for(int j = 0 ; j < step; j ++){
				
				Random random = new Random();
		        int s = random.nextInt(testList.size())%(testList.size()-0+1) + 0;
		        
		        trainList.add(testList.get(s));
		        testList.remove(s);
			}
			
			
			erroRate += NaiveBayesian.NaiveBayesianPredicte(trainList, testList);
			
			errorRateDT += DecisionTree.DecisionTreePredicte((ArrayList)trainList, (ArrayList)testList);
			
		}
		erroRate /=10;
		errorRateDT /=10;
		System.out.println("total errorRate is : " + erroRate*100 + "%");
		System.out.println("total errorRate by DecisioinTree is : " + errorRateDT*100 + "%");

		
		
	}
}
