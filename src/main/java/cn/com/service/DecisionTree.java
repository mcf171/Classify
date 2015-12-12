package cn.com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.com.model.Record;
import cn.com.model.TreeNode;

public class DecisionTree {
	
	public String testRecord(Record record, TreeNode node) {
		String label = "";
		String name = node.getName();
		if(name == "yes" || name == "no") {
			label = name;
		}else{
			ArrayList<TreeNode> childList = node.getChild();
			for(int i=0; i<childList.size(); i++) {
				if((record.getAttrVaule(name)).equals(childList.get(i).getRule())){
					label = testRecord(record, childList.get(i));
				}
			}
		}
		return label;
	}

	/**
	 * 计算给定数据集按类标号属性分类结果
	 * @param datas
	 * @param attrName
	 * @return 含有分类属性和相应数据数量的Map
	 */
	public Map<String, Integer> valueCounts(ArrayList<Record> datas,String attrName){
		Map<String, Integer> valueCount = new HashMap<String, Integer>();
		String c = "";
		Record record = null;
		for(int i=0; i<datas.size(); i++) {
			record = datas.get(i);
			c = record.getAttrVaule(attrName);
			if(valueCount.containsKey(c)) {
				valueCount.put(c, valueCount.get(c)+1);
			}else{
				valueCount.put(c, 1);
			}
		}
		return valueCount;
	}
	
	/**
	 * 获取指定数据集类标号属性列的域值及其计数
	 * @param datas
	 * @return
	 */
	public Map<String, Integer> valueCountsByLabel(ArrayList<Record> datas) {
		Map<String, Integer> valueCount = new HashMap<String, Integer>();
		valueCount = valueCounts(datas,"label");
		return valueCount;
	}

	/**
	 * 根据数据集和属性列表构造判定树
	 * @param datas
	 * @param attrList
	 * @return 根节点
	 */
	public TreeNode buildTree(ArrayList<Record> datas, ArrayList<String> attrList) {
		TreeNode node = new TreeNode();
		node.setDatas(datas);
		node.setCandiAttr(attrList);
		Map<String, Integer> classes = valueCountsByLabel(datas);
		//所有数据集都属于一类
		if(classes.size()<2){
			Iterator iter = classes.entrySet().iterator();  
            Map.Entry entry = (Map.Entry) iter.next();  
            String name = entry.getKey().toString();  
            node.setName(name);  
            return node; 
		}
		//属性为空的情况
		if(attrList.size() == 0) {
			if(classes.get("yes") > classes.get("no")) {
				node.setName("yes");
			}else{
				node.setName("no");
			}
			return node;
		}
		Gain gain = new Gain(datas, attrList); 
		String bestAttrIndex = gain.bestGainAttr();  //获取具有最高信息增益的属性
		ArrayList<String> rules = gain.getValuesOfAttr(datas, bestAttrIndex);  //获取具有最高信息增益的属性的值域
		node.setName(bestAttrIndex);
		if(rules.size() > 2) {
			attrList.remove(bestAttrIndex);
		}
		 
		for(int i=0; i<rules.size(); i++) {
			String rule = rules.get(i);
			ArrayList<Record> datai = gain.getDatasOfValue(bestAttrIndex, rule);
			//在这个新分之下没有对应的数据集，则将label设为datas中最普遍的label值
			if(datai.size() == 0) {
				TreeNode leafNode = new TreeNode();
				if(classes.get("yes") > classes.get("no")) {
					leafNode.setName("yes");
				}else{
					leafNode.setName("no");
				}
			}else{
				TreeNode childNode = buildTree(datai, attrList);
				childNode.setRule(rule);
				node.getChild().add(childNode);
			}
		}
		return node;
	}
}
