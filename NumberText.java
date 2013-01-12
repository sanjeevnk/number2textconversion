package numbertextalgo;

import utils.NumberTextUtils;

/**
 * This class represents a given number in British English phrase Eg: 1234 in
 * British English phrase: One Thousand Two Hundred and Thirty Four
 * @version 04/14/2012
 * @author sanjeev
 * @version 1.0
 */

public class NumberText {

  public NumberText() {

	}

	public static String numberToString(int number) {
		if (number == 0) {
			return NumberTextUtils.ZERO_TEXT;
		} else if (number < 0) {
			return NumberTextUtils.NEGATIVE_TEXT + numberToString(-1 * number);
		}

		int count = 0;
		String str = "";

		while (number > 0) {
			if (number % NumberTextUtils.THOUSAND != 0) {
				str = numberToString100(number % NumberTextUtils.THOUSAND)
						+ NumberTextUtils.bigs[count] + " " + str;
				number /= NumberTextUtils.THOUSAND;
				count++;
			}
		}

		return str;
	}

	private static String numberToString100(int number) {
		String str = "";

		/** Convert hundredth place */
		if (number >= NumberTextUtils.HUNDRED) {
			str += NumberTextUtils.digits[number / NumberTextUtils.HUNDRED - 1]
					+ " Hundred and ";
			number %= NumberTextUtils.HUNDRED;
		}

		/** Convert NumberTextUtils.tens place */
		if (number >= NumberTextUtils.ELEVEN
				&& number <= NumberTextUtils.NINETEEN) {
			return str + NumberTextUtils.teens[number - NumberTextUtils.ELEVEN]
					+ " ";
		} else if (number == NumberTextUtils.TEN
				|| number >= NumberTextUtils.TWENTY) {
			str += NumberTextUtils.tens[number / NumberTextUtils.TEN - 1] + " ";
			number %= NumberTextUtils.TEN;
		}

		/** Convert ones place */
		if (number >= NumberTextUtils.ONE && number <= NumberTextUtils.NINE) {
			str += NumberTextUtils.digits[number - 1] + " ";
		}

		return str;
	}

}
