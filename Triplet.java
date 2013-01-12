package numbertextoop;

import utils.NumberTextUtils;

/**
 * This class represents a group of digits up to a maximum of 3 that form a
 * given number. 04/14/12 @author sanjeev 04/19/12 @author sanjeev
 * 
 * @version 1.1
 */
public class Triplet {

  private int hundredthPlace;
	private int tenthPlace;
	private int unitPlace;
	private int value;

	public Triplet(int tripletGroupNum) {
		this.value = tripletGroupNum;
	}

	/**
	 * Arranges the place of digits for hundredth, tenth and unit positions in
	 * this triplet
	 * 
	 * @param tripletValue
	 * @return Triplet
	 */
	public Triplet matchTripletPlaces(int tripletValue) {
		this.setHundredthPlace(tripletValue / NumberTextUtils.HUNDRED);

		tripletValue = tripletValue % NumberTextUtils.HUNDRED;
		this.setTenthPlace(tripletValue / NumberTextUtils.TEN);

		tripletValue = tripletValue % NumberTextUtils.TEN;
		this.setUnitPlace(tripletValue);

		return this;
	}

	/**
	 * Returns the string representation of this triplet
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return constructTripletText().toString();
	}

	/**
	 * @return tripletText StringBuilder
	 */
	private StringBuilder constructTripletText() {

		StringBuilder tripletText = new StringBuilder();

		tripletText = appendHundredthPlaceText(tripletText);

		/** 'Teen' candidate check: 13 -> Thirteen, 11 -> Eleven */
		StringBuilder teenCandidateBuilder = new StringBuilder();
		String teenCandidate = teenCandidateBuilder.append(
				String.valueOf(this.tenthPlace)).append(
				String.valueOf(this.unitPlace)).toString();
		int teenCandidateValue = Integer.parseInt(teenCandidate);

		tripletText = appendTenthPlaceText(tripletText, teenCandidateValue);

		tripletText = appendUnitPlaceText(tripletText, teenCandidateValue);

		return tripletText;
	}

	/**
	 * Unit place text candidates Unit place : Five, Zero, Two etc
	 */
	private StringBuilder appendUnitPlaceText(StringBuilder tripletText,
			int teenCandidate) {
		/** Print unit place text: 1 -> one, 9 -> nine etc */
		if (this.unitPlace != 0) {
			if (isATeenNumber(teenCandidate)) {
				return tripletText;
			}

			tripletText = appendDigitText(tripletText, this.unitPlace);
		}

		return tripletText;
	}

	/**
	 * Tenth place and 'Teen' text candidates Tenth place : Five, Eleven,
	 * Thirteen etc.
	 */
	private StringBuilder appendTenthPlaceText(StringBuilder tripletText,
			int teenCandidate) {
		if (this.tenthPlace != 0) {
			if (isATeenNumber(teenCandidate)) {
				tripletText = tripletText
						.append(NumberTextUtils.teens[this.unitPlace]);
			} else {
				tripletText = tripletText
						.append(NumberTextUtils.tens[this.tenthPlace - 1]);
			}
			tripletText.append(" ");
		}

		return tripletText;
	}

	/**
	 * Hundredth place text candidates Hundredth place : Two Hundred, Two
	 * Hundred and etc.
	 */
	private StringBuilder appendHundredthPlaceText(StringBuilder tripletText) {
		if (this.hundredthPlace != 0) {
			if (this.tenthPlace == 0 && this.unitPlace == 0) {
				tripletText = appendDigitText(tripletText, this.hundredthPlace)
						.append(" Hundred ");
			} else {
				tripletText = appendDigitText(tripletText, this.hundredthPlace)
						.append(" Hundred and ");
			}
		}

		return tripletText;
	}

	/**
	 * @param tripletText
	 * @param digit
	 * @return
	 */
	public StringBuilder appendDigitText(StringBuilder tripletText, int digit) {
		tripletText.append(NumberTextUtils.digits[digit]);

		return tripletText;
	}

	/**
	 * @param teenCandidate
	 * @return true if the number belongs to [11, 12, 13, 14, 15, 16, 17, 18,
	 *         19]
	 */
	public boolean isATeenNumber(int teenCandidate) {
		return (teenCandidate >= NumberTextUtils.ELEVEN && teenCandidate < NumberTextUtils.TWENTY);
	}

	public int getValue() {
		return value;
	}

	public int getHundredthPlace() {
		return hundredthPlace;
	}

	public void setHundredthPlace(int hundredthPlace) {
		this.hundredthPlace = hundredthPlace;
	}

	public int getTenthPlace() {
		return tenthPlace;
	}

	public void setTenthPlace(int tenthPlace) {
		this.tenthPlace = tenthPlace;
	}

	public int getUnitPlace() {
		return unitPlace;
	}

	public void setUnitPlace(int unitPlace) {
		this.unitPlace = unitPlace;
	}

}
