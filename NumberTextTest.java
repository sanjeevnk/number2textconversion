package numbertextalgo;

/**
 * Stand-alone test class for NumberText.java
 * 
 * 04/14/2012
 * @author sanjeev
 */
public class NumberTextTest {

  public static void main(String[] args) {
		int num = 1230;
		sop(num + " in British English phrase: "
				+ NumberText.numberToString(num));
	}

	private static void sop(Object o) {
		System.out.println(o);
	}

}
