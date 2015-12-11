package cn.com.model;

import java.util.ArrayList;

public class TreeNode {
	private String name; //节点名
	private String rule; //结点的分类规则
	ArrayList<TreeNode> child;  //子节点集合
	private ArrayList<Record> datas; //划分到该节点的训练元组
	private ArrayList<String> candiAttr; //划分到该结点的候选属性
	
	public TreeNode() {
		this.name = "";
		this.rule = null;
		this.child = new ArrayList<TreeNode>();
		this.datas = null;
		this.candiAttr = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public ArrayList<TreeNode> getChild() {
		return child;
	}

	public void setChild(ArrayList<TreeNode> child) {
		this.child = child;
	}

	public ArrayList<Record> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<Record> datas) {
		this.datas = datas;
	}

	public ArrayList<String> getCandiAttr() {
		return candiAttr;
	}

	public void setCandiAttr(ArrayList<String> candiAttr) {
		this.candiAttr = candiAttr;
	}

	

}
