package cn.com.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.model.Record;
import cn.com.model.TreeNode;
import cn.com.util.Preprocess;
import cn.com.util.TextUtil;

public class TestRecordByDT {
	
	public static void main(String[] args) {
		ArrayList<Record> datas = (ArrayList<Record>) TextUtil.getAllInformation("bank-additional-full.csv");
		Preprocess preprocess = new Preprocess();
		preprocess.hierarchy(datas);
		ArrayList<String> attrList = preprocess.attrChoice(datas);
		DecisionTree dt = new DecisionTree();
		TreeNode root = new TreeNode();
		root = dt.buildTree(datas, attrList);
		PrintDecisionTree pdt = new PrintDecisionTree();
		pdt.printTree(root, 0);
		ArrayList<Record> testDatas = (ArrayList<Record>) TextUtil.getAllInformation("testdata.csv");
		preprocess.hierarchy(testDatas);
		for(int i=0; i<testDatas.size(); i++) {
			Record record = testDatas.get(i);
			int correctCount = 0;
			String label = dt.testRecord(record, root);
			System.out.println("第" + i + "个测试数据： age = " + record.getAge() + "    label = " + label);
			if((record.getLabel()).equals(label)) {
				correctCount++;
			}
			double correctRate = 0.0;
			if(correctCount != 0) {
				correctRate = correctCount / testDatas.size();
			}
		}
	}
	

}
