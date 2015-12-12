package cn.com.service;

import cn.com.util.CalculateLDA;
import junit.framework.TestCase;

public class NaiveBayesianTest extends TestCase {

	public void testCalculateTheLabel() {
		Object[] attributes = new Object[22];
		
		attributes[0] = 56.0;
		attributes[1] = "housemaid";
		attributes[2] = "married";
		attributes[3] = "basic.4y";
		attributes[4] = "no";
		attributes[5] = "no";
		attributes[6] = "no";
		attributes[7] = "telephone";
		attributes[8] = "may";
		attributes[9] = "mon";
		attributes[10] = 261;
		attributes[11] = 1;
		attributes[12] = 999;
		attributes[13] = 0;
		attributes[14] = "nonexistent";
		attributes[15] = 1.1;
		attributes[16] = 93.994;
		attributes[17] = -36.4;
		attributes[18] = 4.857;
		attributes[19] = 5191;
		attributes[20] = "no";
		attributes[21] = false;
		String label = NaiveBayesian.calculateTheLabel(attributes);
		System.out.println(label);
		this.assertEquals(label, "no");
		
		attributes[0] = 49.0;
		attributes[1] = "entrepreneur";
		attributes[2] = "married";
		attributes[3] = "university.degree";
		attributes[4] = "unknown";
		attributes[5] = "yes";
		attributes[6] = "no";
		attributes[7] = "telephone";
		attributes[8] = "may";
		attributes[9] = "mon";
		attributes[10] = 1042;
		attributes[11] = 1;
		attributes[12] = 999;
		attributes[13] = 0;
		attributes[14] = "nonexistent";
		attributes[15] = 1.1;
		attributes[16] = 93.994;
		attributes[17] = -36.4;
		attributes[18] = 4.857;
		attributes[19] = 5191;
		attributes[20] = "yes";
		attributes[21] = true;
		
		label = NaiveBayesian.calculateTheLabel(attributes);
		System.out.println(label);
		this.assertEquals(label, "yes");
		
	}

}
