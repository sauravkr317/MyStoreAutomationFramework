package com.mystore.qa.util;

import java.util.Random;

import com.mystore.qa.base.TestBase;

public class RandomNo extends TestBase{

	static int num;
	
	public static int generateRandomNo() {
		Random random = new Random();
        int num = 100 + random.nextInt(900);
        return num;
	}
}
