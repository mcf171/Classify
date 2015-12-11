package cn.com.service;

import java.util.ArrayList;

import cn.com.model.Record;
import cn.com.model.TreeNode;
import cn.com.util.TextUtil;
import cn.com.util.TextUtilTest;

public class PrintDecisionTree {

	public void printTree(TreeNode root, int level) {  
        System.out.println(root.getName());  

        ArrayList<TreeNode> children = root.getChild();  
        for (int i = 0; i < children.size(); i++) {  
            for (int j = 0; j <= level; j++)  
                System.out.print("     ");  
            System.out.print(children.get(i).getRule() + "--> ");  
            printTree(children.get(i), (level + 1));  
        }  
    }  
	
	   public static void main(String[] args) {  
		   PrintDecisionTree tdt = new PrintDecisionTree();  
	        ArrayList<String> attrs = new ArrayList(); // 存放候选属性  
	        ArrayList<Record> datas = new ArrayList<Record>();  	  
	        datas = (ArrayList<Record>) TextUtil.getAllInformation("bank-additional-full.csv");
			attrs.add("age");
			attrs.add("job");
			attrs.add("marital");
			attrs.add("education");
			attrs.add("defaultCredit");
			attrs.add("housing");
			attrs.add("loan");
			attrs.add("contact");
			attrs.add("month");
			attrs.add("dayOfWeek");
			attrs.add("duration");
			attrs.add("campaign");
			attrs.add("pdays");
			attrs.add("previous");
			attrs.add("poutcome");
			attrs.add("empVarRate");
			attrs.add("consPriceIdx");
			attrs.add("consConfIdx");
			attrs.add("euribor3m");
			attrs.add("nrEmployed");
			attrs.add("label");
			attrs.add("isDirty");
	        DecisionTree tree = new DecisionTree();  
	        TreeNode root = tree.buildTree(datas, attrs); 
	        tdt.printTree(root, 0);  
	    }  
}
