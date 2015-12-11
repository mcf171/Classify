package cn.com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.lang.Math;

import cn.com.model.Record;



public class Gain {
	
	private ArrayList<Record> dataSet = null; //训练数据集
	private ArrayList<String> attrSet = null; //候选属性集
	
	public Gain(ArrayList<Record> datas, ArrayList<String> attrSet) {
		this.dataSet = datas;
		this.attrSet = attrSet;
	}
	
	/**
	 * 获取指定属性列的值域
	 * @param datas 数据集
	 * @param attrIndex 指定属性的下标
	 * @return
	 */
	public ArrayList<String> getValuesOfAttr(ArrayList<Record> datas,String attrName) {
		ArrayList<String> valuesOfAttr = new ArrayList<String>();
		String r = "";
		for(int i=0; i<datas.size(); i++) {
			r = datas.get(i).getAttrVaule(attrName);
			if(!valuesOfAttr.contains(r)){
				valuesOfAttr.add(r);
			}
		}
		return valuesOfAttr;
	}

	/**
	 * 获取指定数据集中指定属性列索引的域值及其计数
	 * @param datas 数据集
	 * @param attrIndex 指定的属性列索引
	 * @return 指定属性列的类别及相应计数的map
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
		valueCount = valueCounts(datas,"y");
		return valueCount;
	}
	
	/**
	 * 获取指定属性列上指定值域的所有元组
	 * @param datas 数据集
	 * @param attrIndex 指定属性列索引
	 * @param value 指定属性列的值域
	 * @return 指定属性列上指定值域的所有元组
	 */
	public ArrayList<Record> getDatasOfValue(String attrName, String value) {
		ArrayList<Record> datasOfValue = new ArrayList<Record>();
		Record t = new Record();
		for(int i =0; i<dataSet.size(); i++) {
			t = dataSet.get(i);
			if(t.getAttrVaule(attrName).equals(value)) {
				datasOfValue.add(t);
			}
		}
		return datasOfValue;
	}
	
	/**
	 * 获取样本分类所需的期望信息
	 * @param classes
	 * @param n
	 * @return
	 */
	public double getExpectionOfSamples(ArrayList<Record> datas) {
		double expectionOfSamples = 0.0;
		Map<String, Integer> classes = valueCountsByLabel(datas);
		Iterator iter = classes.entrySet().iterator();
		for(int i=0; iter.hasNext(); i++) {
			Map.Entry entry = (Map.Entry) iter.next();
			Integer val = (Integer) entry.getValue();
			double vn = (double)val/(double)datas.size();
			expectionOfSamples += -(vn)*(Math.log(vn)/Math.log(2));
		}
		return expectionOfSamples;
	}
	
	/**
	 * 获取按指定属性划分后给定的样本分类所需的期望信息
	 * @param attrIndex
	 * @return
	 */
	public double getExpectionByAttr(String attrName){
		double expectionByAttr = 0.0;
		ArrayList<String> valuesOfAttr = getValuesOfAttr(dataSet,attrName);
		double n1 = 0.0;
		for(int i=0; i<valuesOfAttr.size(); i++) {
			double e =0.0 , f =0.0;
			ArrayList<Record> datasOfValue = getDatasOfValue(attrName, valuesOfAttr.get(i));
			Map<String, Integer> classes = valueCountsByLabel(datasOfValue);
			n1 = (double)datasOfValue.size() / (double)dataSet.size();
			try{
				e = classes.get("no");
				f = classes.get("yes");
			}catch(Exception exce){
				
			}
			expectionByAttr += n1 * getException(e,f);
		}
		return expectionByAttr;
	}
	
	/**
	 * 计算指定属性的某个类的期望信息
	 * @param e
	 * @param f
	 * @return
	 */
	public double getException(double e, double f) {
		double exception = 0.0;
		if(e == 0 || f == 0) {
			return exception;
		}else if(e == f){
			exception = 1.0;
			return exception;
		}else{
			double sum = e+f;
			exception = -(e/sum)*(Math.log(e/sum)/Math.log(2)) - (f/sum)*(Math.log(f/sum)/Math.log(2));
		}
		return exception;
	}
	
	public String bestGainAttr() {
		double expectionOfSamples = getExpectionOfSamples(dataSet);
		String attrName=null;
		double gain = 0.0;
		double tempGain = 0.0;
		for(int i=0; i<attrSet.size(); i++) {
			tempGain = expectionOfSamples - getExpectionByAttr(attrSet.get(i));
			if(tempGain > gain) {
				gain = tempGain;
				attrName = attrSet.get(i);
			}
		}
		return attrName;
	}
}





























