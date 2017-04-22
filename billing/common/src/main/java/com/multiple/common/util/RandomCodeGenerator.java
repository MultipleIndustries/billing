package com.multiple.common.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomCodeGenerator {

	private static char[] characterSet = "0123456789".toCharArray();
	
	public static String randomString(int length) {
	    Random random = new SecureRandom();
	    char[] result = new char[length];
	    for (int i = 0; i < result.length; i++) {
	        int randomCharIndex = random.nextInt(characterSet.length);
	        result[i] = characterSet[randomCharIndex];
	    }
	    return new String(result);
	}
}
