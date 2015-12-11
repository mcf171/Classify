package cn.com.util;

import java.util.List;

import cn.com.model.Record;
import junit.framework.TestCase;

public class TextUtilTest extends TestCase {

	public void testGetAllInformation() {
		
		List<Record> lists = TextUtil.getAllInformation("bank-additional-full.csv");
		System.out.println(lists.size());
		this.assertNotNull(lists);
	}
}
