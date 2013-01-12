package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used as a utility class for representing a number in text
 * 04/14/12 @author sanjeev 04/19/12 @author sanjeev
 * 
 * @version 1.1
 */
public class NumberTextUtils {

  public static String[] digits = new String[] { "Zero", "One", "Two",
			"Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	public static String[] teens = new String[] { "", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	public static String[] tens = new String[] { "Ten", "Twenty", "Thirty",
			"Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	public static String[] bigs = new String[] { "", "Thousand", "Million",
			"Billion" };

	public static final String NEGATIVE_TEXT = "Negative";
	public static final String ZERO_TEXT = "Zero";

	public static final int ONE = 1;
	public static final int THREE = 3;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int TWENTY = 20;
	public static final int ELEVEN = 11;
	public static final int NINETEEN = 19;
	public static final int HUNDRED = 100;
	public static final int THOUSAND = 1000;

	public static Map<Integer, String> tripletGroupMap = new HashMap<Integer, String>();

	static {
		tripletGroupMap.put(1, "");
		tripletGroupMap.put(2, "Thousand");
		tripletGroupMap.put(3, "Million");
		tripletGroupMap.put(4, "Billion");
	}

	public static Map<Integer, String> tripletMap() {
		return tripletGroupMap;
	}

}
