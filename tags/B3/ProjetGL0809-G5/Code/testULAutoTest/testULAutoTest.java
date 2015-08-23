package testULAutoTest;
import autoTest.*;
import comparateur.*;

public class testULAutoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			AutoTest.testTraitFormat("Data tests\\TestTraitFormat.jdt", "Data tests\\JDT.run");
			Comparateur.fichier("Data tests\\JDT.run","Data tests\\JDT.ref","Data tests\\eval.txt");
	}
}
