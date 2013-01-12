package numbertextoop;

/**
 * Test Class with main() for Number.java
 * 
 * @author sanjeev
 * 
 */
public class TestNumber {

  public static void main(String[] args) {
		int num = -1001145;
		Number number = new Number(num);

		sop(num + " in British English Phrase using OOP: " + number.getText());
	}

	private static void sop(Object o) {
		System.out.println(o);
	}

}
