package comparateur;
import java.io.*;

public class Comparateur {
	public static void fichier(String fichier1,String fichier2, String fichierEvaluation){

		try{
			//ouverture du premier fichier
			BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(fichier1)));
			
			//ouverture du second fichier
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(fichier2)));
			
			//création du fichier résultat
			PrintWriter result = new PrintWriter(new FileWriter(fichierEvaluation));
			
			//création de variable de type string
			String lectureLigneFichier1,lectureLigneFichier2;
			
			//on initialise un booléen 'longueurFichierIdentique' à true qui passera à false si les 2 fichiers n'ont pas la même quantité de ligne 
			boolean fichiersIdentique = true;
			
			//on cr�� une variable qui va servir de compteur pour d�terminer le nombre de ligne test�e.
			int nbLigneTeste = 0;
			
			//tant que l'on peut lire les 2 fichiers			
			while(br1.ready() && br2.ready()){
				nbLigneTeste++;
				lectureLigneFichier1 = br1.readLine();
				lectureLigneFichier2 = br2.readLine();
				//si les lignes sont différentes on l'insert dans le fichier de résultat
				if(!lectureLigneFichier1.equals(lectureLigneFichier2)){
					result.println("Lignes non identiques : ["+ lectureLigneFichier1 + "] [" + lectureLigneFichier2 +"]");
					fichiersIdentique = false;
				}
			}
			
			//si il est possible de lire l'un des 2 fichiers, c'est que l'un possède plus de données que l'autre
			if(br1.readLine() != null){
				result.println("Le fichier 1 comporte plus de donn�es que le fichier 2");
			}
			else{
				if(br2.readLine() != null){
					result.println("Le fichier 2 comporte plus de donn�es que le fichier 1");
				}
				else{
					if(fichiersIdentique) //si toute les lignes sont identiques et que les fichiers on le même nombre de données, les 2 fichiers sont identiques
						result.println("Les 2 fichiers sont identiques");
				}
			}
			
			//on pr�cise le nombre de ligne test�s
			result.println("Nombre de ligne test�e(s) : "+nbLigneTeste);
			
			//fermeture des 3 fichiers
			br1.close();
			br2.close();
			result.close();
			System.out.println("Fichier " + fichierEvaluation + " g�n�r�.");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
