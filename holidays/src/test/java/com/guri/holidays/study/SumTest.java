package com.guri.holidays.study;

import org.omg.CORBA.Environment;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumTest {

	App obj;

	@BeforeClass
	public void setup() {
		obj = new App();

	}

	@Parameters({ "first" })
	@Test
	public void testCase1(@Optional("Default Value if not found in testng.xml") String param1) {
		Assert.assertEquals(obj.sum(2, 3), 5, param1);
		System.out.println(param1);
		System.out.println("Printing it"+System.getProperty("URL"));
		System.out.println("Printing itt"+System.getProperty("URL1"));


	}

	@Test(priority = 1, dependsOnMethods = {}, enabled = true, alwaysRun = true, timeOut = 30000, groups = {
			"Regression" })
	public void testCase2() {
		Assert.assertEquals(App.sum(4, 3), 7);

	}

	@Test(dataProvider = "dataProvider")
	public void testCase3(int one, int two, int three) {
		System.out.println(one + two + three);

	}

	@DataProvider(name = "dataProvider")
	public Object[][] datapProvider() {
		Object[][] data = new Object[2][3];
		data[0][0] = 1;
		data[0][1] = 2;
		data[0][2] = 3;
		data[1][0] = 4;
		data[1][1] = 5;
		data[1][2] = 6;

		return data;

	}

}