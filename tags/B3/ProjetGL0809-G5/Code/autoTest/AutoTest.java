package autoTest;
import java.io.*;
import stub.*;

public class AutoTest {
	public static void testTraitFormat(String fichierJdt, String fichierRun){
		try{
			//ouverture du jdt
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fichierJdt)));
			//création du fichier jdt.run
			PrintWriter result = new PrintWriter(new FileWriter(fichierRun));
			
			String lectureLigneFichierTest;
			//tant que l'on peut lire le fichier
			while((lectureLigneFichierTest = br.readLine()) != null){
				String numLigne = "";
				String chaineHexadecimal = "";
				
				//on récupère le numéro de la ligne
				int indice = 0;
				while (lectureLigneFichierTest.charAt(indice)!=' ') {
					numLigne += lectureLigneFichierTest.charAt(indice);
					indice++;
				}
				
				//on récupère la chaine hexadécimal
				int j;
				for(j= indice +1;j<=lectureLigneFichierTest.length()-1;j++){
					chaineHexadecimal += lectureLigneFichierTest.charAt(j);
				}
				//on envoie au stub
				Format res = Stub.TraitdeFormat(chaineHexadecimal);
				//on écrit le résultat dans un fichier
				result.println(numLigne + " " + res);
			}
			//on arrête de lire et d'écrire dans les fichiers 
			br.close();
			result.close();
			System.out.println("Fichier " + fichierRun + " g�n�r�.");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
