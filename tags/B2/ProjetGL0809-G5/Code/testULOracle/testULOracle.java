package testULOracle;
import oracle.*;
import comparateur.*;

public class testULOracle {

	public static void main(String[] args) {
		
		//On appelle la méthode pour tester
		Oracle.oracleConversion("Data tests\\JDT.ref","Data tests\\Oracle.run");
		Comparateur.fichier("Data tests\\TestTraitFormat.jdt", "Data tests\\Oracle.run", "Data tests\\eval.txt");
	}

}
