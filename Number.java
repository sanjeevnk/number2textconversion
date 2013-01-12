package numbertextoop;

import java.util.LinkedList;
import java.util.List;

import utils.NumberTextUtils;

/**
 * This class represents a given number. Can be used to display in British
 * English phrase the number Eg: 1234 in British English phrase: One Thousand
 * Two Hundred and Thirty Four This class can accommodate text representation
 * types like British, Indian etc with the constructor provided 04/14/2012 @author
 * sanjeev 04/19/2012 @author sanjeev
 * 
 * @version 1.1
 */

public class Number {

  private int num;
	private List<Triplet> triplets;

	/**
	 * Assume default text representation type as British
	 */
	public Number(int i) {

		this.num = i;

		/**
		 * Handle negative number
		 */
		if (i < 0) {
			i = -1 * i;
		}

		int length = Integer.toString(i).length();

		if (length % NumberTextUtils.THREE == 0) {
			length = length / NumberTextUtils.THREE;
		} else if (length % NumberTextUtils.THREE > 0) {
			length = length / NumberTextUtils.THREE + 1;
		}

		this.triplets = new LinkedList<Triplet>();
		buildTriplets(i, length);
	}

	/**
	 * Allows for specifying text representation system, British, Indian etc
	 * text representationType could be enum - TextRepresentationType.BRITISH,
	 * TextRepresentationType.INDIAN. In Case of 'Indian', constants like Lac,
	 * Crore, should be added appropriately in NumberTextUtils.java
	 */
	public Number(int i, String representationType) {

	}

	/**
	 * @param num
	 * @param length
	 *            Builds triplet objects and arranges the position (hundredth,
	 *            tenth, unit) of the digits forming a triplet
	 */
	private void buildTriplets(int num, int length) {
		while (length != 0) {
			int tripletValue = num % 1000;

			Triplet triplet = new Triplet(tripletValue);
			triplet = triplet.matchTripletPlaces(tripletValue);

			System.out.println("triplet" + triplet.getHundredthPlace() + "."
					+ triplet.getTenthPlace() + ":" + triplet.getUnitPlace());
			((LinkedList<Triplet>) this.triplets).addFirst(triplet);

			num = num / NumberTextUtils.THOUSAND;
			length--;
		}
	}

	/**
	 * String representation of this number
	 * 
	 */
	public String toString() {

		/**
		 * When num = 0, returns "Zero" or if accessed thro
		 * 
		 */
		if (this.num == 0) {
			return NumberTextUtils.ZERO_TEXT;
		}

		StringBuilder numTextBuilder = new StringBuilder();

		/**
		 * Negative number
		 * 
		 */
		if (this.num < 0) {
			numTextBuilder.append("Negative ");
		}

		return constructEnglishText(this.triplets, numTextBuilder).toString();
	}

	/**
	 * Constructs the British English text from this group of triplets formed
	 * from
	 * 
	 * @param num
	 * @param triplets
	 *            List
	 */
	private StringBuilder constructEnglishText(List<Triplet> triplets,
			StringBuilder numTextBuilder) {
		int mapIndex = triplets.size();

		for (Triplet triplet : triplets) {
			numTextBuilder = numTextBuilder.append(triplet.toString()).append(
					" ");

			/**
			 * When num = 1,000,000: print only one million
			 */
			if (triplet.getHundredthPlace() == 0
					&& triplet.getTenthPlace() == 0
					&& triplet.getUnitPlace() == 0
					&& mapIndex < this.triplets.size()) {
				numTextBuilder = numTextBuilder.append("");
			} else {
				numTextBuilder = numTextBuilder.append(
						NumberTextUtils.tripletMap().get(mapIndex)).append(" ");
			}

			mapIndex--;
		}

		return numTextBuilder;
	}

	public int getNum() {
		return num;
	}

	public String getText() {
		return this.toString();
	}

	public List<Triplet> getTriplets() {
		return triplets;
	}

}
