package com.xiezhyan.ceshi;

import org.junit.Test;

public class Ceshi {

	@Test
	public void ceshi1() {
		String a = "1234678901246541234567912939810293";
		int index = 0;
		for(int i = 0; i < a.length(); i++) {
			index = i + 1;
			
			if(index >= a.length())
				index = a.length() - 1;
			
			int ait1 = Integer.parseInt(a.charAt(i) + "");
			int ait2 = Integer.parseInt(a.charAt(index) + "");
			
			if(ait2 - 1 == ait1) {
				System.out.print((ait1) + "	");
			} else {
				System.out.print(ait1);
				System.out.println();
			}
		}
	}
}
