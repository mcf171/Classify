package cn.com.util;

import java.util.List;

import cn.com.model.Record;
import cn.com.model.TransforRecord;
import junit.framework.TestCase;

public class CalculateLDATest extends TestCase {

	public void testGetTop10Attribute() {
		
		List<Record> lists = TextUtil.getAllInformation("bank-additional-full.csv");
		List<TransforRecord> transRecords = DataUtil.standardization(lists);
		double[] w = CalculateLDA.getAttribute(transRecords);
		for(double values : w) {
		System.out.println(values);
		}
	}

}
