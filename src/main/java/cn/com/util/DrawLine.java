package cn.com.util;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.com.model.Record;

public class DrawLine extends JPanel {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("cons.conf.idx");
		frame.getContentPane().add(new DrawLine());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 800);
		frame.setVisible(true);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		List<Record> list = TextUtil.getAllInformation("bank-additional-full.csv");
		/*
		int[] age = new int[100];
		for(Record record : list){
			
			age[record.getAge()] ++;
		}
		for(int i = 0 ; i < 100 ; i ++){
			age[i]/=4;
		}
		int preX = 0, preY = 0;
		for(int i = 0 ; i < 100 ; i ++){
			g.drawLine(preX, 500-preY, i, 500-age[i]);
			preX = i;preY = age[i];
		}
		*/
		/* duration
		int[] age = new int[5000];
		for(Record record : list){
			
			age[(int) record.getDuration()] ++;
		}
		for(int i = 0 ; i < 5000 ; i ++){
			age[i]/=4;
		}
		int preX = 0, preY = 0;
		for(int i = 0 ; i < 5000 ; i ++){
			g.drawLine(preX, 50-preY, i, 50-age[i]);
			preX = i;preY = age[i];
		}
		*/
		/*cons.price.idx
		int[] age = new int[250];
		for(Record record : list){
			
			age[(int) record.getConsPriceIdx()] ++;
		}
		for(int i = 0 ; i < 250 ; i ++){
			age[i]/=4;
		}
		int preX = 0, preY = 0;
		for(int i = 0 ; i < 250 ; i ++){
			g.drawLine(preX, preY, i, age[i]);
			preX = i;preY = age[i];
		}
		*/
		/*emp var rate
		Map<Double,Integer> maps = new HashMap<Double, Integer>();
		for(Record record : list){
			
			Integer value = maps.get(record.getEmpVarRate());
			if(value == null){
				maps.put(record.getEmpVarRate(), 1);
			}else{
				value = value +1 ;
				maps.put(record.getEmpVarRate(),value);
			}
			Set set=maps.entrySet();
	        Iterator it=set.iterator();
	        while(it.hasNext()){
	            Map.Entry me=(Map.Entry)it.next();
	            g.drawLine(((Double)me.getKey()).intValue()*10 +50, 800,((Double)me.getKey()).intValue()*10+50, 800-(Integer) me.getValue()/25);  
	        }
			
		}
		*/
		/*cons.price.idx
		Map<Double,Integer> maps = new HashMap<Double, Integer>();
		for(Record record : list){
			
			Integer value = maps.get(record.getConsPriceIdx());
			if(value == null){
				maps.put(record.getConsPriceIdx(), 1);
			}else{
				value = value +1 ;
				maps.put(record.getConsPriceIdx(),value);
			}
			Set set=maps.entrySet();
	        Iterator it=set.iterator();
	        while(it.hasNext()){
	            Map.Entry me=(Map.Entry)it.next();
	            //g.drawLine(((Double)me.getKey()).intValue(), 0,((Double)me.getKey()).intValue(), (Integer) me.getValue());
	            g.drawLine(((Double)me.getKey()).intValue()*10-800, 800,((Double)me.getKey()).intValue()*10-800, 800-(Integer) me.getValue()/10);
	            //g.drawLine(((Double)me.getKey()).intValue()*10 +50, 800,((Double)me.getKey()).intValue()*10+50, 800-(Integer) me.getValue()/25);  
	        }
		}
		
		System.out.println(maps);
		*/
		/*campaign
		int[] age = new int[100];
		for(Record record : list){
			
			age[(int) record.getCampaign()] ++;
		}
		for(int i = 0 ; i < 100 ; i ++){
			age[i]/=20;
		}
		int preX = 0, preY = 0;
		for(int i = 0 ; i < 100 ; i ++){
			g.drawLine(preX*10 + 10, 800 -preY, i*10 + 10, 800 - age[i]);
			preX = i;preY = age[i];
		}*/
		
		Map<Double,Integer> maps = new HashMap<Double, Integer>();
		for(Record record : list){
			
			Integer value = maps.get(record.getConsConfIdx());
			if(value == null){
				maps.put(record.getConsConfIdx(), 1);
			}else{
				value = value +1 ;
				maps.put(record.getConsConfIdx(),value);
			}
			Set set=maps.entrySet();
	        Iterator it=set.iterator();
	        while(it.hasNext()){
	            Map.Entry me=(Map.Entry)it.next();
	            //g.drawLine(((Double)me.getKey()).intValue(), 0,((Double)me.getKey()).intValue(), (Integer) me.getValue());
	            g.drawLine(((Double)me.getKey()).intValue()*2+200, 800,((Double)me.getKey()).intValue()*2+200, 800- (Integer) me.getValue()/10);
	            //g.drawLine(((Double)me.getKey()).intValue()*10 +50, 800,((Double)me.getKey()).intValue()*10+50, 800-(Integer) me.getValue()/25);  
	        }
		}
	}
}