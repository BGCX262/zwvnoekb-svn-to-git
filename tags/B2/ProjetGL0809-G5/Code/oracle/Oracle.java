package oracle;

import java.io.*;

//Class servant à faire la conversion des lignes decimale en hexadecimale
public class Oracle {
	
	//Méthode qui créer le fichier Oracle.txt, résultat de la conversion des lignes décimale en hexadecimale
	public static void oracleConversion(String fichierJDT, String fichierOrcl)  {
		/********** Les variables de la méthode **********/
		//Pour savoir si on est à la fin du fichier
		String ligneDonnee;
		boolean eof = false;
		boolean sautLigne = false; //Pour ne pas avoir une ligne vide à la fin du fichier convertit
		int format; //Pour faire le switch..case
		int indice ; //Pour parcourir la ligne
		String chaineDecimale; 
		String ligneConvert; //La ligne finale à écrire dans le nouveau fichier
		String hexa; //Pour la conversion de décimale en hexadecimale
		String noFormat; //Pour le numéro de format
		
		/***** Commencement : On ouvre le fichier à convertir en lecture et on en créer un autre en écriture *****/
		try {
			BufferedReader fichierSrc = new BufferedReader(new InputStreamReader(new FileInputStream(fichierJDT)));
			//On créer le nouveau fichier
			PrintWriter fichierDest = new PrintWriter(new FileWriter(fichierOrcl));
			//Tant qu'il reste des lignes à convertir on converti les lignes 
			while (eof != true) {
				ligneDonnee = fichierSrc.readLine(); //La ligne à convertir
				//Si la ligne est null on est à la fin du fichier
				if (ligneDonnee == null) {
					eof = true;
				}
				else {
					
					/** On récupère le numéro de la ligne **/
					ligneConvert = "";
					indice = 0;
					while (ligneDonnee.charAt(indice)!=' ') {
						ligneConvert += ligneDonnee.charAt(indice);
						indice++;
					}
					ligneConvert += " "; //L'espace qui separe le num ligne du code hexa
					
					/** On récupère le numéro de format **/
					indice = indice + 1;
					noFormat = ligneDonnee.substring(indice, (indice+2));
					format = 0;
					if (noFormat.equals("F1"))
						format = 1;
					if (noFormat.equals("F2"))
						format = 2;
					if (noFormat.equals("F3"))
						format = 3;
					
					//On avance jusqu'au début du code décimale
					indice = indice + 3; 
					//numDecimale = 0;
					chaineDecimale = "";
					
					/********** 3 cas **********/
					switch (format) {
					
					case 1: /********** Format 1 **********/
						if (ligneDonnee.charAt(indice) == '0') //Cas spéciale : 0
							ligneConvert += "00";
						else {
							while (indice < ligneDonnee.length()) {
								chaineDecimale += ligneDonnee.charAt(indice);
								indice++;
							}
							//Conversion du nombre decimale en hexa
							hexa = Integer.toHexString(Integer.parseInt(chaineDecimale));
							if(hexa.length()==1)
								ligneConvert += "0";
							ligneConvert += hexa.toUpperCase();
						}
					break;
					
					case 2: /********** Format 2 **********/
						if (ligneDonnee.equals("0000")) //Cas spéciale : 0
							ligneConvert += "0000";
						else {
							while (indice < ligneDonnee.length()) {
								if (ligneDonnee.charAt(indice) == ' ') {
									//Conversion du nombre decimale en hexa  
									hexa = Integer.toHexString(Integer.parseInt(chaineDecimale));
									if(hexa.length()==1)
										ligneConvert += "0";
									ligneConvert += hexa.toUpperCase();
									chaineDecimale = "";
								}
								else
									chaineDecimale += ligneDonnee.charAt(indice);
								indice++;
							}
							//Conversion du nombre decimale en hexa 
							hexa = Integer.toHexString(Integer.parseInt(chaineDecimale));
							if(hexa.length()==1)
								ligneConvert += "0";
							ligneConvert += hexa.toUpperCase();
						}
					break;
					
					case 3: /********** Format 3 **********/
						if (ligneDonnee.equals("00 00")) //Cas spéciale : 0
							ligneConvert += "00 00";
						else {
							while (indice < ligneDonnee.length()) {
								if (ligneDonnee.charAt(indice) == ' ') {
									//Conversion du nombre decimale en hexa  
									hexa = Integer.toHexString(Integer.parseInt(chaineDecimale));
									if(hexa.length()==1)
										ligneConvert += "0";
									ligneConvert += hexa.toUpperCase()+" ";
									chaineDecimale = "";
								}
								else
									chaineDecimale += ligneDonnee.charAt(indice);
								indice++;
							}
							//Conversion du nombre decimale en hexa  
							hexa = Integer.toHexString(Integer.parseInt(chaineDecimale));
							if(hexa.length()==1)
								ligneConvert += "0";
							ligneConvert += hexa.toUpperCase();
						}
					break;
					
					default: /********** Format 0 **********/
						while (indice < ligneDonnee.length()) {
							chaineDecimale += ligneDonnee.charAt(indice);
							indice++;
						}
						ligneConvert += chaineDecimale;
					break;
					}
					
					//On écrit enfin dans le fichier finale
					if (sautLigne)
						fichierDest.write("\n");
					else
						sautLigne = true;
					fichierDest.write(ligneConvert);
				}
			}
			
			/********** Conversion effectué. On ferme les fichiers **********/
			fichierSrc.close();
			fichierDest.close();
			System.out.println("Fichier Oracle.run généré");
		}
		/***** Si il y a des erreurs à l'ouverture ou à la création des fichiers *****/
		catch (Exception e) {
			System.out.println(e);
		}		
	}

}
