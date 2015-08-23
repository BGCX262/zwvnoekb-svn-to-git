package testULStub;
import stub.*;
import java.io.*;
import comparateur.*;

public class TestULStub {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//ouverture du JDT
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Data tests\\TestTraitFormat.jdt")));
			
			//création d'un fichier de résultat de test
			PrintWriter result = new PrintWriter(new FileWriter("Data tests\\JDT.run"));
			
			String ligneFichier;
			while((ligneFichier = br.readLine()) != null){
							
				String valeur = ligneFichier.substring(4);
				
				Format res = Stub.TraitdeFormat(valeur);
									
				result.println(ligneFichier.substring(0, 3) + " " + res);
			
			}
			br.close();
			result.close();
			Comparateur.fichier("Data tests\\JDT.ref", "Data tests\\JDT.run", "Data tests\\eval.txt");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
