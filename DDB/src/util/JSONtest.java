package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JSONtest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(sdf.parse("2013-03-04"));
	}

}
