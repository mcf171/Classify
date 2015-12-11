package cn.com.util;

import java.util.List;

import cn.com.model.Record;
import cn.com.model.TransforRecord;
import junit.framework.TestCase;

public class DataUtilTest extends TestCase {

	public void testStandardization() {
		
		List<Record> lists = TextUtil.getAllInformation("bank-additional-full.csv");
		List<TransforRecord> lists2 = DataUtil.standardization(lists);
		System.out.println(lists2.size());
		this.assertNotNull(lists2);
	}

}
