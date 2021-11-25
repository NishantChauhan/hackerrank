package hackerrank.warmup;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StaticInitializer {

	static int B;
	static int H;
	static boolean flag = populateInput();

	private static boolean populateInput() {
		if(B < 0 || H < 0){
			System.out.println("java.lang.Exception: Breadth and height must be positive");
			return false;
		}
		return true;
	}



	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}// end of main

}// end of class
