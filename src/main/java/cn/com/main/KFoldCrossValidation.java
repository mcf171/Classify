package cn.com.main;

import java.util.ArrayList;
import java.util.List;

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
			List<Record> trainList = new ArrayList<Record>(allRecord.subList(i*step, i*step + step));
			List<Record> preTestList =  new ArrayList<Record>(allRecord.subList(0, i*step));
			List<Record> lastTestList =  new ArrayList<Record>(allRecord.subList(i*step + step, allRecord.size()));
			preTestList.addAll(lastTestList);
			List<Record> testList = preTestList;
			
			erroRate += NaiveBayesian.NaiveBayesianPredicte(trainList, testList);
			
//			errorRateDT += DecisionTree.DecisionTreePredicte((ArrayList)trainList, (ArrayList)testList);
			
		}
		erroRate /=10;
//		errorRateDT /=10;
		System.out.println("total errorRate is : " + erroRate);
//		System.out.println("total errorRate by DecisioinTree is : " + errorRateDT);
		
		
	}
}
